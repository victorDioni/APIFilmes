package dionizio.victor.apifilmes.data.repository

import dionizio.victor.apifilmes.data.model.ResultsModel
import dionizio.victor.apifilmes.data.remote.MovieService
import dionizio.victor.apifilmes.data.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository {
    private val retrofitClient = RetrofitClient.createService(MovieService::class.java)

    fun listMovies(){
        val call: Call<ResultsModel> = retrofitClient.listMovies()

        call.enqueue(object : Callback<ResultsModel>{
            override fun onResponse(call: Call<ResultsModel>, response: Response<ResultsModel>) {
                if(response.isSuccessful){
                    val q = response
                }
            }

            override fun onFailure(call: Call<ResultsModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}