package com.example.psycology.ATask

import android.net.http.AndroidHttpClient
import android.os.AsyncTask
import android.util.Log
import com.example.psycology.Common.CommonMethod
import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.methods.HttpPut
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.HttpMultipartMode
import org.apache.http.entity.mime.MultipartEntityBuilder
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.Charset

class JoinInsert(id:String, passwd:String, name:String, phonenumber:String, address:String):
    AsyncTask<Void, Void, String>() {
    // 데이터베이스에 삽입결과 0보다크면 삽입성공, 같거나 작으면 실패
    // 필수 부분
    var state = ""
    var httpClient: HttpClient? = null
    var httpPut: HttpPut? = null
    var httpResponse: HttpResponse? = null
    var httpEntity: HttpEntity? = null
    //메인 액티비티의 변수를 받기 위해 변수를 선언하고 생성자를 만든다.
    //무언가를 받고자 할때는 대부분 생성자를 이용한다.
    var id:String
    var passwd:String
    var name:String
    var phonenumber:String
    var address:String
    init{
        this.id = id
        this.passwd = passwd
        this.name = name
        this.phonenumber = phonenumber
        this.address = address
    }
    //기본으로 생성되는 메서드, 지금은 필요 없다
    override fun onPreExecute() {
        super.onPreExecute()
    }
    override fun doInBackground(vararg voids:Void):String {
        try
        {
            // MultipartEntityBuild 생성
            // 필수 부분
            val builder = MultipartEntityBuilder.create()
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
            builder.setCharset(Charset.forName("UTF-8"))
            // 문자열 및 데이터 추가
            builder.addTextBody("id", id, ContentType.create("Multipart/related", "UTF-8"))
            builder.addTextBody("passwd", passwd, ContentType.create("Multipart/related", "UTF-8"))
            builder.addTextBody("name", name, ContentType.create("Multipart/related", "UTF-8"))
            builder.addTextBody("phonenumber", phonenumber, ContentType.create("Multipart/related", "UTF-8"))
            builder.addTextBody("address", address, ContentType.create("Multipart/related", "UTF-8"))
            val putURL = CommonMethod.ipConfig + "/user/$id"
            // 전송
            var inputStream: InputStream? = null
            httpClient = AndroidHttpClient.newInstance("Android")
            httpPut = HttpPut(putURL)
            httpPut?.setEntity(builder.build())
            httpResponse = (httpClient as AndroidHttpClient?)?.execute(httpPut) //여기 라인에서 DB에 보냄
            httpEntity = httpResponse?.getEntity()
            inputStream = httpEntity?.getContent()
            // 응답
            val bufferedReader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
            val stringBuilder = StringBuilder()
            val line: String? = null
            while (true)
            {
                stringBuilder.append(line + "\n")
                bufferedReader.readLine() ?: break
            }
            state = stringBuilder.toString()
            inputStream?.close()
        }
        catch (e:Exception) {
            e.printStackTrace()
        }
        finally
        {
            httpEntity = null
            httpResponse = null
            httpPut = null
            httpClient = null
        }
        return state
    }
    override fun onPostExecute(result:String) {
        super.onPostExecute(result)
        Log.d(TAG, "onPostExecute: $result")
    }
    companion object {
        private const val TAG = "main JoinInsert"
    }
}