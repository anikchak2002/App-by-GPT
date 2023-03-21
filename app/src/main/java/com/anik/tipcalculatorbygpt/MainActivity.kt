package com.anik.tipcalculatorbygpt

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var billAmountEditText: EditText
    private lateinit var tipSeekBar: SeekBar
    private lateinit var tipPercentageTextView: TextView
    private lateinit var calculateButton: Button
    private lateinit var totalTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        billAmountEditText = findViewById(R.id.billAmountEditText)
        tipSeekBar = findViewById(R.id.tipSeekBar)
        tipPercentageTextView = findViewById(R.id.tipPercentageTextView)
        calculateButton = findViewById(R.id.calculateButton)
        totalTextView = findViewById(R.id.totalTextView)

        tipSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tipPercentageTextView.text = "$progress%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        calculateButton.setOnClickListener {
            val billAmount = billAmountEditText.text.toString().toDouble()
            val tipPercentage = tipSeekBar.progress
            val tipAmount = billAmount * tipPercentage / 100
            val total = billAmount + tipAmount

            val df = DecimalFormat("#.##")
            totalTextView.text = "Total: $${df.format(total)}"
        }
    }
}
