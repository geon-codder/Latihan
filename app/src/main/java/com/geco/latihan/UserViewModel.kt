package com.geco.latihan

import android.widget.Toast
import com.geco.latihan.data.ResponseBody
import com.geco.latihan.data.UserBody
import com.geco.latihan.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel {

    fun signup(name: String, email: String, password: String) {
        val registerInfo = UserBody(name,email,password)
        RetrofitInstance.getInstance().signup(registerInfo)
            .enqueue(object: Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                }
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
//                    if (response.code() == 201) {
//                        Toast.makeText(activity, "Registration success!", Toast.LENGTH_SHORT)
//                            .show()
//
//                    }
//                    else{
//                        Toast.makeText(activity, "Registration failed!", Toast.LENGTH_SHORT)
//                            .show()
//                    }
                }
            })
    }



}