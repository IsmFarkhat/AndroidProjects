package com.example.homework_lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.homework_lab1.databinding.ActivityGroupBinding

class GroupActivity : AppCompatActivity() {
    lateinit var bind : ActivityGroupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityGroupBinding.inflate(layoutInflater)
        setContentView(bind.root)

        var result = ""
        for ((index, names) in Person_id_and_passw.Group_SIS2119.withIndex()) {
            result += (index + 1).toString() + ") " + names + " - " + Person_id_and_passw.id[index] +  "\n"
        }
        bind.tvAllGroup.text = result
    }
    fun onClickBack(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}