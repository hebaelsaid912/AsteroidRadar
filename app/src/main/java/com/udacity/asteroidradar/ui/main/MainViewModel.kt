package com.udacity.asteroidradar.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.asteroidradar.Constants
import com.udacity.asteroidradar.model.Asteroid
import com.udacity.asteroidradar.model.PlanetaryApodModel
import com.udacity.asteroidradar.api.NasaApi
import com.udacity.asteroidradar.api.parseAsteroidsJsonResult
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import java.util.*


private const val TAG = "MainViewModel"
class MainViewModel() : ViewModel() {
    //image of the day
    val _imageURL: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val _title: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    //feeds on 7 days
    val _asteroid: MutableLiveData<ArrayList<Asteroid>> by lazy {
        MutableLiveData<ArrayList<Asteroid>>()
    }

    init {
        getPlanetaryApodImage()
        getFeedsByDate()
    }

    private fun getPlanetaryApodImage() {
        NasaApi.retrofitService.getPlanetaryApod().enqueue(object: retrofit2.Callback<PlanetaryApodModel> {
            override fun onResponse(
                call: Call<PlanetaryApodModel>,
                response: Response<PlanetaryApodModel>
            ) {
                Log.d(TAG, "getPlanetaryApodImage: onResponse: ${response.isSuccessful}")
                Log.d(TAG, "getPlanetaryApodImage: onResponse: ${response.body()?.date}")
                _imageURL.value = response.body()?.url
                _title.value = response.body()?.title
            }

            override fun onFailure(call: Call<PlanetaryApodModel>, t: Throwable) {
                Log.d(TAG, "getPlanetaryApodImage: onResponse: ${t.message}")
            }

        })
    }
    private fun getFeedsByDate() {
        /*var start = getStartDate()
        var end = getEndDate()*/
        var start = "2022-07-20"
        var end = "2022-07-26"
        viewModelScope.launch {
            try {
               var list =  parseAsteroidsJsonResult(
                    JSONObject(
                        NasaApi.retrofitService.getFeedByDate(
                            start,
                            end,
                            Constants.api_key
                        )
                    )
                )
                Log.d(TAG, "getFeedsByDate: list size ${list.size}")
            }catch (e :Exception){
                e.printStackTrace()
               // Log.d(TAG, "getFeedsByDate: e")
            }

        }
    }
    fun getStartDate():String{
        var date = Calendar.DATE
        Log.d(TAG, "getStartDate: start date: $date")
        return date.toString()
    }
    fun getEndDate():String{
        var date = Calendar.DATE
        Log.d(TAG, "getStartDate: start date: $date")
        return date.toString()
    }
}