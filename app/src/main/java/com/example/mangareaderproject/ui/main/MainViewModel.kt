package com.example.mangareaderproject.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangareaderproject.data.api.ApiFeedResponse
import com.example.mangareaderproject.network.MangadexApi
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    // The internal MutableLiveData that stores the status of the most recent request
    private val _response = MutableLiveData<ApiFeedResponse>()

    // The external immutable LiveData for the request status
    val feedResponse: LiveData<ApiFeedResponse> = _response

    fun getFeed(ids: List<String>){
        viewModelScope.launch {
            try {
                _response.value = MangadexApi.retrofitService.getFeedMangas(ids, ids.size)
                Log.i("Mangadex Library Feed Response", "Fetched manga successfully")
            } catch (e: Exception){
                Log.w("Mangadex Library Feed API Exception", e.toString())
            }
            Log.i("Mangadex Library Feed Response", _response.value.toString())
        }
    }

    val exampleIdsList = listOf("a77742b1-befd-49a4-bff5-1ad4e6b0ef7b", "91b9f2f0-e63f-4444-b1b4-552e167e089a", "07823fcd-f2c9-458c-9824-3eae62b2a006")
}