package com.ujanglukmanbdg.pemeta.data.database.paging

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.ujanglukmanbdg.pemeta.data.database.model.ModelDatabaseReport
import com.ujanglukmanbdg.pemeta.data.database.model.MyPemetaDatabase
import com.ujanglukmanbdg.pemeta.data.database.model.RemoteKeysAccess
import com.ujanglukmanbdg.pemeta.data.database.repository.DataMapUser.mapReportResponseToReportItem
import com.ujanglukmanbdg.pemeta.retrofit.ApiService

@ExperimentalPagingApi
class ReportRemoteMediator (
    private val database: MyPemetaDatabase,
    private val apiService: ApiService,
    private val token: String
) : RemoteMediator<Int, ModelDatabaseReport>() {

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(loadType: LoadType, state: PagingState<Int, ModelDatabaseReport>): MediatorResult {

        val page = when (loadType) {
            LoadType.REFRESH ->{
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextKey?.minus(1) ?: INITIAL_PAGE_INDEX
            }
            LoadType.PREPEND -> {
                val remoteKeys = getRemoteKeyForFirstItem(state)
                val prevKey = remoteKeys?.prevKey
                    ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                prevKey
            }
            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                val nextKey = remoteKeys?.nextKey
                    ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                nextKey
            }
        }

        try {
            val responseData = apiService.getAllStories(token, page, state.config.pageSize)
            val endOfPaginationReached = responseData.listReport.isEmpty()

            database.withTransaction {
                if(loadType == LoadType.REFRESH){
                    database.remoteKeysDao().deleteRemoteKeys()
                    database.reportDao().deleteAllReport()
                }
                val prevKey = if (page == 1) null else page - 1
                val nextKey = if (endOfPaginationReached) null else page + 1

                val keys = responseData.listReport.map {
                   RemoteKeysAccess(id = it.id, prevKey = prevKey, nextKey = nextKey)
                }

                database.remoteKeysDao().insertAll(keys)

                database.reportDao().insertDataReport(mapReportResponseToReportItem(responseData.listReport))
            }

            return MediatorResult.Success(endOfPaginationReached)

        } catch (exception: Exception){
            Log.d(TAG, exception.message.toString())
            return MediatorResult.Error(exception)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, ModelDatabaseReport>): RemoteKeysAccess? {
        return state.pages.lastOrNull {
            it.data.isNotEmpty()
        }?.data?.lastOrNull()?.let {
                data -> database.remoteKeysDao().getRemoteKeysId(data.id)
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, ModelDatabaseReport>): RemoteKeysAccess? {
        return state.pages.firstOrNull {
            it.data.isNotEmpty()
        }?.data?.firstOrNull()?.let {
                data ->
            database.remoteKeysDao().getRemoteKeysId(data.id)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, ModelDatabaseReport>): RemoteKeysAccess? {
        return state.anchorPosition?.let {
                position ->
            state.closestItemToPosition(position)?.id?.let {
                    id ->
                database.remoteKeysDao().getRemoteKeysId(id)
            }
        }
    }

    private companion object {
        val TAG = ReportRemoteMediator::class.simpleName
        const val INITIAL_PAGE_INDEX = 1
    }
}