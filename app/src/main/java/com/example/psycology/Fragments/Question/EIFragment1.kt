package com.example.psycology.Fragments.Question

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.psycology.R
import com.example.psycology.Test
import kotlinx.android.synthetic.main.fragment_eiquestion1.*

class EIFragment1 : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eiquestion1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        eiq1_ib1.setOnClickListener(this)
        eiq1_ib2.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.eiq1_ib1 -> {
                Test.eiresult1(navigateWithIndex(1))
            }
            R.id.eiq1_ib2 -> {
                Test.eiresult2(navigateWithIndex(2))
            }
        }
    }

    fun navigateWithIndex(index : Int){
        val bundle = bundleOf("index" to index)
        navController.navigate(R.id.action_EIFragment1_to_EIFragment22,bundle)
        Log.d("bundle!!",bundle.toString())
    }

}