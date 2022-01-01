package com.j.my_sunny.ui.place

import Place
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.j.my_sunny.logic.Repository

class PlaceViewModel:ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    //对城市数据进行缓存
    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

}