package cat.institutmontivi.themoviedb.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.institutmontivi.themoviedb.dades.xarxa.theMovieDBClient
import coil.compose.AsyncImage

@Preview
@Composable
fun PelisPopulars (viewModel: PelisPopularsViewModel = androidx.lifecycle.viewmodel.compose.viewModel(), onClic: (Int)->Unit = {})
{
    val estat = viewModel.estat.collectAsState()
    Column (
        Modifier
            .background(MaterialTheme.colorScheme.secondary)
            .padding(8.dp)
            .fillMaxSize()
    ){
        PaginadorPelisPopulars(estat = estat , viewModel = viewModel )
        Spacer(modifier = Modifier.height(8.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),

            contentPadding = PaddingValues(4.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),


            ){
            items(estat.value.pelis)
            {peli ->

                ElementDePelicula(imageUrl = peli.posterPath,
                    titol = peli.title,
                    id= peli.id,
                    Modifier
                ) {
                    onClic(peli.id)
                }

            }
        }
    }
}

@Composable
fun PaginadorPelisPopulars(
    estat: State<PelisPopularsEstat>,
    viewModel: PelisPopularsViewModel
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.secondary),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        if (estat.value.plana != 1) {
            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                "",
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        viewModel.obtenPelisPopulars(estat.value.plana - 1)
                    })
        } else {
            Spacer(modifier = Modifier.width(32.dp))
        }
        Text(
            text = "Plana ${estat.value.plana} de ${estat.value.totalPlanes}",
            color = MaterialTheme.colorScheme.onSecondary,
            fontSize = 24.sp
        )
        if (estat.value.plana != estat.value.totalPlanes) {
            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, "",
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        viewModel.obtenPelisPopulars(estat.value.plana + 1)
                    })
        } else {
            Spacer(modifier = Modifier.width(32.dp))
        }
    }
}
@Composable
fun ElementDePelicula(
    imageUrl: String,
    titol: String,
    id:Int,
    modifier: Modifier = Modifier,
    onclick: (Int) -> Unit ={}
) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .padding(all = 4.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null){onclick(id)} ,
        horizontalAlignment = Alignment.Start
    ) {
        AsyncImage(
            model = theMovieDBClient.BASE_URL_IMG+imageUrl,
            contentDescription = "caca"
        )
        Text(text = retallaText(titol, 20),
            color = MaterialTheme.colorScheme.onSecondary,
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

    }
}

private fun retallaText(text: String, mida: Int) = if (text.length <= mida) text else {
    val textAmbEllipsis = text.removeRange(startIndex = mida, endIndex = text.length)
    "$textAmbEllipsis..."
}