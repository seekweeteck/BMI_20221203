package my.edu.tarc.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.bmi.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    //Module level variable
    //lateinit = late initialize
    //val = value vs var = variable
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflate = display the UI
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Root = top of a tree structure -> Layout
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        //Local variable

        binding.buttonReset.setOnClickListener {

        }
        binding.buttonCalculate.setOnClickListener {
            if(binding.editTextHeight.text.isEmpty()){
                binding.editTextHeight.setError(
                    getString(R.string.value_required))
                return@setOnClickListener
            }

            if(binding.editTextWeight.text.isEmpty()){
                binding.editTextWeight.setError(
                    getString(R.string.value_required)
                )
                return@setOnClickListener
            }
            val weight = binding.editTextWeight.text.toString().toFloat()
            val height = binding.editTextHeight.text.toString().toFloat()
            val bmi = weight / (height/100).pow(2)
            //Underweight = below 18.5
            //Normal = 18.5 to 24.9
            //Overweight > 24.9
            if(bmi < 18.5){
                //Underweight
                binding.textViewBMI.text =
                    String.format("%s : %.2f (%s)",
                        getString(R.string.app_name),
                        bmi,
                        getString(R.string.underweight))
                binding.imageViewBMI.setImageResource(R.drawable.under)
            }

        }

    }
}