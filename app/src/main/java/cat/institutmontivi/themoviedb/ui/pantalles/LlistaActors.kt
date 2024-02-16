package cat.institutmontivi.themoviedb.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.institutmontivi.themoviedb.dades.xarxa.theMovieDBClient
import cat.institutmontivi.themoviedb.model.Cast
import coil.compose.AsyncImage

@Preview
@Composable
fun LlistaActors (parametre: Int = 1, viewModel: LlistaActorsViewModel = androidx.lifecycle.viewmodel.compose.viewModel())
{
    val estat = viewModel.estat.collectAsState()
    Column (
        Modifier
            .background(MaterialTheme.colorScheme.secondary)
            .padding(8.dp)
            .fillMaxSize()
    ){
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(4.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            ){
            items(estat.value.actors)
            {actor ->
                Actor(actor)
            }
        }
    }
}

@Composable
fun Actor(actor: Cast) {
    Column(
        modifier = Modifier
            //.height(intrinsicSize = IntrinsicSize.Max)
            //.wrapContentHeight()
            .padding(all = 4.dp)
        ,
        horizontalAlignment = Alignment.Start
    ) {
        Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer, contentColor = MaterialTheme.colorScheme.onSecondaryContainer))
        {
            AsyncImage(
                model = theMovieDBClient.BASE_URL_IMG + actor.profilePath,
                contentDescription = "foto de l'actor"
            )
            Text(
                text = actor.character,

                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = "("+actor.name+")",

                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}
