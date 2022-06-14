package com.geco.latihan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.geco.latihan.data.ResponseBody
import com.geco.latihan.data.SignInBody
import com.geco.latihan.databinding.FragmentLoginBinding
import com.geco.latihan.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val email = "${binding.etEmailLogin}"
            val password = "${binding.etPasswordLogin}"

//            signin(email,password)
            val loginInfo = SignInBody(email,password)
            RetrofitInstance.getInstance().signin(loginInfo)
                .enqueue(object: Callback<ResponseBody> {
                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    }
                    override fun onResponse(
                        call: Call<ResponseBody>,
                        response: Response<ResponseBody>
                    ) {
                        if (response.code() == 201) {
                            Toast.makeText(activity, "Login success!", Toast.LENGTH_SHORT)
                                .show()
                            val actionToActivity2 = LoginFragmentDirections.actionLoginFragmentToActivity2()
                            findNavController().navigate(actionToActivity2)
                        }
                        else{
                            Toast.makeText(activity, "Login failed!", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                })
        }
        binding.tvDaftar.setOnClickListener {
            val actionToRegisterFragment = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            findNavController().navigate(actionToRegisterFragment)
        }
    }

//    fun signin(email: String, password: String) {
//        val loginInfo = SignInBody(email,password)
//        RetrofitInstance.getInstance().signin(loginInfo)
//            .enqueue(object: Callback<ResponseBody> {
//                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                }
//                override fun onResponse(
//                    call: Call<ResponseBody>,
//                    response: Response<ResponseBody>
//                ) {
//                    if (response.code() == 201) {
//                        Toast.makeText(activity, "Registration success!", Toast.LENGTH_SHORT)
//                            .show()
//                    }
//                    else{
//                        Toast.makeText(activity, "Registration failed!", Toast.LENGTH_SHORT)
//                            .show()
//                    }
//                }
//            })
//    }

}