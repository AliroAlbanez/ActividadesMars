package com.example.actividadesmars.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.actividadesmars.databinding.ActivityMainBinding
import com.example.actividadesmars.models.AdapterMars
import com.example.actividadesmars.models.remote.MarsApiClass
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    private val marsViewModel: MarsViewModel by viewModels()
    private lateinit var marsList:List<MarsApiClass>
    private lateinit var recycler: RecyclerView
    private lateinit var itemAdapter: AdapterMars

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        recycler = mBinding.RecyclerView1

        marsViewModel.getMars().observe(this, Observer { mars ->
            marsList= mars ?: emptyList()
            Log.d("MainActivity", "Cantidad de usuarios: ${marsList.size}")
            recycler.layoutManager=GridLayoutManager(this,2)
            itemAdapter= AdapterMars(marsList)
            recycler.adapter=itemAdapter
        })


    }
}