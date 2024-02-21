package com.example.homework_lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.homework_lab1.databinding.ActivityInfoBinding
import com.example.homework_lab1.Person

class Info_Activity : AppCompatActivity() {
    lateinit var bind : ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val receivedId = intent.getStringExtra(Constanse.Next_Activity)
        val person = persons.find { it.id == receivedId?.toInt() }

        if (person != null) {
            bind.tvFullName.text = Constanse.Full_Name + person.name
            bind.tvBirthDate.text = Constanse.Birth_Date + person.date
            bind.tvPhone.text = Constanse.Phone_Number + person.phoneNumber
            bind.tvEmail.text = Constanse.Person_Email + person.email
            bind.tvGroup.text = Constanse.Group_SIS_2119
            bind.tvAddress.text = Constanse.Address

        }
    }
    fun onClickBackSecAc(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun onClickChange(view: View){
        val receivedId = intent.getStringExtra(Constanse.Next_Activity)
        val person = persons.find { it.id == receivedId?.toInt() }
        val intent = Intent(this, ChangeActivity::class.java)
        intent.putExtra(Constanse.Next_Activity, person?.id.toString())
        startActivity(intent)
    }
}

