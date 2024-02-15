package cat.institutmontivi.themoviedb.ui.pantalles

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.institutmontivi.themoviedb.dades.xarxa.theMovieDBClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PelisPopularsStringViewModel : ViewModel() {
    var estat by mutableStateOf(PelisPopularsStringEstat())
        private set


    init {
        obtenPelisPopulars(1)
    }

    public fun obtenPelisPopulars(plana:Int = 1) {
        //Hem de posar el Dispatchers del Main perque els mutableState no són thead safe
        //I si posem un altre dispatcher que no sigui el main, petarà
        viewModelScope.launch(Dispatchers.Main) {
            estat = estat.copy(estaCarregant = true)
            val resposta = theMovieDBClient.servei.getPelisPopularsString(page = plana)
            estat = estat.copy(estaCarregant = false, stringJson = resposta, plana= plana, totalPlanes = 5)
        }
    }


data class PelisPopularsStringEstat (
    val estaCarregant:Boolean = true,
    val esErroni:Boolean = false,
    val missatge:String = "",
    val stringJson:String = "",
    val plana:Int = 1,
    val totalPlanes:Int = 1
)

}