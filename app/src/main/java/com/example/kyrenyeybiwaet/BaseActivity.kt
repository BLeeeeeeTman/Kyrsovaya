package com.example.kyrenyeybiwaet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class BaseActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //       setContentView(R.layout.activity_base)

        val timeList:RecyclerView = findViewById(R.id.timeList)
        val time = arrayListOf<Time>()

        time.add(Time(1,"true/false","1"))
        time.add(Time(2,"true/false","2"))
        time.add(Time(3,"true/false","3"))
        time.add(Time(4,"true/false","4"))


    }

}




