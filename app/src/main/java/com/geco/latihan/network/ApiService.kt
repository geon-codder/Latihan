package com.geco.latihan.network

import com.geco.latihan.data.ResponseBody
import com.geco.latihan.data.SignInBody
import com.geco.latihan.data.UserBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


interface ApiService {

    @POST("auth/login")
    fun signin(@Body info: SignInBody): Call<ResponseBody>

    @POST("auth/register")
    fun signup(@Body info: UserBody) : Call<ResponseBody>
}
class RetrofitInstance {
    companion object {
        private const val BASE_URL = "https://market-final-project.herokuapp.com/"

        private val logging: HttpLoggingInterceptor
            get() {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                return httpLoggingInterceptor.apply {
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                }
            }


        fun getInstance(): ApiService {
            val instance: ApiService by lazy {
                val client = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build()

                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()

                retrofit.create(ApiService::class.java)
            }
            return instance
        }
    }
}