package com.ujanglukmanbdg.pemeta.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ujanglukmanbdg.pemeta.data.database.model.ModelDatabaseKaryawanLapangan

@Dao
interface DatabaseKaryawanLapangan {
    @Query("SELECT * FROM tbl_supervisi")
    fun getAllSupervisi(): LiveData<List<ModelDatabaseKaryawanLapangan>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataSupervisi(vararg modelDatabases: ModelDatabaseKaryawanLapangan)

    @Query("DELETE FROM tbl_supervisi WHERE id= :id")
    fun deleteSupervisiById(id: String)

    @Query("DELETE FROM tbl_supervisi")
    fun deleteAllSupervisi()
}