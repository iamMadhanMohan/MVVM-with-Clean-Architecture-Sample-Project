package com.gangadhari.rsandroidtakehomechallenge.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drivers")
data class DriverEntity(
    @PrimaryKey val id: Int,
    val name: String,
)