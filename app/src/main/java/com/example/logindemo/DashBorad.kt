package com.example.logindemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DashBorad : AppCompatActivity() {

    lateinit var txtUsername: TextView
    lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_borad)

        txtUsername = findViewById(R.id.txtUsername)
        btnLogout = findViewById(R.id.btnLogout)

        val userToken = getSharedPreferences("login", Context.MODE_PRIVATE)

        txtUsername.text = userToken.getString("passName", " ")
        btnLogout.setOnClickListener {
            val custom = userToken.edit()
            custom.putString("passName", " ")
            custom.commit()
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }
}