package com.example.android_enrique_t6_a1.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_enrique_t6_a1.R
import com.example.android_enrique_t6_a1.databinding.ActivityMainBinding
import com.example.android_enrique_t6_a1.fragment.CancionFragment
import com.example.android_enrique_t6_a1.fragment.DiscoFragment
import com.example.android_enrique_t6_a1.fragment.DiscosListener
import com.example.android_enrique_t6_a1.pojo.Disco

class MainActivity : AppCompatActivity(),DiscosListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val discosListado: DiscoFragment =
            binding.fragmentDiscos?.let { supportFragmentManager.findFragmentById(it.id) } as DiscoFragment
        discosListado.setDiscosListener(this)
    }

    override fun onDiscoSeleccionado(disco: Disco) {
        if (disco != null) {
            // Crear una nueva instancia de CancionFragment
            val cancionFragment = CancionFragment()

            // Pasar las canciones correspondientes al disco seleccionado a CancionFragment
            val bundle = Bundle()
            bundle.putSerializable("discoSeleccionado", disco) // Pasar el disco con sus canciones
            cancionFragment.arguments = bundle // Enviar el bundle al fragmento

            // Reemplazar el fragmento de discos con el fragmento de canciones
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentDiscos, cancionFragment) // Reemplazar el fragmento actual por el de canciones
            transaction.addToBackStack(null) // Agregar la transacción a la pila para que se pueda regresar a los discos
            transaction.commit()
        }
    }
}