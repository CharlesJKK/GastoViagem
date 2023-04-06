package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //O override do onclick é o mesmo que utilizar assim
        // -> binding.calculateButton.setOnClickListener { }
        binding.calculateButton.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if(view.id == R.id.calculate_button){
            calculate()
        }
    }
    private fun calculate(){

        val distance = binding.distance.text.toString().toFloat()
        val price = binding.price.text.toString().toFloat()
        val autonomy = binding.autonomy.text.toString().toFloat()

        val totalValue = (distance * price) / autonomy

        binding.totalValue.text = "R$ ${"%.2f".format(totalValue)}"
        //Toast.makeText(this, totalValue.toString(), Toast.LENGTH_SHORT).show()
    }
}