package com.example.psycology

import android.util.Log
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.psycology.Fragments.LoadFragment

class Test private constructor(){

    private lateinit var question1 : String
    private lateinit var question2 : String
    private val loadingDialogFragment by lazy { LoadFragment() }

    companion object {
        lateinit var navController: NavController
        val instance = Test()
        var ei1 = 0
        var ei2 = 0
        var ns1 = 0
        var ns2 = 0
        var tf1 = 0
        var tf2 = 0
        var jp1 = 0
        var jp2 = 0

        fun eiresult1(navigateWithIndex: Unit) {
            val test = Test.instance
            test.question1 = "1"
            ei1++
            Log.d("test",test.question1)
        }
        fun eiresult2(navigateWithIndex: Unit) {
            val test = Test.instance
            test.question2 = "2"
            ei2++
            Log.d("test",test.question2)
        }
        fun nsresult1(navigateWithIndex: Unit) {
            val test = Test.instance
            test.question1 = "1"
            ns1++
            Log.d("test",test.question1)
        }
        fun nsresult2(navigateWithIndex: Unit) {
            val test = Test.instance
            test.question2 = "2"
            ns2++
            Log.d("test",test.question2)
        }
        fun tfresult1(navigateWithIndex: Unit) {
            val test = Test.instance
            test.question1 = "1"
            tf1++
            Log.d("test",test.question1)
        }
        fun tfresult2(navigateWithIndex: Unit) {
            val test = Test.instance
            test.question2 = "2"
            tf2++
            Log.d("test",test.question2)
        }
        fun jpresult1(navigateWithIndex: Unit) {
            val test = Test.instance
            test.question1 = "1"
            jp1++
            Log.d("test",test.question1)
        }
        fun jpresult2(navigateWithIndex: Unit) {
            val test = Test.instance
            test.question2 = "2"
            jp2++
            Log.d("test",test.question2)
        }
        fun allresult(view: View) {
            navController = Navigation.findNavController(view)
            if(ei1 > 1) {
                if(ns1 > 1) {
                    if(tf1 > 1) {
                        if(jp1 > 1) {
                            println("ESFJ")
                            navController.navigate(R.id.action_JPFragment3_to_esfjResult)
                        } else {
                            println("ESFP")
                            navController.navigate(R.id.action_JPFragment3_to_esfpResult)
                        }
                    } else {
                        if (jp1 > 1) {
                            println("ESTJ")
                            navController.navigate(R.id.action_JPFragment3_to_estjResult)
                        } else {
                            println("ESTP")
                            navController.navigate(R.id.action_JPFragment3_to_estpResult)
                        }
                    }
                } else {
                    if(tf1 > 1) {
                        if(jp1 > 1) {
                            println("ENFJ")
                            navController.navigate(R.id.action_JPFragment3_to_enfjResult)
                        } else {
                            println("ENFP")
                            navController.navigate(R.id.action_JPFragment3_to_enfpResult)
                        }
                    } else {
                        if (jp1 > 1) {
                            println("ENTJ")
                            navController.navigate(R.id.action_JPFragment3_to_entjResult)
                        } else {
                            println("ENTP")
                            navController.navigate(R.id.action_JPFragment3_to_entpResult)
                        }
                    }
                }
            } else {
                if(ns1 > 1) {
                    if(tf1 > 1) {
                        if(jp1 > 1) {
                            println("ISFJ")
                            navController.navigate(R.id.action_JPFragment3_to_isfjResult)
                        } else {
                            println("ISFP")
                            navController.navigate(R.id.action_JPFragment3_to_isfpResult)
                        }
                    } else {
                        if (jp1 > 1) {
                            println("ISTJ")
                            navController.navigate(R.id.action_JPFragment3_to_istjResult)
                        } else {
                            println("ISTP")
                            navController.navigate(R.id.action_JPFragment3_to_istpResult)
                        }
                    }
                } else {
                    if(tf1 > 1) {
                        if(jp1 >1) {
                            println("INFJ")
                            navController.navigate(R.id.action_JPFragment3_to_infjResult)
                        } else {
                            println("INFP")
                            navController.navigate(R.id.action_JPFragment3_to_infpResult)
                        }
                    } else {
                        if (jp1 > 1) {
                            println("INTJ")
                            navController.navigate(R.id.action_JPFragment3_to_intjResult)
                        } else {
                            println("INTP")
                            navController.navigate(R.id.action_JPFragment3_to_intpResult)
                        }
                    }
                }
            }
        }
    }
}

