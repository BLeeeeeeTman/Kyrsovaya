package com.example.kyrenyeybiwaet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)


        val userLogin: EditText = findViewById(R.id.edit_text_login)
        val userPassword: EditText = findViewById(R.id.edit_text_password)
        val userNumber: EditText = findViewById(R.id.edit_text_number)
        val button: Button = findViewById(R.id.button_login)
        val linkToAut: TextView = findViewById(R.id.link_to_aut)

        linkToAut.setOnClickListener{
            val intent_aut = Intent(this, AutActivity::class.java)
            startActivity(intent_aut)

        }
            button.setOnClickListener {
                val login = userLogin.text.toString().trim()
                val password = userPassword.text.toString().trim()
                val number = userNumber.text.toString().trim()

                if (login == "" || password == "" || number == "")
                    Toast.makeText(this, "Не все поля заполнил,мой друг", Toast.LENGTH_LONG).show()
                else {
                    val user = User(login, password, number)

                    val db = DbHelper(this, null)
                    db.addUser(user)
                    Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_LONG).show()

                    userLogin.text.clear()
                    userPassword.text.clear()
                    userNumber.text.clear()
                }
            }


        }
    }
