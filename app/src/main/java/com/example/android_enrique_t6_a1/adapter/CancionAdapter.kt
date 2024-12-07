package com.example.android_enrique_t6_a1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_enrique_t6_a1.R
import com.example.android_enrique_t6_a1.databinding.ItemCancionBinding
import com.example.android_enrique_t6_a1.databinding.ItemDiscoBinding
import com.example.android_enrique_t6_a1.fragment.OnClickListener
import com.example.android_enrique_t6_a1.pojo.Cancion

class CancionAdapter (private val canciones: List<Cancion>, private val listener: OnClickListener
): RecyclerView.Adapter<CancionAdapter.ViewHolder>(){
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_cancion,
            parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int = canciones.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cancion = canciones.get(position)
        with(holder){
            setListener(cancion)
            binding.imgFoto.setImageResource(R.drawable.cancion)
            binding.nombre.text = cancion.nombre
            binding.autor.text = cancion.duracion

        }
    }
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemCancionBinding.bind(view)
        fun setListener(cancion: Cancion){
            binding.root.setOnClickListener {
                listener.onClick2(cancion)
            }
        }
    }
}
