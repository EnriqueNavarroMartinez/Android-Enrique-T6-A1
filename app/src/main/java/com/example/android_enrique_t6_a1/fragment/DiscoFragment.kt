package com.example.android_enrique_t6_a1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_enrique_t6_a1.R
import com.example.android_enrique_t6_a1.adapter.DiscoAdapter
import com.example.android_enrique_t6_a1.databinding.FragmentDiscoBinding
import com.example.android_enrique_t6_a1.pojo.Disco
import com.example.android_enrique_t6_a1.pojo.DiscoDatos


class DiscoFragment : Fragment(), OnClickListener {
    private lateinit var discoAdapter: DiscoAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var itemDecoration: DividerItemDecoration
    private lateinit var binding: FragmentDiscoBinding
    private lateinit var listener: DiscosListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiscoBinding.inflate(inflater, container, false)
        discoAdapter = DiscoAdapter(DiscoDatos.DISCOS, this)
        linearLayoutManager = LinearLayoutManager(context)
        itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.recycler.apply{
            layoutManager = linearLayoutManager
            adapter = discoAdapter
            addItemDecoration(itemDecoration)
        }
        return binding.root
    }
    fun setDiscosListener(listener: DiscosListener) {
        this.listener = listener
    }

    // Para realizar onClick
    override fun onClick(disco: Disco) {
        Toast.makeText(context, "Seleccion: ${disco.nombre}", Toast.LENGTH_LONG).show()
        if (listener != null) {
            listener.onDiscoSeleccionado(disco)
        }
    }


}