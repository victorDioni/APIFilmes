package dionizio.victor.apifilmes.data.remote

import dionizio.victor.apifilmes.data.MovieConsts
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        private lateinit var retrofit: Retrofit
        private const val BASE_URL = "https://api.themoviedb.org/3/"

        private fun getRetrofitInstance(): Retrofit{
            val httpClient = httpBuilder()
            if(!::retrofit.isInitialized){ // Singleton
                retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit
        }

        private fun httpBuilder(): OkHttpClient.Builder {
            val httpClient = OkHttpClient.Builder()
            return httpClient.addInterceptor(CustomInterceptor())

        }

        fun <V> createService(serviceClass: Class<V>): V{
            return getRetrofitInstance().create(serviceClass)
        }
    }
}


class CustomInterceptor: Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url.newBuilder().addQueryParameter(MovieConsts.HEADER.API_KEY_NAME
            , MovieConsts.HEADER.API_KEY_VALUE).addQueryParameter(MovieConsts.HEADER.LANGUAGE
            , MovieConsts.HEADER.LANGUAGE_VALUE).build()

        val request = chain.request().newBuilder().url(url).build()

        return chain.proceed(request)
    }

}

