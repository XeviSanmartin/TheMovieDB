package cat.institutmontivi.themoviedb.navegacio

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument


enum class CategoriaDeNavegacio(
    val rutaPrevia: String,
    val icona: ImageVector,
    val titol: String
){
    Portada ("Portada", Icons.Default.Home, "Portada"),
    PelisPopularsString("PelisPopularsString", Icons.Default.AddCircle,"PelisPopularsString"),
    PelisPopularsStringFlow("PelisPopularsStringFlow", Icons.Default.Create,"PelisPopularsStringFlow"),
    PelisPopulars("PelisPopulars", Icons.Default.Face,"PelisPopulars"),
    Preferencies ("Preferencies", Icons.Default.Build, "Preferencies"),
    Instruccions ("Instruccions", Icons.Default.Info, "Instruccions"),
    QuantA ("QuantA", Icons.Default.Face, "Quant a...")
}
sealed class Destinacio(
    val rutaBase: String,
    val argumentsDeNavegacio: List <ArgumentDeNavegacio> = emptyList()
)
{

    val navArgs = argumentsDeNavegacio.map { it.toNavArgument()}
    /**
     * Propietat que crea l'string amb la ruta base i tots els arguments separats per barres
     */
    val rutaGenerica = run {
        //cal construir un string tipus: rutabase/{arg1}/{arg2} ...
        val clausArguments = argumentsDeNavegacio.map{"{${it.clau}}"}
        listOf(rutaBase)
            .plus(clausArguments)
            .joinToString("/")
    }

    object Portada: Destinacio(CategoriaDeNavegacio.Portada.rutaPrevia+"/Inici")
    object Preferencies: Destinacio(CategoriaDeNavegacio.Preferencies.rutaPrevia+"/Inici")
    object Instruccions: Destinacio(CategoriaDeNavegacio.Instruccions.rutaPrevia+"/Inici")
    object QuantA: Destinacio(CategoriaDeNavegacio.QuantA.rutaPrevia+"/Inici")
    object PelisPopularsString:Destinacio(CategoriaDeNavegacio.PelisPopularsString.rutaPrevia+"/Inici")
    object PelisPopularsStringFlow:Destinacio(CategoriaDeNavegacio.PelisPopularsStringFlow.rutaPrevia+"/Inici")
    object PelisPopulars:Destinacio(CategoriaDeNavegacio.PelisPopulars.rutaPrevia+"/Inici")
    object LlistaActors:Destinacio(CategoriaDeNavegacio.PelisPopulars.rutaPrevia+"/Actors",listOf(ArgumentDeNavegacio.IdPeli)) {
        fun CreaRutaAmbArguments(idPeli: Int) = "$rutaBase/$idPeli"
    }
}

//NavType<*> ens permet identificar qualsevol tipus de NavType
enum class ArgumentDeNavegacio (val clau: String, val tipus: NavType<*>){
    IdPeli("IdPeli", NavType.IntType),
    IdArg3("IdArg3", NavType.IntType),
    IdArg4("IdArg4", NavType.StringType);

    fun toNavArgument (): NamedNavArgument {
        return navArgument(clau) {type = tipus}
    }
}
