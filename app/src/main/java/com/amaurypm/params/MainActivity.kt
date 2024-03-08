package com.amaurypm.params

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun btnClick(view: View) {
        Toast.makeText(this, "Clic en el botón", Toast.LENGTH_SHORT).show()
        Log.d("LOGS", "El usuario dio clic al botón")

        val params = Bundle()

        params.putString("name", "Amaury")
        params.putInt("total", 500)

        val params2 = Bundle()

        params2.apply {
            putString("name", "Amaury")
            putInt("total", 500)
        }

        val param3 = bundleOf(
            "name" to "Amaury",
            "total" to 500,
            "promocion" to true
        )

        val intent = Intent(this, MainActivity2::class.java)

        intent.putExtras(params)

        startActivity(intent)
    }
}