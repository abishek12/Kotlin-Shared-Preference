package com.example.logindemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var edtLoginUsername: EditText
    lateinit var edtLoginUserPass: EditText
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userToken = getSharedPreferences("login", Context.MODE_PRIVATE)

        edtLoginUsername = findViewById(R.id.edtLoginUsername)
        edtLoginUserPass = findViewById(R.id.edtLoginUserPass)
        btnLogin = findViewById(R.id.btnLogin)

        if (userToken.getString("passName", " ") != " ") {
            startActivity(Intent(applicationContext, DashBorad::class.java))
            finish()
        }

        btnLogin.setOnClickListener {
            val name: String = edtLoginUsername.text.toString()
            val pass: String = edtLoginUserPass.text.toString()

//            validation
            if (TextUtils.isEmpty(name)) {
                edtLoginUsername.error = "Required Field..."
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(pass)) {
                edtLoginUserPass.error = "Required Field..."
                return@setOnClickListener
            }
            val user = userToken.edit()
            user.putString("passName", name)
            user.commit()
            startActivity(Intent(applicationContext, DashBorad::class.java))
            finish()
        }
    }
}