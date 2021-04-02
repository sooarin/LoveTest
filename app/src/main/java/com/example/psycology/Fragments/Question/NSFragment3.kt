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
import kotlinx.android.synthetic.main.fragment_nsquestion3.*

class NSFragment3 : Fragment(), View.OnClickListener {
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nsquestion3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        nsq3_ib1.setOnClickListener(this)
        nsq3_ib2.setOnClickListener(this)
    }



    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.nsq3_ib1 -> {
                Test.nsresult1(navigateWithIndex(1))
                println(Test.ns1)
            }
            R.id.nsq3_ib2 -> {
                Test.nsresult2(navigateWithIndex(2))
                println(Test.ns2)
            }
        }
    }

    fun navigateWithIndex(index : Int){
        val bundle = bundleOf("index" to index)
        navController.navigate(R.id.action_NSFragment3_to_TFFragment1,bundle)
    }

}