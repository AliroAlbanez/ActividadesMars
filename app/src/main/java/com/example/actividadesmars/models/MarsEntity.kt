package com.example.actividadesmars.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "TABLE_MARS")
data class MarsEntity (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "price")
    val price: Int,
    @ColumnInfo(name = "imgSrc")
    val imgSrc: String

)
