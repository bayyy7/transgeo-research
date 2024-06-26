package com.faridrama123.transgeo.ui.menu

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.faridrama123.transgeo.R
import com.faridrama123.transgeo.databinding.FragmentTentangBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TentangFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TentangFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    private var bindingfragment : FragmentTentangBinding?  = null
    private val binding get() = bindingfragment!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param1?.let { it1 -> Log.i("TentangFragment", it1) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingfragment = FragmentTentangBinding.inflate(inflater,container,false)
        return binding.root

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TentangFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            TentangFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)

                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param1?.let {

                when (it){
                    "KIKD" -> {
                        binding?.title.text = "KOMPETENSI DASAR"
                        binding?.tableofcontent.text = getString(R.string.kompentensidasar)

                    }
                   "TENTANG" -> {
                       binding?.title.text = "TENTANG"
                       binding?.tableofcontent.text = getString(R.string.tentang)

                   }
                    "BANTUAN" -> {
                        binding?.title.text = "BANTUAN"
                        binding?.tableofcontent.text = getString(R.string.bantuan)

                    }                }

            }
        }

        binding.close.setOnClickListener {
            binding.fragmentMenu1.setVisibility(View.GONE)

        }
    }
}