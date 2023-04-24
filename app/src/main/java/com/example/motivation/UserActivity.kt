package com.example.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Hide support bar
        supportActionBar?.hide()
        binding.buttonSave.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        handleSave()
    }

    private fun handleSave() {
        val name = binding.editYourName.text.toString()
        if (name != "") {
            SecurityPreferences(this).storeString("USER_NAME", name)
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "Digite um nome válido", Toast.LENGTH_LONG).show()
        }
    }
}