package com.ujanglukmanbdg.pemeta.ui.main

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ujanglukmanbdg.pemeta.data.database.model.ModelDatabaseReport
import com.ujanglukmanbdg.pemeta.data.database.model.UserModelStory
import com.ujanglukmanbdg.pemeta.data.database.repository.MyPemetaRepository
import com.ujanglukmanbdg.pemeta.data.database.response.DataReport
import com.ujanglukmanbdg.pemeta.data.lapangan.PhotoLaporan
import com.ujanglukmanbdg.pemeta.datastories.UserPreference
import com.ujanglukmanbdg.pemeta.retrofit.ApiConfig
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@ExperimentalPagingApi
class MainViewModel (private val pref: UserPreference, private val provideRepository: MyPemetaRepository) : ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _apiResponse = MutableLiveData<String>()
    val apiResponse: LiveData<String> = _apiResponse

    val listUser = MutableLiveData<ArrayList<PhotoLaporan>>()

    fun getListStory(token: String) {
        val reportList = ArrayList<PhotoLaporan>()
        val client = ApiConfig.getApiService().getStories(token)

        _isLoading.value = true
        client.enqueue(object: Callback<DataReport> {
            override fun onResponse(call: Call<DataReport>, response: Response<DataReport>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    listUser.postValue(responseBody.listReport)
                    listUser.value = reportList
                } else {
                    _isLoading.value = false
                    _apiResponse.value = responseBody?.message
                }
            }

            override fun onFailure(call: Call<DataReport>, t: Throwable) {
                _isLoading.value = false
                _apiResponse.value = t.message
                Log.d("List Story Error: ", "Msg")
            }
        })
    }

    fun getUser(): LiveData<UserModelStory> {
        return pref.getUser().asLiveData()
    }

    fun logout() {
        viewModelScope.launch {
            pref.logout()
        }
    }

    val pagingStory: (String) -> LiveData<PagingData<ModelDatabaseReport>> = {
            token: String -> provideRepository.find(token).cachedIn(viewModelScope)
    }
}