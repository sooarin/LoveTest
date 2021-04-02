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
import kotlinx.android.synthetic.main.fragment_tfquestion3.*

class TFFragment3 : Fragment(), View.OnClickListener {

    var option = -1
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        option = arguments?.getInt("index")?:-1
        return inflater.inflate(R.layout.fragment_tfquestion3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        tfq3_ib1.setOnClickListener(this)
        tfq3_ib2.setOnClickListener(this)
        setResult(option)
    }

    fun setResult(option : Int) {
        when(option) {
            2 -> {}
            3 -> {}
            4 -> {}
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tfq3_ib1 -> {
                Test.tfresult1(navigateWithIndex(1))
                println(Test.tf1)
            }
            R.id.tfq3_ib2 -> {
                Test.tfresult2(navigateWithIndex(2))
                println(Test.tf2)
            }
        }
    }

    fun navigateWithIndex(index : Int){
        val bundle = bundleOf("index" to index)
        navController.navigate(R.id.action_TFFragment3_to_JPFragment1,bundle)
    }
}