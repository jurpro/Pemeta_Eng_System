package com.ujanglukmanbdg.pemeta.data.database.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ujanglukmanbdg.pemeta.data.database.*

@Database(
    entities = [
        ModelDatabaseReport::class,
        ModelDatabaseAbsensi::class,
        ModelDatabaseTugasLapangan::class,
        ModelDatabaseKaryawanLapangan::class,
        RemoteKeysAccess::class],
    version = 1,
    exportSchema = false
)
abstract class MyPemetaDatabase : RoomDatabase() {

    abstract fun reportDao(): DatabaseReportDao
    abstract fun absensiDao(): DatabaseAbsensiDao
    abstract fun tugasLapanganDao(): DatabaseTugasLapanganDao
    abstract fun karyawanLapanganDao(): DatabaseKaryawanLapangan
    abstract fun remoteKeysDao(): RemoteKeyDao

    companion object {
        @Volatile
        private var INSTANCE: MyPemetaDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): MyPemetaDatabase{
            if (INSTANCE == null) {
                synchronized(MyPemetaDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        MyPemetaDatabase::class.java, "mypemeta_db")
                        .build()
                }
            }
            return INSTANCE as MyPemetaDatabase
        }
    }
}