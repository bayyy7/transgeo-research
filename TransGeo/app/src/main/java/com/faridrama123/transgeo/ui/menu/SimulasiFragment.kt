package com.faridrama123.transgeo.ui.menu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.faridrama123.transgeo.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SimulasiFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SimulasiFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_simulasi, container, false)
        val link = view.findViewById<TextView>(R.id.link)
        val title = view.findViewById<TextView>(R.id.title)
        title.text = param1
        link.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(param2))
            context?.startActivity(intent)
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SimulasiFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(title: String, link: String) =
            SimulasiFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, title)
                    putString(ARG_PARAM2, link)
                }
            }
    }
}