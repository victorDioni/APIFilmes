package dionizio.victor.apifilmes.data.remote

import dionizio.victor.apifilmes.data.model.ResultsModel
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {
    @GET("movie/upcoming")
    fun listMovies(): Call<ResultsModel>
}