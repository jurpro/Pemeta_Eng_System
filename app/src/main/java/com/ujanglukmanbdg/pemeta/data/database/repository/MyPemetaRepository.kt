package com.ujanglukmanbdg.pemeta.data.database.repository

import androidx.lifecycle.LiveData
import androidx.paging.*
import com.ujanglukmanbdg.pemeta.data.database.model.ModelDatabaseReport
import com.ujanglukmanbdg.pemeta.data.database.model.MyPemetaDatabase
import com.ujanglukmanbdg.pemeta.data.database.paging.ReportRemoteMediator
import com.ujanglukmanbdg.pemeta.retrofit.ApiService

@ExperimentalPagingApi
class MyPemetaRepository (
    private val myPemetaDatabase: MyPemetaDatabase,
    private val apiService: ApiService
    ) {

        fun find(token: String): LiveData<PagingData<ModelDatabaseReport>> {

            return Pager(
                config = PagingConfig(pageSize = 4),
                remoteMediator = ReportRemoteMediator(myPemetaDatabase, apiService, "Bearer $token"),
                pagingSourceFactory = {
                    myPemetaDatabase.reportDao().getAllReportField()
                }
            ).liveData
        }

        suspend fun getData(): List<ModelDatabaseReport> {
            return myPemetaDatabase.reportDao().findAllReport()
        }

        companion object {
            const val EXTRA_TOKEN = "extra_token"
        }
}