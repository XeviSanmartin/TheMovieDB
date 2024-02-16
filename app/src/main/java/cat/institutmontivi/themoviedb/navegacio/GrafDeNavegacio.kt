package cat.institutmontivi.themoviedb.navegacio

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import cat.institutmontivi.themoviedb.ui.pantalles.Instruccions
import cat.institutmontivi.themoviedb.ui.pantalles.LlistaActors
import cat.institutmontivi.themoviedb.ui.pantalles.PelisPopulars
import cat.institutmontivi.themoviedb.ui.pantalles.PelisPopularsString
import cat.institutmontivi.themoviedb.ui.pantalles.PelisPopularsStringFlow
import cat.institutmontivi.themoviedb.ui.pantalles.Portada
import cat.institutmontivi.themoviedb.ui.pantalles.Preferencies
import cat.institutmontivi.themoviedb.ui.pantalles.QuantA


@Composable
fun GrafDeNavegacio (controladorDeNavegacio: NavHostController = rememberNavController())
{
    NavHost(navController = controladorDeNavegacio, startDestination =CategoriaDeNavegacio.Portada.rutaPrevia)
    {
        navigation(startDestination = Destinacio.Portada.rutaBase,route =CategoriaDeNavegacio.Portada.rutaPrevia )
        {
            composable(route = Destinacio.Portada.rutaGenerica){
                Portada()
            }
        }

        navigation(startDestination = Destinacio.Instruccions.rutaBase,route =CategoriaDeNavegacio.Instruccions.rutaPrevia )
        {
            composable(route = Destinacio.Instruccions.rutaGenerica){
                Instruccions()
            }
        }
        navigation(startDestination = Destinacio.Preferencies.rutaBase,route =CategoriaDeNavegacio.Preferencies.rutaPrevia)
        {
            composable(route = Destinacio.Preferencies.rutaGenerica){
                Preferencies()
            }
        }
        navigation(startDestination = Destinacio.QuantA.rutaBase,route =CategoriaDeNavegacio.QuantA.rutaPrevia)
        {
            composable(route = Destinacio.QuantA.rutaGenerica){
                QuantA()
            }
        }
        navigation(startDestination = Destinacio.PelisPopularsString.rutaBase,route =CategoriaDeNavegacio.PelisPopularsString.rutaPrevia)
        {
            composable(route = Destinacio.PelisPopularsString.rutaGenerica){
                PelisPopularsString()
            }
        }
        navigation(startDestination = Destinacio.PelisPopularsStringFlow.rutaBase,route =CategoriaDeNavegacio.PelisPopularsStringFlow.rutaPrevia)
        {
            composable(route = Destinacio.PelisPopularsStringFlow.rutaGenerica){
                PelisPopularsStringFlow()
            }
        }
        navigation(startDestination = Destinacio.PelisPopulars.rutaBase,route =CategoriaDeNavegacio.PelisPopulars.rutaPrevia)
        {
            composable(route = Destinacio.PelisPopulars.rutaGenerica){
                PelisPopulars(onClic = {arg1:Int -> controladorDeNavegacio.navigate(Destinacio.LlistaActors.CreaRutaAmbArguments(arg1))})
            }
            composable (route = Destinacio.LlistaActors.rutaGenerica, arguments = Destinacio.LlistaActors.navArgs){
                val argument1 = it.arguments?.getInt(ArgumentDeNavegacio.IdPeli.clau) ?: 1
                requireNotNull(argument1)
                LlistaActors(argument1)
            }
        }
    }
}