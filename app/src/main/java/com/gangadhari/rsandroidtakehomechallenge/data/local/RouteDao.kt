package com.gangadhari.rsandroidtakehomechallenge.data.local


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gangadhari.rsandroidtakehomechallenge.data.local.entities.RouteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RouteDao {
    @Query("SELECT * FROM routes")
    fun getAllRoutes(): Flow<List<RouteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(routes: List<RouteEntity>)
}
