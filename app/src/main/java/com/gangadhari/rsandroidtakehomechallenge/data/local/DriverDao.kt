package com.gangadhari.rsandroidtakehomechallenge.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gangadhari.rsandroidtakehomechallenge.data.local.entities.DriverEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DriverDao {
    @Query("SELECT * FROM drivers")
    fun getAllDrivers(): Flow<List<DriverEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(drivers: List<DriverEntity>)
}
