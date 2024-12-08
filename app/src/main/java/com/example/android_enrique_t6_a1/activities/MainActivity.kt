package com.example.android_enrique_t6_a1.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_enrique_t6_a1.R
import com.example.android_enrique_t6_a1.databinding.ActivityMainBinding
import com.example.android_enrique_t6_a1.fragment.CancionFragment
import com.example.android_enrique_t6_a1.fragment.DiscoFragment
import com.example.android_enrique_t6_a1.fragment.DiscosListener
import com.example.android_enrique_t6_a1.pojo.Disco

class MainActivity : AppCompatActivity(), DiscosListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el fragmento de discos y establecer el listener
        val discosListado = supportFragmentManager.findFragmentById(R.id.fragmentDisco) as? DiscoFragment
        discosListado?.setDiscosListener(this)
    }

    override fun onDiscoSeleccionado(disco: Disco) {
        if (disco != null) {
            // Verificar si existe el fragmento de detalle en el layout actual
            val hayDetalle = supportFragmentManager.findFragmentById(R.id.fragmentCancion) != null

            if (hayDetalle) {
                // Mostrar el contenido en el fragmento de detalle (Tablet o Tablet Horizontal)
                val cancionFragment = CancionFragment()
                val bundle = Bundle()
                bundle.putSerializable("discoSeleccionado", disco) // Pasar el disco seleccionado
                cancionFragment.arguments = bundle

                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragmentCancion, cancionFragment) // Actualizar el fragmento de detalle
                transaction.commitNow() // Hacerlo inmediato
            } else {
                // Reemplazar el fragmento principal (Móvil)
                val cancionFragment = CancionFragment()
                val bundle = Bundle()
                bundle.putSerializable("discoSeleccionado", disco)
                cancionFragment.arguments = bundle

                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragmentDisco, cancionFragment) // Reemplazar el fragmento principal
                transaction.addToBackStack(null) // Agregar a la pila de retroceso
                transaction.commit()
            }
        }
    }
}
