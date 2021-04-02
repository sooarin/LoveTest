package com.example.psycology.Fragments.Question

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.psycology.R
import com.example.psycology.Test
import com.example.psycology.Fragments.LoadFragment
import kotlinx.android.synthetic.main.fragment_jpfragment3.*

class JPFragment3 : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    private val loadingDialogFragment by lazy { LoadFragment() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jpfragment3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        jpq3_ib1.setOnClickListener(this)
        jpq3_ib2.setOnClickListener(this)

    }


    override fun onClick(v: View?) {

        when(v?.id) {
            R.id.jpq3_ib1 -> {
                showDialog()
                val handler: Handler = Handler()
                handler.postDelayed({
                    hideDialog()
                }, 2000)
                Test.jpresult1(navigateWithIndex(1))
                println(Test.jp1)
                view?.let { Test.allresult(it) }
            }
            R.id.jpq3_ib2 -> {
                showDialog()
                val handler: Handler = Handler()
                handler.postDelayed({
                    hideDialog()
                }, 2000)
                Test.jpresult2(navigateWithIndex(2))
                println(Test.jp2)
                view?.let { Test.allresult(it) }
            }
        }
    }
    fun navigateWithIndex(index : Int){
        val bundle = bundleOf("index" to index)

        //navController.navigate(R.id.action_EIFragment1_to_EIFragment22,bundle)
    }

    private fun showDialog() {
        if (!loadingDialogFragment.isAdded) {
            val fragmentManager = (activity as FragmentActivity).supportFragmentManager
            loadingDialogFragment.show(fragmentManager, "loader")
        }
    }

    private fun hideDialog() {
        if (loadingDialogFragment.isAdded) {
            loadingDialogFragment.dismissAllowingStateLoss()
        }
    }
}