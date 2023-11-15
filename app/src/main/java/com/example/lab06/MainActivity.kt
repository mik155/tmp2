package com.example.lab06

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.lab06.ui.theme.Fragment1
import com.example.lab06.ui.theme.Fragment2


class MainActivity : FragmentActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val editText: EditText = findViewById(R.id.etext)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            Toast.makeText(this,"DATA SAVED", Toast.LENGTH_SHORT).show()
            val sp: SharedPreferences = getSharedPreferences("mPref", MODE_PRIVATE);
            val editor: SharedPreferences.Editor = sp.edit()
            editor.putString("textV", editText.text.toString())
            editor.apply()
        }

        val sh : SharedPreferences = getSharedPreferences("mPref", MODE_PRIVATE)
        val s : String? = sh.getString("textV", "")
        editText.setText(s)

        val bf1: Button = findViewById(R.id.button1)
        val bf2: Button = findViewById(R.id.button2)

        bf1.setOnClickListener {
            replace(Fragment1())
        }

        bf2.setOnClickListener {
            replace(Fragment2())
        }
    }
    private fun replace(fragment: Fragment)
    {
        val fragmentManager= supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }
}

