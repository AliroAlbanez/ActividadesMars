package com.example.actividadesmars.models


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.actividadesmars.models.remote.MarsApiClass

@Dao
interface MarsDAO {
    @Query("SELECT * FROM TABLE_MARS ORDER BY id ASC")
    fun getAllDatos(): LiveData<List<MarsEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(listCourses: List<MarsEntity>)

}