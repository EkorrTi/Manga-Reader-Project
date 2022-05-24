package com.example.mangareaderproject.ui.description

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangareaderproject.data.api.ApiChaptersResponse
import com.example.mangareaderproject.data.api.Chapter
import com.example.mangareaderproject.network.MangadexApi
import kotlinx.coroutines.launch

class MangaPageViewModel : ViewModel() {
    // The internal MutableLiveData that stores the status of the most recent request
    private val _chapters = MutableLiveData<List<Chapter>>()
    private lateinit var chaptersResponse: ApiChaptersResponse
    // The external immutable LiveData for the request status
    val chapters: LiveData<List<Chapter>> = _chapters

    fun getChapters(id: String){
        viewModelScope.launch {
            try {
                chaptersResponse = MangadexApi.retrofitService.getChapters(id)
                Log.i("Mangadex", "Fetched chapters successfully")
            } catch (e: Exception) {
                chaptersResponse = ApiChaptersResponse("", emptyList(), 500, 0)
                Log.w("Mangadex API Exception", e.toString())
            }
            Log.i("Mangadex Chapters Response", chaptersResponse.toString())
            _chapters.value = chaptersResponse.data
        }
    }
}