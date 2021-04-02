package com.example.psycology

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.psycology.ATask.LoginSelect
import java.util.concurrent.ExecutionException
import java.util.jar.Manifest

class SignInActivity:AppCompatActivity() {
    lateinit var etID:EditText
    lateinit var etPASSWD:EditText
    lateinit var btnLogin:Button
    lateinit var btnJoin:Button
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        checkDangerousPermissions()
        etID = findViewById(R.id.etId)
        etPASSWD = findViewById(R.id.etPASSWD)
        btnLogin = findViewById(R.id.btnLogin)
        btnJoin = findViewById(R.id.btnJoin)
        //로그인 버튼
        btnLogin.setOnClickListener {
                if ((etID.text.toString().length !== 0 && etPASSWD.text.toString().length !== 0))
                { //아이디와 비밀번호의 길이가 0이 아니면
                    val id = etID.text.toString()
                    val passwd = etPASSWD.text.toString()
                    val loginSelect = LoginSelect(id, passwd)
                    try
                    {
                        loginSelect.execute().get()
                    }
                    catch (e: ExecutionException) {
                        e.printStackTrace()
                    }
                    catch (e:InterruptedException) {
                        e.printStackTrace()
                    }
                    if (loginDTO != null)
                    {
                        Log.d(TAG, "onClick: id:$loginDTO")
                    }
                    else
                    { //로그인 정보가 맞지 않으면 토스트창 띄우고 id, pw칸 지우고 id칸에 포커스
                        Toast.makeText(this@SignInActivity, "아이디나 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show()
                        etID.setText("")
                        etPASSWD.setText("")
                        etID.requestFocus()
                    }
                }
        }
        //회원 가입 버튼
        btnJoin.setOnClickListener {
                val intent = Intent(applicationContext, JoinActivity::class.java)
                startActivity(intent)
        }
    }
    private fun checkDangerousPermissions() {
        val permissions = arrayOf<String>(android.Manifest.permission.INTERNET, android.Manifest.permission.ACCESS_NETWORK_STATE, android.Manifest.permission.ACCESS_WIFI_STATE)
        var permissionCheck = PackageManager.PERMISSION_GRANTED
        for (i in permissions.indices)
        {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i])
            if (permissionCheck == PackageManager.PERMISSION_DENIED)
            {
                break
            }
        }
        if (permissionCheck == PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show()
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0]))
            {
                Toast.makeText(this, "권한 설명 필요함.", Toast.LENGTH_LONG).show()
            }
            else
            {
                ActivityCompat.requestPermissions(this, permissions, 1)
            }
        }
    }
    override fun onRequestPermissionsResult(requestCode:Int, permissions:Array<String>, grantResults:IntArray) {
        if (requestCode == 1)
        {
            for (i in permissions.indices)
            {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this, permissions[i] + " 권한이 승인됨.", Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(this, permissions[i] + " 권한이 승인되지 않음.", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    companion object {
        private val TAG = "SignInActivity"
        // 로그인이 성공하면 static 로그인DTO 변수에 담아서
        // 어느곳에서나 접근할 수 있게 한다
        var loginDTO: MemberDTO? = null
    }
}