package com.example.cafeapp // Replace with your package name

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cafeapp.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize view binding
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the Action Bar with a back button
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }

        // Retrieve the order message from the Intent
        val orderMessage = intent.getStringExtra("ORDER_MESSAGE") ?: "Your Order"
        binding.orderTextview.text = orderMessage

        // Find the input fields and submit button
        val nameInput: EditText = binding.nameInput
        val emailInput: EditText = binding.emailInput
        val deliveryOptions: RadioGroup = binding.deliveryOptions
        val submitButton: Button = binding.submitButton

        // Handle the submit button click
        submitButton.setOnClickListener {
            val name = nameInput.text.toString()
            val email = emailInput.text.toString()
            val selectedDeliveryOption = findViewById<RadioButton>(deliveryOptions.checkedRadioButtonId)

            val deliveryMessage = when (selectedDeliveryOption?.id) {
                R.id.radio_same_day -> "Same Day Delivery"
                R.id.radio_next_day -> "Next Day Delivery"
                R.id.radio_pick_up -> "Self Pick Up"
                else -> "No Delivery Option Selected"
            }

            val message = "Order for $name ($email)\nDelivery Option: $deliveryMessage\nOrder Details: $orderMessage"


        }
    }

    // Handle the back button in the action bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish() // Close this activity and return to the previous one
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}