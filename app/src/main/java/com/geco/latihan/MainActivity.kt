package com.geco.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toolbar
import com.geco.latihan.data.Data
import com.geco.latihan.data.Data2
import com.geco.latihan.databinding.ActivityMainBinding
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnNormal.setOnClickListener {
//            val normalIntent = Intent(this, Activity2::class.java)
//            normalIntent.putExtra("nama", binding.etNamaLengkap.text.toString())
//            normalIntent.putExtra("alamat",binding.etAlamat.text.toString())
//            normalIntent.putExtra("ayang",binding.etNamaAyang.text.toString())
//            normalIntent.putExtra("judul","Explicit Normal Intent")
//            startActivity(normalIntent)
//        }
//
//        binding.btnBundle.setOnClickListener {
//            val bundleIntent = Intent(this@MainActivity, Activity2::class.java)
//            val bundle = Bundle()
//
//            bundle.putString("nama", binding.etNamaLengkap.text.toString())
//            bundle.putString("alamat",binding.etAlamat.text.toString())
//            bundle.putString("ayang",binding.etNamaAyang.text.toString())
//            bundle.putString("judul","Bundle")
//            bundleIntent.putExtras(bundle)
//            startActivity(bundleIntent)
//        }
//
//        binding.btnSerializable.setOnClickListener {
//            val serializableIntent = Intent(this, Activity2::class.java)
//            val dataku = Data(
//                binding.etNamaLengkap.text.toString(),
//                binding.etNamaLengkap.text.toString(),
//                binding.etNamaLengkap.text.toString(),
//                "Serializable"
//            )
//            serializableIntent.putExtra("AN_OBJECT", dataku)
//            startActivity(serializableIntent)
//        }
//
//        binding.btnParcelable.setOnClickListener {
//            val parcelableIntent = Intent(this, Activity2::class.java)
//            val dataqu = Data2(
//                binding.etNamaLengkap.text.toString(),
//                binding.etNamaLengkap.text.toString(),
//                binding.etNamaLengkap.text.toString(),
//                "Parcelable"
//            )
//            parcelableIntent.putExtra("AN_OBJECT", dataqu)
//            startActivity(parcelableIntent)
//        }

    }
}