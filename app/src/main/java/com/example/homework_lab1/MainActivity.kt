package com.example.homework_lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.homework_lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bi : ActivityMainBinding

    private lateinit var text_id: String
    private lateinit var passw: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bi.root)
    }

    fun onClickAllPerson(view: View) {
        val intent = Intent(this, GroupActivity::class.java)
        startActivity(intent)
    }
    fun onClickNextActivity(view: View){
        text_id = bi.edId.text.toString()
        passw = bi.edPassword.text.toString()

        for((index, i) in Person_id_and_passw.id.withIndex()){
            if(text_id.toInt() == i && passw == Person_id_and_passw.password[index]){
                val intent = Intent(this, Info_Activity::class.java)
                intent.putExtra("change", text_id)
                intent.putExtra(Constanse.Next_Activity, text_id)
                startActivity(intent)
                bi.incorrectText.text = ""
            }
            else{
                bi.incorrectText.text = "Incorrect password or id"
          }
        }
    }

}

