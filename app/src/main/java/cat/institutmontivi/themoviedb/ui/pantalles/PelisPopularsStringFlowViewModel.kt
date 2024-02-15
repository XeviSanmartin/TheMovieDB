package cat.institutmontivi.themoviedb.ui.pantalles

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.institutmontivi.themoviedb.dades.xarxa.TheMovieDBHelperImpl
import cat.institutmontivi.themoviedb.dades.xarxa.TheMovieDBService
import cat.institutmontivi.themoviedb.dades.xarxa.theMovieDBClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.xml.transform.sax.TemplatesHandler

class PelisPopularsStringFlowViewModel : ViewModel() {
    private var _estat = MutableStateFlow<PelisPopularsStringFlowEstat>(PelisPopularsStringFlowEstat())
    val estat: StateFlow<PelisPopularsStringFlowEstat> = _estat.asStateFlow()

    val apiHelper = TheMovieDBHelperImpl(theMovieDBClient.servei)
    init {
        obtenPelisPopulars(1)
    }

    fun obtenPelisPopulars(plana:Int = 1) {

        viewModelScope.launch(Dispatchers.IO) {
            _estat.value = estat.value.copy(estaCarregant = true)
            apiHelper.getPelisPopularsStringFlow( page= plana)
                //.flowOn(Dispatchers.IO)
                .collect {
                    //Modificar el value del Flow fa que emeti un nou valor sempre que
                    //realment es modifiqui, StateFlow no emet valors iguals consecutius
                    //_estat.value = estat.value.copy(stringJson = it, estaCarregant = false, plana= plana, totalPlanes = 5)


                    //Una altra manera d'emetre un valor nou és fer servir update
                    //És el mateix que canviar el value, però ens asegura que la operació
                    //update serà atòmica i no perdrem l'ús de la CPU fins acabar-la
                    //val valor = it
                    //_estat.update {
                    //    estat.value.copy(stringJson = valor, estaCarregant = false, plana= plana, totalPlanes = 5)
                    //}

                    //La tercera manera és utilitzar el mètode emit, que internament
                    //utilitza value=nouvalor i és una funció suspend
                    val valor = it
                    _estat.emit(
                        estat.value.copy(stringJson = valor, estaCarregant = false, plana= plana, totalPlanes = 5)
                    )
                }
        }
    }

    data class PelisPopularsStringFlowEstat(
        val estaCarregant: Boolean = true,
        val esErroni: Boolean = false,
        val missatge: String = "",
        val stringJson: String = "",
        val plana:Int = 1,
        val totalPlanes:Int = 1
    )
}


