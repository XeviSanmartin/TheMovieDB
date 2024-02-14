package cat.institutmontivi.themoviedb.ui.pantalles

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun PantallaC2 (parametre: String = "Paràmetre per defecte", viewModel: PantallaC2ViewModel = androidx.lifecycle.viewmodel.compose.viewModel())
{
    Box(
        Modifier
            .fillMaxSize()
            ){
        Text(text = viewModel.estat.dada1, Modifier.align(Alignment.TopCenter), style = MaterialTheme.typography.displaySmall)

        Text(text = viewModel.estat.dada2, Modifier.align(Alignment.BottomCenter), style = MaterialTheme.typography.displayMedium)
    }
}