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
import kotlinx.android.synthetic.main.fragment_jpquestion2.*

class JPFragment2 : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jpquestion2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        jpq2_ib1.setOnClickListener(this)
        jpq2_ib2.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.jpq2_ib1 -> {
                Test.jpresult1(navigateWithIndex(1))
            }
            R.id.jpq2_ib2 -> {
                Test.jpresult2(navigateWithIndex(2))
            }
        }
    }
    fun navigateWithIndex(index : Int){
        val bundle = bundleOf("index" to index)
        navController.navigate(R.id.action_JPFragment2_to_JPFragment3,bundle)
    }
}