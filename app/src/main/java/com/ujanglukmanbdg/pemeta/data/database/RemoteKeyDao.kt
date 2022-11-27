package com.ujanglukmanbdg.pemeta.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ujanglukmanbdg.pemeta.data.database.model.RemoteKeysAccess

@Dao
interface RemoteKeyDao {
    @Query("SELECT * FROM remote_keys_access WHERE id = :id")
    suspend fun getRemoteKeysId(id: Int): RemoteKeysAccess?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKeysAccess>)

    @Query("DELETE FROM remote_keys_access")
    suspend fun deleteRemoteKeys()

}