package com.example.kiitappver2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kiitappver2.Notification
import com.example.kiitappver2.NotificationAdapter
import com.example.kiitappver2.R
import com.example.kiitappver2.databinding.FragmentNotification2Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NotificationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotificationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var notiRecyclerView: RecyclerView
    private lateinit var notiArrayList: ArrayList<Notification>

    private lateinit var notiTitle: Array<String>
    private lateinit var notiDetail: Array<String>
    private lateinit var notiImage : Array<Int>

    private var _binding: FragmentNotification2Binding? = null

    private val binding get() = _binding!!


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
        _binding = FragmentNotification2Binding.inflate(inflater, container, false)


        notiTitle = arrayOf(
            "Winter Vacation",
            "Winter Vacation"
        )


        notiDetail = arrayOf(
            "It is to be notified that winter vacation from Dec 21 to Jan2 is provided to the students.",
            "It is to be notified that winter vacation from Dec 21 to Jan2 is provided to the students."
        )

        notiImage = arrayOf(
            R.drawable.img_society_one,
            R.drawable.img_society_one
        )


        notiRecyclerView = binding.recyclerViewNotification
        notiRecyclerView.layoutManager = LinearLayoutManager(context)
        notiRecyclerView.setHasFixedSize(true)

        notiArrayList = arrayListOf<Notification>()
        getUserData()
        return binding.root
    }

    private fun getUserData() {
        for(i in notiImage.indices){
            val notification = Notification(notiTitle[i], notiDetail[i], notiImage[i])
            notiArrayList.add(notification)
        }
        val notificationAdapter = NotificationAdapter(notiArrayList)
        notiRecyclerView.adapter = notificationAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NotificationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NotificationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}