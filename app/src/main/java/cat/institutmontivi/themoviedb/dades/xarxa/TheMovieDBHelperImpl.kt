package cat.institutmontivi.themoviedb.dades.xarxa

import cat.institutmontivi.themoviedb.model.ApiRespostaGetActorsDUnaPeli
import cat.institutmontivi.themoviedb.model.ApiRespostaGetPopulars
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class TheMovieDBHelperImpl (private val apiService:TheMovieDBService) : TheMovieDBHelper{
    override fun getPelisPopularsStringFlow(apikey: String, page: Int, language: String): Flow<String> =
        flow {
            emit(apiService.getPelisPopularsString(apikey, page, language))
        }


    override fun getPelisPopulars(
        apikey: String,
        page: Int,
        language: String
    ): Flow<ApiRespostaGetPopulars> =
        flow {
            emit(apiService.getPelisPopulars(apikey, page, language))
        }

    override fun getActorsPeli(
        filmId: Int,
        language: String,
        apiKey: String
    ): Flow<ApiRespostaGetActorsDUnaPeli> =
        flow {
            emit(apiService.getActorsPeli(filmId, language, apiKey))
        }

}