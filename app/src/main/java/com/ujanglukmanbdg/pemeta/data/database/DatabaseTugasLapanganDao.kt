package com.ujanglukmanbdg.pemeta.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ujanglukmanbdg.pemeta.data.database.model.ModelDatabaseTugasLapangan

@Dao
interface DatabaseTugasLapanganDao {
    @Query("SELECT * FROM tbl_penugasan")
    fun getAllPenugasan(): LiveData<List<ModelDatabaseTugasLapangan>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataPenugasan(vararg modelDatabases: ModelDatabaseTugasLapangan)

    @Query("DELETE FROM tbl_penugasan WHERE id= :id")
    fun deletePenugasanById(id: String)

    @Query("DELETE FROM tbl_penugasan")
    fun deleteAllPenugasan()
}