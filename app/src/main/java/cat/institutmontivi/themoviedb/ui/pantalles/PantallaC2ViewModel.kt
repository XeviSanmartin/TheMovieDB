package cat.institutmontivi.themoviedb.ui.pantalles

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import cat.institutmontivi.themoviedb.navegacio.ArgumentDeNavegacio

class PantallaC2ViewModel (savedStateHandle: SavedStateHandle): ViewModel() {

    private val parametre = savedStateHandle.get<String>(ArgumentDeNavegacio.IdArg4.clau) ?: "Paràmetre per defecte"
    var estat by mutableStateOf(PantallaC2Estat())
        private set

    init {
        estat = PantallaC2Estat(dada1 = "", dada2 = parametre)
        metode1()

    }

    fun metode1()
    {
        estat=PantallaC2Estat(dada1 = "Dada1")
    }
    data class PantallaC2Estat(
        val dada1:String = "",
        val dada2:String =""

    )
}