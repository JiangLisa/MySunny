package com.j.my_sunny.logic.network


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

//统一的网络数据源访问入口
object SunnyNetwork {
    //placeService的动态代理对象
    private val placeService=ServiceCreator.create<PlaceService>()
    //调用placeService接口中的searchPlaces方法用来搜索城市数据请求
    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()//挂起函数
    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}