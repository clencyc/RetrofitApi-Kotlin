package com.example.marsphotos.network


import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com/"
// The converter tells Retrofit what to do with the data it gets back from the web service
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

// define an interface called MarsAPIService that defines
// how Retrofit talks to the web server using HTTP requests.
interface MarsAPiService {
    // to show retrofit that this is a get request
    @GET("photos")
    suspend fun getPhotos(): String
}

object MarsApi {
    val retrofitService : MarsAPiService by lazy {
        retrofit.create(MarsAPiService::class.java)
    }
}

