package com.example.mangareaderproject.ui.explore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangareaderproject.data.api.ApiFeedResponse
import com.example.mangareaderproject.network.MangadexApi
import kotlinx.coroutines.launch

class ExploreViewModel : ViewModel() {
    // The internal MutableLiveData that stores the status of the most recent request
    private val _response = MutableLiveData<ApiFeedResponse>()

    // The external immutable LiveData for the request status
    val feedResponse: LiveData<ApiFeedResponse> = _response

    fun getFeed(){
        viewModelScope.launch {
            try {
                _response.value = MangadexApi.retrofitService.getFeedMangas(limit = 30)
                Log.i("Mangadex Explore Feed Response", "Fetched manga successfully")
            } catch (e: Exception){
                Log.w("Mangadex Explore Feed API Exception", e.toString())
            }
            Log.i("Mangadex Explore Feed Response", _response.value.toString())
        }
    }
}