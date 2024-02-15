package cat.institutmontivi.themoviedb.model


import com.google.gson.annotations.SerializedName

data class ApiRespostaGetActorsDUnaPeli(
    @SerializedName("cast")
    val cast: List<ApiCast>,
    @SerializedName("crew")
    val crew: List<ApiCrew>,
    @SerializedName("id")
    val id: Int
)