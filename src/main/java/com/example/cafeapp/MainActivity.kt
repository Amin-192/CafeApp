package com.example.cafeapp // Replace with your package name

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var mOrderMessage: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views by their IDs
        val donutImage: ImageView = findViewById(R.id.image_donut)
        val iceCreamImage: ImageView = findViewById(R.id.image_ice_cream)
        val froyoImage: ImageView = findViewById(R.id.image_froyo)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        // Set click listeners for each dessert
        donutImage.setOnClickListener {
            mOrderMessage = getString(R.string.donut_order_message)
            Toast.makeText(this, "Selected: $mOrderMessage", Toast.LENGTH_SHORT).show()
        }

        iceCreamImage.setOnClickListener {
            mOrderMessage = getString(R.string.ice_cream_order_message)
            Toast.makeText(this, "Selected: $mOrderMessage", Toast.LENGTH_SHORT).show()
        }

        froyoImage.setOnClickListener {
            mOrderMessage = getString(R.string.froyo_order_message)
            Toast.makeText(this, "Selected: $mOrderMessage", Toast.LENGTH_SHORT).show()
        }

        fab.setOnClickListener {
            if (mOrderMessage.isNullOrEmpty()) {
                Toast.makeText(this, "Please select an item first", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, OrderActivity::class.java)
                intent.putExtra("ORDER_MESSAGE", mOrderMessage)
                startActivity(intent)
            }
        }
    }
}