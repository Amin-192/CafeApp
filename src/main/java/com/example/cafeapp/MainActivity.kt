package com.example.cafeapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private var mOrderMessage: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views
        val donutImage: ImageView = findViewById(R.id.image_donut)
        val iceCreamImage: ImageView = findViewById(R.id.image_ice_cream)
        val froyoImage: ImageView = findViewById(R.id.image_froyo)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        // Set click listeners
        donutImage.setOnClickListener {
            mOrderMessage = getString(R.string.donut_order_message)
            Toast.makeText(this, mOrderMessage, Toast.LENGTH_SHORT).show()
        }

        iceCreamImage.setOnClickListener {
            mOrderMessage = getString(R.string.ice_cream_order_message)
            Toast.makeText(this, mOrderMessage, Toast.LENGTH_SHORT).show()
        }

        froyoImage.setOnClickListener {
            mOrderMessage = getString(R.string.froyo_order_message)
            Toast.makeText(this, mOrderMessage, Toast.LENGTH_SHORT).show()
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Navigate to the order screen", Snackbar.LENGTH_LONG).show()
            // Add navigation logic to another activity here if needed
        }
    }
}