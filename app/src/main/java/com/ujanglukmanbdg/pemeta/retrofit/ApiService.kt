package com.ujanglukmanbdg.pemeta.retrofit

import com.ujanglukmanbdg.pemeta.data.database.response.LoginResponse
import com.ujanglukmanbdg.pemeta.data.database.response.ResultResponse
import com.ujanglukmanbdg.pemeta.data.database.response.DataReport
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    fun postRegister(
        @Field("name") name: String,
        @Field("email") email : String,
        @Field("password") password: String
    ): Call<ResultResponse>

    @FormUrlEncoded
    @POST("login")
    fun postLogin(
        @Field("email") email : String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @Multipart
    @POST("stories")
    fun postStory(
        @Header("Authorization") token: String,
        @Part("description") description: RequestBody,
        @Part photo: MultipartBody.Part,
        @Part("lat") lat: Float?,
        @Part("lon") lon: Float?,
    ): Call<DataReport>

    @GET("stories?location=1")
    fun getStories(
        @Header("Authorization") token: String,
    ): Call<DataReport>

    @GET("stories?location=0")
    suspend fun getAllStories(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ) : DataReport
}