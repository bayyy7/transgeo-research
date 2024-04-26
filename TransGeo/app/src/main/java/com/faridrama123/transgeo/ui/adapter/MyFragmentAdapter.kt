package com.faridrama123.transgeo.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.faridrama123.transgeo.R
import com.faridrama123.transgeo.ui.menu.MateriFragment
import com.faridrama123.transgeo.ui.menu.SimulasiFragment
import com.faridrama123.transgeo.ui.menu.TesFragment

class MyPagerAdapter(fm: FragmentManager, val title: String): FragmentPagerAdapter(fm){

    // sebuah list yang menampung objek Fragment
    private val pagesTranslasi = listOf(
        MateriFragment.newInstance(R.drawable.translasi1),
        MateriFragment.newInstance(R.drawable.translasi2),
        MateriFragment.newInstance( R.drawable.translasi1),
        MateriFragment.newInstance( R.drawable.translasi2),
        SimulasiFragment.newInstance(title, "https://www.geogebra.org/m/ngayshbv")
    )
    private val pagesDilatasi = listOf(
        MateriFragment.newInstance( R.drawable.dilatasi1),
        MateriFragment.newInstance(R.drawable.dilatasi2),
        MateriFragment.newInstance( R.drawable.dilatasi3),
        SimulasiFragment.newInstance(title, "https://www.geogebra.org/m/yepuhy6m"),
        MateriFragment.newInstance( R.drawable.petunjuk_soal),
        MateriFragment.newInstance( R.drawable.stage1),
        TesFragment.newInstance("https://docs.google.com/forms/d/e/1FAIpQLSeLF_NiaaVCgKKTgZlE6h1AYGbZOB0QCNpq37t8bP6TkVpyKw/viewform?usp=pp_url")
    )
    private val pagesRotasi = listOf(
        MateriFragment.newInstance( R.drawable.rotasi1),
        MateriFragment.newInstance( R.drawable.rotasi2),
        MateriFragment.newInstance( R.drawable.rotasi3),
        SimulasiFragment.newInstance(title, "https://www.geogebra.org/m/fvgxfhjp")
    )
    private val pagesRefleksi = listOf(
        MateriFragment.newInstance( R.drawable.refleksi1),
        MateriFragment.newInstance( R.drawable.refleksi2),
        MateriFragment.newInstance( R.drawable.refleksi3),
        MateriFragment.newInstance( R.drawable.refleksi4),
        SimulasiFragment.newInstance(title, "https://www.geogebra.org/m/zq8c4fft")
    )

    // menentukan fragment yang akan dibuka pada posisi tertentu
    override fun getItem(position: Int): Fragment {
        return when(title){
            "TRANSLASI" ->   pagesTranslasi[position]
            "DILATASI" ->    pagesDilatasi[position]
            "ROTASI" ->   pagesRotasi[position]
            "REFLEKSI" ->  pagesRefleksi[position]
            else -> {
                pagesRefleksi[position]
            }
        }
    }

    override fun getCount(): Int {
        return when (title) {
            "TRANSLASI" -> pagesTranslasi.size
            "DILATASI" -> pagesDilatasi.size
            "ROTASI" -> pagesRotasi.size
            "REFLEKSI" -> pagesRefleksi.size
            else -> {
                pagesRefleksi.size
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(title){
            "TRANSLASI" -> when(position){
                0 -> title
                1 -> title
                2 -> title
                3 -> title
                else -> "Simulasi"
            }
            "DILATASI" -> when(position){
                0 -> title
                1 -> title
                2 -> title
                3 -> "SIMULASI"
                else -> "SOAL TES"
            }
            "ROTASI" -> when(position){
                0 -> title
                1 -> title
                2 -> title
                else -> "SIMULASI"
            }
            "REFLEKSI" -> when(position){
                0 -> title
                1 -> title
                2 -> title
                3 -> title
                else -> "SIMULASI"
            }
            else -> ""
        }
    }
}