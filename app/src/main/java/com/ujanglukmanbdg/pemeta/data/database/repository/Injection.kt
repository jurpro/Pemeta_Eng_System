package com.ujanglukmanbdg.pemeta.data.database.repository

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import com.ujanglukmanbdg.pemeta.data.database.model.MyPemetaDatabase
import com.ujanglukmanbdg.pemeta.retrofit.ApiConfig

@ExperimentalPagingApi
object Injection {
    fun provideRepository(context: Context): MyPemetaRepository {
        val database = context.let {
            MyPemetaDatabase.getDatabase(it)
        }
        val apiService = ApiConfig.getApiService()
        return MyPemetaRepository(database, apiService)
    }
}