package cat.institutmontivi.themoviedb.model


import com.google.gson.annotations.SerializedName

data class ApiRespostaGetPopulars(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<ApiPelisPopulars>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)