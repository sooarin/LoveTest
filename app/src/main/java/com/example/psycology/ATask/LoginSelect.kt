package com.example.psycology.ATask

import android.net.http.AndroidHttpClient
import android.os.AsyncTask
import android.util.JsonReader
import android.util.Log
import com.example.psycology.Common.CommonMethod.ipConfig
import com.example.psycology.MemberDTO
import com.example.psycology.SignInActivity.Companion.loginDTO
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.HttpMultipartMode
import org.apache.http.entity.mime.MultipartEntityBuilder
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.Charset

class LoginSelect(id:String, passwd:String): AsyncTask<Void, Void, String>() {
    var id:String
    var passwd:String
    // 데이터베이스에 삽입결과 0보다크면 삽입성공, 같거나 작으면 실패
    // 필수 부분
    //String state = ""; 로그인에서는 state를 안쓰기때문에 필요없다
    var httpClient: HttpClient? = null
    var httpPut: HttpPut? = null
    var httpResponse: HttpResponse? = null
    var httpEntity: HttpEntity? = null
    init{
        this.id = id
        this.passwd = passwd
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
            val putURL = "$ipConfig/user/$id"
            // /app/ 뒤에는 서버의 AController에 적힌 맵핑과 동일하게 적는다.
            // 전송
            var inputStream: InputStream? = null
            httpClient = AndroidHttpClient.newInstance("Android")
            httpPut = HttpPut(putURL)
            httpPut?.setEntity(builder.build())
            httpResponse = httpClient?.execute(httpPut) //여기 라인에서 DB에 보냄
            httpEntity = httpResponse?.getEntity()
            inputStream = httpEntity?.getContent()
            //응답 : JSON형태로 받음
            loginDTO = inputStream?.let { readMessage(it) }
            Log.d(TAG, "doInBackground: $loginDTO")
        }
        catch (e:Exception) {
            e.printStackTrace()
        }
        finally
        {
            if (httpEntity != null)
            {
                httpEntity = null
            }
            if (httpResponse != null)
            {
                httpResponse = null
            }
            if (httpPut != null)
            {
                httpPut = null
            }
            if (httpClient != null)
            {
                httpClient = null
            }
        } //try catch finally
        return "LoginDTO select complete"
    }
    override fun onPostExecute(result:String) {
        super.onPostExecute(result)
        Log.d(TAG, "onPostExecute: $result")
    }
    @Throws(IOException::class)
    fun readMessage(inputStream:InputStream): MemberDTO {
        val reader = JsonReader(InputStreamReader(inputStream, "UTF-8"))
        var id = ""
        var name = ""
        var phonenumber = ""
        var address = ""
        //비밀번호는 가져올 필요가 없고, 보안을 위해 가져오지 않는다.
        reader.beginObject()
        while (reader.hasNext())
        {
            val readStr = reader.nextName()
            if (readStr == "id")
            {
                id = reader.nextString()
            }
            else if (readStr == "name")
            {
                name = reader.nextString()
            }
            else if (readStr == "phonenumber")
            {
                phonenumber = reader.nextString()
            }
            else if (readStr == "address")
            {
                address = reader.nextString()
            }
            else
            {
                reader.skipValue()
            }
        }
        reader.endObject()
        Log.d(TAG, "$id,$name,$phonenumber,$address")
        return MemberDTO(id, name, phonenumber, address)
    }
    companion object {
        private const val TAG = "main LoginSelect"
    }
}