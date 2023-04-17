package com.example.vic_sqllteapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var ediname:EditText
    lateinit var ediemail:EditText
    lateinit var edinumber:EditText
    lateinit var btnsave:Button
    lateinit var btnview:Button
    lateinit var btndelete:Button
    lateinit var db:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ediname = findViewById(R.id.edi_name)
        ediemail = findViewById(R.id.edi_email)
        edinumber = findViewById(R.id.edi_number)
        btnsave = findViewById(R.id.btn_save)
        btnview = findViewById(R.id.btn_view)
        btndelete = findViewById(R.id.btn_delete)


        db = openOrCreateDatabase("vicdb", Context.MODE_PRIVATE, null)

        db.execSQL("CREATE TABLE IF NOT EXISTS users(jina VARCHAR, arafa VARCHAR, kitambulisho VARCHAR)")

        btnsave.setOnClickListener {
            var jina_edt = ediname.text.toString().trim()
            var arafa_edt = ediemail.text.toString().trim()
            var kitambulisho_edt = edinumber.text.toString().trim()

            if (jina_edt.isEmpty() || arafa_edt.isEmpty() || kitambulisho_edt.isEmpty()) {

                    Toast.makeText(this, "Cannot Submit an empty field", Toast.LENGTH_SHORT).show()
                }else{

                    db.execSQL("INSERT INTO users VALUES( '\"+jina_edit+\"',   '\"+arafa_edit+\"' , '\"kitambulisho_edit+\"')")

                Toast.makeText(this, "DATA SAVED SUCCESSFULLY", Toast.LENGTH_SHORT).show()


                }
        }






    }
}