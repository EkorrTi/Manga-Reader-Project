package com.example.mangareaderproject.ui.reader

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangareaderproject.data.api.ApiAtHomeResponse
import com.example.mangareaderproject.network.MangadexApi
import kotlinx.coroutines.launch

class ReaderViewModel : ViewModel() {
    private val _response = MutableLiveData<ApiAtHomeResponse>()
    val response: LiveData<ApiAtHomeResponse> = _response

    fun getChapterData(chapterID: String){
        viewModelScope.launch {
            try {
                _response.value = MangadexApi.retrofitService.getChapterAndServer(chapterID)
                Log.i("Mangadex at-home response", _response.value.toString())
            } catch (e: Exception){
                Log.w("Mangadex at-home response", e.toString())
            }
        }
    }
}