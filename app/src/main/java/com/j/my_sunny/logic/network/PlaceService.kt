package com.j.my_sunny.logic.network

import PlaceResponse
import com.j.my_sunny.SunnyWeatherApplication
import retrofit2.Call//这个包很重要，不要导错了
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
    //GET请求
    @GET("v2/palce?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query:String): Call<PlaceResponse>//将返回的json格式对象解析成PlaceResponse
}