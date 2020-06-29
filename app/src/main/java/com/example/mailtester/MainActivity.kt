package com.example.mailtester

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var sendmail:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendmail=findViewById(R.id.button)
        sendmail.setOnClickListener(View.OnClickListener {
           val intent=Intent(this,Home::class.java)
            startActivity(intent)

            Log.d("navigation click", "onNavigationItemSelected")
            Toast.makeText(this, "working", Toast.LENGTH_SHORT).show()
            val intent1 = Intent(Intent.ACTION_SEND)
            intent1.data = Uri.parse("mailto:")
            val recipents =
                    arrayOf("vikashpurty91@gmail.com")
            intent1.type = "message/rfc822"
            intent1.putExtra(Intent.EXTRA_EMAIL, recipents)
            intent1.putExtra(Intent.EXTRA_SUBJECT, "QuizRaiders Reviews")
            intent1.setPackage("com.google.android.gm")
            val chooser = Intent.createChooser(intent1, "Send Feedback Via")
            startActivity(chooser)
        })
    }
}