package cat.institutmontivi.themoviedb.ui.pantalles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.institutmontivi.themoviedb.dades.xarxa.TheMovieDBHelperImpl
import cat.institutmontivi.themoviedb.dades.xarxa.theMovieDBClient
import cat.institutmontivi.themoviedb.model.Pelicula
import cat.institutmontivi.themoviedb.model.toPelicula
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PelisPopularsViewModel:ViewModel() {

    private var _estat = MutableStateFlow<PelisPopularsEstat>(PelisPopularsEstat())
    val estat: StateFlow<PelisPopularsEstat> = _estat.asStateFlow()

    val apiHelper = TheMovieDBHelperImpl(theMovieDBClient.servei)
    init {
        obtenPelisPopulars(1)
    }

    fun obtenPelisPopulars(plana:Int = 1) {

        viewModelScope.launch(Dispatchers.IO) {
            _estat.value = estat.value.copy(estaCarregant = true)
            apiHelper.getPelisPopulars(page = plana)
                .collect {
                    val resposta = it
                    val pelis = resposta.results
                        .map { peli->peli.toPelicula() }
                  _estat.value = estat.value.copy(pelis = pelis, estaCarregant = false, plana= plana, totalPlanes = resposta.totalPages)
                }
        }
    }
}
    data class PelisPopularsEstat (
        val estaCarregant:Boolean = true,
        val esErroni:Boolean = false,
        val missatge:String = "",
        val pelis:List<Pelicula> = listOf(),
        val plana:Int = 1,
        val totalPlanes:Int = 1
    )