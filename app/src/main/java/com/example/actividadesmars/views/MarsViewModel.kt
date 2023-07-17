package com.example.actividadesmars.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.actividadesmars.models.remote.MarsApiClass
import com.example.actividadesmars.models.remote.RetrofitClient
import kotlinx.coroutines.launch


class MarsViewModel : ViewModel() {


    private val apiService = RetrofitClient.retrofitInstance()

    fun getMars(): LiveData<List<MarsApiClass>> {
        val marsLiveData = MutableLiveData<List<MarsApiClass>>()

        viewModelScope.launch {
            try {
                val mars = apiService.fecthMarsList()
                marsLiveData.value = mars
            } catch (e: Exception) {
                // Manejar el error aquí
            }
        }

        return marsLiveData
    }
}