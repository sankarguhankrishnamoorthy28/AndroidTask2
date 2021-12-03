package com.example.androidtask2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var clickCount=0

        val displayUserName=findViewById<TextView>(R.id.dispname)
        val clickMeButton=findViewById<TextView>(R.id.clickevent)
        val userNameInputValue=findViewById<TextInputLayout>(R.id.name)
        val myMap= mutableMapOf<String,Int>()

        clickMeButton.setOnClickListener {

            val userName=userNameInputValue.editText?.text?.toString()
            val maskedvalue=
                if(userName.isNullOrEmpty()) "Someone"
                else userName
            clickCount++


            if (maskedvalue in myMap)
            {
                clickCount=myMap[maskedvalue.toString()]!!+1
                myMap[maskedvalue.toString()]=clickCount
            }
            else
            {
                myMap.put(maskedvalue.toString(),1)
            }

            displayUserName.text="$maskedvalue is Clicked ${myMap[maskedvalue]} Times"


        }
    }
}