package com.example.psycology.Fragments.Question

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.psycology.R
import com.example.psycology.Test
import kotlinx.android.synthetic.main.fragment_nsquestion2.*

class NSFragment2 : Fragment(), View.OnClickListener {
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_nsquestion2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        nsq2_ib1.setOnClickListener(this)
        nsq2_ib2.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.nsq2_ib1 -> {
                Test.nsresult1(navigateWithIndex(1))
            }
            R.id.nsq2_ib2 -> {
                Test.nsresult2(navigateWithIndex(2))
            }
        }
    }

    fun navigateWithIndex(index : Int){
        val bundle = bundleOf("index" to index)
        navController.navigate(R.id.action_NSFragment2_to_NSFragment3,bundle)
    }

}