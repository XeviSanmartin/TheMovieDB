package cat.institutmontivi.themoviedb.dades.xarxa

import cat.institutmontivi.themoviedb.model.ApiRespostaGetActorsDUnaPeli
import cat.institutmontivi.themoviedb.model.ApiRespostaGetPopulars
import kotlinx.coroutines.flow.Flow

interface TheMovieDBHelper {
    fun getPelisPopularsStringFlow(
        apikey: String= theMovieDBClient.API_KEY,
        page: Int = 1,
        language: String = "ca-ES"
    ): Flow<String>

    fun getPelisPopulars(
        apikey: String= theMovieDBClient.API_KEY,
        page: Int = 1,
        language: String = "ca-ES"
    ): Flow<ApiRespostaGetPopulars>

    fun getActorsPeli(
        filmId: Int,
        language: String = "ca-ES",
        apiKey: String = theMovieDBClient.API_KEY
    ): Flow<ApiRespostaGetActorsDUnaPeli>
}