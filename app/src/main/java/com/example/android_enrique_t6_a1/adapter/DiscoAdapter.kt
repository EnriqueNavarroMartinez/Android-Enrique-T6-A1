package com.example.android_enrique_t6_a1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_enrique_t6_a1.R
import com.example.android_enrique_t6_a1.databinding.ItemDiscoBinding
import com.example.android_enrique_t6_a1.fragment.OnClickListener
import com.example.android_enrique_t6_a1.pojo.Disco

class DiscoAdapter (private val discos: List<Disco>, private val listener: OnClickListener
): RecyclerView.Adapter<DiscoAdapter.ViewHolder>(){
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_disco,
            parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int = discos.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val disco = discos.get(position)
        with(holder){
            setListener(disco)
            binding.imgFoto.setImageResource(R.drawable.disco)
            binding.nombre.text = disco.nombre
            binding.autor.text = disco.autor
            binding.duracion.text = disco.ano
        }
    }
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemDiscoBinding.bind(view)
        fun setListener(disco:Disco){
            binding.root.setOnClickListener {
                listener.onClick(disco)
            }
        }
    }
}
