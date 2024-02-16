package cat.institutmontivi.themoviedb.dades.xarxa

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object theMovieDBClient {
    const val API_KEY = "96b88425b747be1a846e71f5bac3a680"
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val BASE_URL_IMG = "https://image.tmdb.org/t/p/w500/"
    const val BASE_URL_IMG_MIDA_ORIGINAL = "https://image.tmdb.org/t/p/ORIGINAL/"

    val gson = GsonBuilder()
        .setLenient()
        .create()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        //.addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val servei = retrofit.create(TheMovieDBService::class.java)
}