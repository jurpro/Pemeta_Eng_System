package com.ujanglukmanbdg.pemeta.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ujanglukmanbdg.pemeta.data.database.model.ModelDatabaseAbsensi

@Dao
interface DatabaseAbsensiDao {
    @Query("SELECT * FROM tbl_absensi")
    fun getAllAbsensi(): LiveData<List<ModelDatabaseAbsensi>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataAbsensi(vararg modelDatabases: ModelDatabaseAbsensi)

    @Query("DELETE FROM tbl_absensi WHERE id= :id")
    fun deleteAbsensiById(id: String)

    @Query("DELETE FROM tbl_absensi")
    fun deleteAllAbsensi()
}