package com.ujanglukmanbdg.pemeta.data.database

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ujanglukmanbdg.pemeta.data.database.model.ModelDatabaseReport

@Dao
interface DatabaseReportDao {
    @Query("SELECT * FROM tbl_report")
    fun getAllReport(): LiveData<List<ModelDatabaseReport>>

    @Query("SELECT * FROM tbl_report")
    fun getAllReportField(): PagingSource<Int, ModelDatabaseReport>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataReport(report: List<ModelDatabaseReport>)

    @Query("SELECT * FROM tbl_report")
    suspend fun findAllReport(): List<ModelDatabaseReport>

    @Query("DELETE FROM tbl_report WHERE id= :id")
    fun deleteReportById(id: String)

    @Query("DELETE FROM tbl_report")
    suspend fun deleteAllReport()

}