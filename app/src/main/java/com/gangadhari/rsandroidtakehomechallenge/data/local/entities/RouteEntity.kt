package com.gangadhari.rsandroidtakehomechallenge.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "routes")
data class RouteEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val type: String
)