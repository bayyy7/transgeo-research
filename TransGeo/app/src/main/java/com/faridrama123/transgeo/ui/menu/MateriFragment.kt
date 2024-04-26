package com.faridrama123.transgeo.ui.menu


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.faridrama123.transgeo.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MateriFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MateriFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param2: Int? = null
    private var link: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param2 = it.getInt(ARG_PARAM2)
            link =it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_materi, container, false)
        val image = view.findViewById<ImageView>(R.id.image)
        if (link != null){
            val linked = view.findViewById<LinearLayout>(R.id.linked)
            val linkT = view.findViewById<TextView>(R.id.link)
            linked.visibility = View.VISIBLE
            linkT.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                context?.startActivity(intent)
            }
            image.requestLayout()
            image.layoutParams.height = 300
        }

        image.setImageResource(param2!!)
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MateriFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param2: Int, link: String? = null) =
            MateriFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM2, param2)
                    putString(ARG_PARAM1, link)
                }
            }
    }
}