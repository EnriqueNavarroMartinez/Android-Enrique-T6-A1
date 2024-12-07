package com.example.android_enrique_t6_a1.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_enrique_t6_a1.R
import com.example.android_enrique_t6_a1.adapter.CancionAdapter
import com.example.android_enrique_t6_a1.adapter.DiscoAdapter
import com.example.android_enrique_t6_a1.databinding.FragmentCancionBinding
import com.example.android_enrique_t6_a1.databinding.FragmentDiscoBinding
import com.example.android_enrique_t6_a1.pojo.Cancion
import com.example.android_enrique_t6_a1.pojo.Disco
import com.example.android_enrique_t6_a1.pojo.DiscoDatos


class CancionFragment : Fragment(),OnClickListener {

    private lateinit var cancionAdapter: CancionAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var itemDecoration: DividerItemDecoration
    private lateinit var binding: FragmentCancionBinding
    private lateinit var listener: DiscosListener
    private var canciones: List<Cancion> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCancionBinding.inflate(inflater, container, false)

        // Obtener el disco pasado a través de los argumentos
        val disco = arguments?.getSerializable("discoSeleccionado") as? Disco
        disco?.let {
            canciones = it.canciones // Asignar las canciones del disco
            Log.d("CancionFragment", "Canciones: ${canciones.size}")
        }

        cancionAdapter = CancionAdapter(canciones, this)
        linearLayoutManager = LinearLayoutManager(context)
        itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.recycler.apply{
            layoutManager = linearLayoutManager
            adapter = cancionAdapter
            addItemDecoration(itemDecoration)
        }
        return binding.root
    }




}