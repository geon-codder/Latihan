package com.geco.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.widget.TextView
import com.geco.latihan.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    private lateinit var binding : Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        normalExplicit()
    }

    private fun normalExplicit(){
        binding.tvNama.text = intent.getStringExtra("nama")
        binding.tvAlamat.text = intent.getStringExtra("alamat")
        binding.tvAyang.text = intent.getStringExtra("ayang")
        binding.judulscreen.text = intent.getStringExtra("judul")
    }
    private fun bundle(){

    }
    private fun serializable(){

    }
    private fun parcelable(){

    }
}