package cat.institutmontivi.themoviedb.navegacio

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import cat.institutmontivi.themoviedb.ui.pantalles.Instruccions
import cat.institutmontivi.themoviedb.ui.pantalles.PantallaA
import cat.institutmontivi.themoviedb.ui.pantalles.PantallaB
import cat.institutmontivi.themoviedb.ui.pantalles.PantallaC1
import cat.institutmontivi.themoviedb.ui.pantalles.PantallaC2
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
        navigation(startDestination = Destinacio.PantallaA.rutaBase,route =CategoriaDeNavegacio.PantallaA.rutaPrevia)
        {
            composable(route = Destinacio.PantallaA.rutaGenerica){
                PantallaA()
            }
        }
        navigation(startDestination = Destinacio.PantallaB.rutaBase,route =CategoriaDeNavegacio.PantallaB.rutaPrevia)
        {
            composable(route = Destinacio.PantallaB.rutaGenerica){
                PantallaB()
            }
        }
        navigation(startDestination = Destinacio.PantallaC1.rutaBase,route =CategoriaDeNavegacio.PantallaC1.rutaPrevia)
        {
            composable(route = Destinacio.PantallaC1.rutaGenerica){
                PantallaC1(onClick = {arg1:String -> controladorDeNavegacio.navigate(Destinacio.PantallaC2.CreaRutaAmbArguments(arg1))})
            }
            composable (route = Destinacio.PantallaC2.rutaGenerica, arguments = Destinacio.PantallaC2.navArgs){
                val argument1 = it.arguments?.getString(ArgumentDeNavegacio.IdArg4.clau) ?: ""
                requireNotNull(argument1)
                PantallaC2(argument1)
            }
        }
    }
}