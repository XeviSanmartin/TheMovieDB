package cat.institutmontivi.themoviedb.ui.pantalles

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun PantallaC1 (onClick:(String)->Unit = {})
{
    Column(Modifier.fillMaxSize(). background(color = MaterialTheme.colorScheme.surfaceVariant))
    {
        Text(text = "Pantalla A",
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center)


        Boto (Modifier.align(alignment = Alignment.CenterHorizontally),text = "Fes Click", clic ={onClick("Paràmetre")} )
    }
}
@Composable
fun Boto (modifier: Modifier = Modifier, text: String = "", clic: ()->Unit)
{
    OutlinedButton(
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 8.dp,
            disabledElevation = 0.dp
        ),
        onClick = clic,
        shape = RoundedCornerShape(28.dp),
        modifier = modifier,
        contentPadding = PaddingValues(15.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .align(alignment = Alignment.CenterVertically) )
        {
            Text(
                text = text,
                color = MaterialTheme.colorScheme.onSecondary,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            )
        }

    }
}