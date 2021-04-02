package com.example.psycology.Common

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log

object CommonMethod {
    /*public static String ipConfig = "http://192.168.200.151:8989";*/
    var ipConfig = "http://172.30.1.34:8080"
    //public static String ipConfig = "http://121.148.239.200:80";
    // 네트워크에 연결되어 있는가
    fun isNetworkConnected(context: Context):Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = cm.getActiveNetworkInfo()
        if (info != null)
        {
            if (info.getType() === ConnectivityManager.TYPE_WIFI)
            {
                Log.d("isconnected : ", "WIFI 로 설정됨")
            }
            else if (info.getType() === ConnectivityManager.TYPE_MOBILE)
            {
                Log.d("isconnected : ", "일반망으로 설정됨")
            }
            Log.d("isconnected : ", "OK => " + info.isConnected)
            return true
        }
        else
        {
            Log.d("isconnected : ", "False => 데이터 통신 불가!!!")
            return false
        }
    }
}