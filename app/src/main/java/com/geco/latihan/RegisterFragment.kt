package com.geco.latihan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.geco.latihan.data.ResponseBody
import com.geco.latihan.data.UserBody
import com.geco.latihan.databinding.FragmentRegisterBinding
import com.geco.latihan.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegist.setOnClickListener {
            val namaLengkap = "${binding.etNamaRegister}"
            val email = "${binding.etEmailRegister}"
            val password = "${binding.etPasswordRegister}"

//            signup(namaLengkap,email,password)
            val registerInfo = UserBody(namaLengkap,email,password)
            RetrofitInstance.getInstance().signup(registerInfo)
                .enqueue(object: Callback<ResponseBody> {
                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    }
                    override fun onResponse(
                        call: Call<ResponseBody>,
                        response: Response<ResponseBody>
                    ) {
                        if (response.code() == 201) {
                            Toast.makeText(activity, "Registration success!", Toast.LENGTH_SHORT)
                                .show()
                            val actionToLoginFragment = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
                            findNavController().navigate(actionToLoginFragment)
                        }
                        else{
                            Toast.makeText(activity, "Registration failed!", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                })
        }
        binding.tvMasuk.setOnClickListener {
            val actionToLoginFragment = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            findNavController().navigate(actionToLoginFragment)
        }


    }

//    fun signup(name: String, email: String, password: String) {
//        val registerInfo = UserBody(name,email,password)
//        RetrofitInstance.getInstance().signup(registerInfo)
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