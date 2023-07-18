package com.example.actividadesmars.views

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.actividadesmars.models.MarsDAO
import com.example.actividadesmars.models.MarsDB
import com.example.actividadesmars.models.MarsEntity
import com.example.actividadesmars.models.remote.MarsApiClass
import com.example.actividadesmars.models.remote.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MarsViewModel ( application: Application): AndroidViewModel(application) {


    private val apiService = RetrofitClient.retrofitInstance()
    private val marsDao:MarsDAO =MarsDB.getDatabase(application).marsDao()
    val marsLiveData: LiveData<List<MarsEntity>> = marsDao.getAllDatos()

    fun getMars() {


        viewModelScope.launch {
            try {
                val mars = apiService.fecthMarsList()
                Log.i("POPO", "llegamos")
                val marsEntities = mars.map{user->
                    MarsEntity(user.id,user.type,user.price,user.imgSrc)
                }
                Log.i("POPO", " aqui")
                marsDao.insertAll(marsEntities)

            } catch (e: Exception) {
                Log.i("POPO", "Error en algo aqui")
            }
        }

    }
}