package com.example.actividadesmars.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.actividadesmars.R
import com.example.actividadesmars.models.remote.MarsApiClass

class AdapterMars( var datos: List<MarsEntity>) : RecyclerView.Adapter<AdapterMars.TuViewHolder>() {

    //funcion donde se pesca el layout model
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_mars_model, parent, false)
        return TuViewHolder(view)
    }

    //para cargar la estructura la cantidad de veces necesarias segun ellargo de la lista entregada de datos
    override fun onBindViewHolder(holder: TuViewHolder, position: Int) {
        val item = datos[position]
        holder.bind(item)
    }
    //contador de datos entregados
    override fun getItemCount(): Int {
        return datos.size
    }

    //adaptador de la estructura a los datos entregados
    inner class TuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageItemView: ImageView =itemView.findViewById(R.id.imageView)
        fun bind(item: MarsEntity) {

            Glide.with(itemView)
                .load(item.imgSrc)
                .into(imageItemView)
        }
    }
}