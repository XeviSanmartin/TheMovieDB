package cat.institutmontivi.themoviedb.ui.pantalles

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.institutmontivi.themoviedb.dades.xarxa.TheMovieDBHelperImpl
import cat.institutmontivi.themoviedb.dades.xarxa.theMovieDBClient
import cat.institutmontivi.themoviedb.model.Cast
import cat.institutmontivi.themoviedb.model.toCast
import cat.institutmontivi.themoviedb.navegacio.ArgumentDeNavegacio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LlistaActorsViewModel (savedStateHandle: SavedStateHandle): ViewModel() {
    private val parametre = savedStateHandle.get<Int>(ArgumentDeNavegacio.IdPeli.clau) ?: 0
    private var _estat = MutableStateFlow<LlistaActorsEstat>(LlistaActorsEstat())
    val estat: StateFlow<LlistaActorsEstat> = _estat.asStateFlow()

    val apiHelper = TheMovieDBHelperImpl(theMovieDBClient.servei)
    init {
        obtenActorsDUnaPeli(parametre)
    }

    fun obtenActorsDUnaPeli(idPeli:Int = 1) {

        viewModelScope.launch(Dispatchers.IO) {
            _estat.value = estat.value.copy(estaCarregant = true)
            apiHelper.getActorsPeli(filmId = idPeli)
                .collect {
                    val resposta = it
                    val actors = resposta.cast
                        .map { actor->actor.toCast() }
                    _estat.value = estat.value.copy(actors = actors, estaCarregant = false)
                }
        }
    }
}
data class LlistaActorsEstat (
    val estaCarregant:Boolean = true,
    val esErroni:Boolean = false,
    val missatge:String = "",
    val actors:List<Cast> = listOf(),
)