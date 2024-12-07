package com.example.android_enrique_t6_a1.pojo

import com.example.android_enrique_t6_a1.R

class DiscoDatos {
    companion object{
        val DISCOS = arrayListOf<Disco>(
            Disco("Disco 1", "Autor 1", "2000", listOf(Cancion("cancion 1", "duracion1"),Cancion("cancion2","duracion2")),
                R.drawable.cancion),
            Disco("Disco 2", "Autor 2", "2002", listOf(Cancion("cancion 3", "duracion3"),Cancion("cancion4","duracion4")),R.drawable.cancion),
            Disco("Disco 3", "Autor 3", "2006", listOf(Cancion("cancion 5", "duracion5"),Cancion("cancion6","duracion6")),R.drawable.cancion),

            )
    }
}