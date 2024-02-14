package cat.institutmontivi.themoviedb.ui.pantalles

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PantallaBViewModel : ViewModel() {
    var estat by mutableStateOf(PantallaBEstat())
        private set


    init {
        estat = PantallaBEstat(dada1 = 0, dada2 = 0)
    }

    fun metoda1()
    {

    }
}

data class PantallaBEstat (
    val dada1:Int = 0,
    val dada2:Long = 1000
)