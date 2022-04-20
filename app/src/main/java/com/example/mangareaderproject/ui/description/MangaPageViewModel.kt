package com.example.mangareaderproject.ui.description

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangareaderproject.data.api.ApiResponse
import com.example.mangareaderproject.network.MangadexApi
import kotlinx.coroutines.launch

class MangaPageViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()
    private val _response = MutableLiveData<ApiResponse>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    val response: LiveData<ApiResponse> = _response

    fun getManga(id: String){
        viewModelScope.launch {
            try {
                _response.value = MangadexApi.retrofitService.getManga(id)
                _status.value = "Success: retrieved info"
            } catch (e: Exception){
                Log.w("Mangadex", e.message.toString())
                _status.value = "Failure: ${e.message}"
            }
            Log.w("Mangadex", _response.value.toString())
        }
    }
}