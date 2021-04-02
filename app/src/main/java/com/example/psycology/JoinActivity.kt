package com.example.psycology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.psycology.ATask.JoinInsert
import java.util.concurrent.ExecutionException

class JoinActivity:AppCompatActivity() {
    lateinit var state:String
    lateinit var etId: EditText
    lateinit var etPasswd:EditText
    lateinit var etName:EditText
    lateinit var etPhoneNum:EditText
    lateinit var etAddress:EditText
    lateinit var btnJoin: Button
    lateinit var btnCancel:Button
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)
        etId = findViewById(R.id.etId)
        etPasswd = findViewById(R.id.etPasswd)
        etName = findViewById(R.id.etName)
        etPhoneNum = findViewById(R.id.etPhoneNum)
        etAddress = findViewById(R.id.etAddress)
        btnJoin = findViewById(R.id.btnJoin)
        btnCancel = findViewById(R.id.btnCancel)
        //가입 버튼
        btnJoin.setOnClickListener {
                val id = etId.text.toString()
                val passwd = etPasswd.text.toString()
                val name = etName.text.toString()
                val phonenumber = etPhoneNum.text.toString()
                val address = etAddress.text.toString()
                val joinInsert = JoinInsert(id, passwd, name, phonenumber, address)
                try
                {
                    state = joinInsert.execute().get().trim() //.get() : 데이터가 도착하기 전에 조회하는 것을 방지
                    Log.d(TAG, "onClick: $state")
                }
                catch (e: ExecutionException) {
                    e.printStackTrace()
                }
                catch (e:InterruptedException) {
                    e.printStackTrace()
                }
                if (state == "1")
                {
                    Log.d(TAG, "onClick: 삽입 성공")
                    finish()
                }
                else
                {
                    Log.d(TAG, "onClick: 삽입 실패")
                    finish()
                }
        }
        //취소 버튼
        btnCancel.setOnClickListener {
                finish()
        }
    }
    companion object {
        private const val TAG = "main JoinActivity"
    }
}