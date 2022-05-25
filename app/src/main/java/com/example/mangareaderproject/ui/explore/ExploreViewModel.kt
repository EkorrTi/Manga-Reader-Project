package com.example.mangareaderproject.ui.explore

import android.util.Log
import androidx.lifecycle.*
import com.example.mangareaderproject.data.api.ApiFeedResponse
import com.example.mangareaderproject.network.MangadexApi
import com.example.mangareaderproject.room.MangaDao
import kotlinx.coroutines.launch

class ExploreViewModel(private val mangaDao: MangaDao) : ViewModel() {
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

    fun getLibrary() = mangaDao.getAll()
}

class ExploreViewModelFactory(
    private val mangaDao: MangaDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExploreViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ExploreViewModel(mangaDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}