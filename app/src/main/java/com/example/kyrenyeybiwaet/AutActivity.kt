package com.example.kyrenyeybiwaet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class AutActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val userLogin: EditText = findViewById(R.id.edit_text_login_aut)
        val userPassword: EditText = findViewById(R.id.edit_text_password_aut)
        val button: Button = findViewById(R.id.button_aut)
        val linkToReg: TextView = findViewById(R.id.link_to_reg)

        linkToReg.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()


            if (login == "" || password == "" )
                Toast.makeText(this, "Не все поля заполнил,мой друг", Toast.LENGTH_LONG).show()
            else {
                val db = DbHelper(this, null)
                val isAut = db.getUser(login,password)

                if(isAut){
                    Toast.makeText(this, "Пользователь $login авторизован", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPassword.text.clear()

                    val intent = Intent(this, BaseActivity::class.java)
                    startActivity(intent)
                } else
                    Toast.makeText(this, "Пользователь $login НЕ авторизован", Toast.LENGTH_LONG).show()


            }
        }
    }
}




