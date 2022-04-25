package com.example.mangareaderproject.ui.description

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangareaderproject.data.api.ApiChaptersResponse
import com.example.mangareaderproject.data.api.ApiMangaResponse
import com.example.mangareaderproject.network.MangadexApi
import kotlinx.coroutines.launch

class MangaPageViewModel : ViewModel() {
    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()
    private val _response = MutableLiveData<ApiMangaResponse>()
    private val _chapters = MutableLiveData<ApiChaptersResponse>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    val mangaResponse: LiveData<ApiMangaResponse> = _response
    //val chapters: MutableLiveData<ApiChaptersResponse> = _chapters

    fun getManga(id: String){
        viewModelScope.launch {
            try {
                _response.value = MangadexApi.retrofitService.getManga(id)
                _status.value = "Success: retrieved info"
            } catch (e: Exception){
                Log.w("Mangadex", e.toString())
                _status.value = "Failure: ${e.message}"
            }
            Log.w("Mangadex", _response.value.toString())
        }
    }

    fun getChapters(id: String){
        viewModelScope.launch {
            try {
                _chapters.value = MangadexApi.retrofitService.getChapters(id)
            } catch (e: Exception) {
                Log.w("Mangadex API Exception", e.toString())
            }
            Log.i("Mangadex", _chapters.value.toString())
        }
    }
}