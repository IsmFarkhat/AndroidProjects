package com.example.homework_lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.homework_lab1.databinding.ActivityChangeBinding

class ChangeActivity : AppCompatActivity() {
    lateinit var bind: ActivityChangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityChangeBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }

    private var isDataChanged = false
    fun onClickChangeData(view: View) {
        if (!isDataChanged) {

            val fieldToChange = bind.edFieldToChange.text.toString()

            val newValue = bind.edNewValue.text.toString()

            val receivedId = intent.getStringExtra(Constanse.Next_Activity)?.toInt()
            Log.d("ChangeActivity", "Received ID: $receivedId")

            val person = persons.find { it.id == receivedId }

            if (person != null) {
                when (fieldToChange.lowercase()) {
                    "name" -> person.name = newValue
                    "birth" -> person.date = newValue
                    "group" -> person.group = newValue
                    "phone" -> person.phoneNumber = newValue
                    "email" -> person.email = newValue
                }
                persons = persons.map { if (it.id == receivedId) person else it }.toMutableList()
                isDataChanged = true

                Log.d("ChangeActivity", "Изменения успешно внесены: $person")

            } else {
                Log.d("ChangeActivity", "Не удалось найти элемент для изменения.")
            }
        }else {
            bind.textYetUse.text = "You've already made changes to the data"
            Log.d("ChangeActivity", "Вы уже внесли изменения в данные.")
        }
    }

    fun onClickBack5(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

