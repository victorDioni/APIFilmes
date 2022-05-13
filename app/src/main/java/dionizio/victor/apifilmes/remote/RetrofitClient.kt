package dionizio.victor.apifilmes.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        private lateinit var retrofit: Retrofit
        private const val BASE_URL = "https://api.themoviedb.org/3/"

        private fun getRetrofitInstance(): Retrofit{
            val httpClient = httpBuilder()
            retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(httpClient)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit
        }

        private fun httpBuilder(): OkHttpClient {
            return OkHttpClient.Builder().build()

        }
    }
}