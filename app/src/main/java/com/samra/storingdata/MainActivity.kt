package com.samra.storingdata

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.samra.storingdata.databinding.ActivityMainBinding
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Shared preferences - XML - key-value , en balacasi
        sharedPref = getSharedPreferences("com.samra.storingdata" , MODE_PRIVATE)
        var userPrefAge = sharedPref.getInt("age" , -1)
        if(userPrefAge <0){
            binding.textView.text = "Your age is: "
        }else {
            binding.textView.text = "Your age is ${userPrefAge}"
        }

    }

    fun save(view:View){
        val myAge = binding.editText.text.toString().toIntOrNull()
        if(myAge!=null){
            binding.textView.text= "Your age: ${myAge}"
            sharedPref.edit().putInt("age" , myAge).apply()
        }

    }
    fun delete(view:View){
        sharedPref.edit().remove("age").apply()
    }
}