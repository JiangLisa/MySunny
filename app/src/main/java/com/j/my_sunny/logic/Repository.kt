package com.j.my_sunny.logic


import Place
import androidx.lifecycle.liveData
import com.j.my_sunny.logic.network.SunnyNetwork
import kotlinx.coroutines.Dispatchers

object Repository {
    fun searchPlaces(query: String) = liveData(Dispatchers.IO){
        var result =try{
        val placeResponse = SunnyNetwork.searchPlaces(query)
        if (placeResponse.status == "ok") {
            val places = placeResponse.places
            Result.success(places)
        } else {
            Result.failure(RuntimeException("response status is ${placeResponse.status}"))
        }} catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }

}
