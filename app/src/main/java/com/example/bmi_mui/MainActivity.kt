package com.example.bmi_mui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuCompat
import com.example.bmi_mui.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var isClear: Boolean = false




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculate.setOnClickListener(this)
        if (isClear) {
            isClear = false
            binding.btnCalculate.setText("CALCULATE")

        }
    }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu,menu)
        MenuCompat.setGroupDividerEnabled(menu!!, true);//add horizontal divider

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 ->{

                val intent = Intent(this,Aboutdeveloper::class.java)

                startActivity(intent)
//                Toast.makeText(this,"About BMI", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item2 ->{

                val intent = Intent(this, bmi_chart::class.java)

                //Toast.makeText(this," BMI Chart", Toast.LENGTH_SHORT).show()
                startActivity(intent)
                return true
            }
            R.id.item3 ->{
                finish()
                System.exit(0)
                Toast.makeText(this,"Exit", Toast.LENGTH_SHORT).show()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }
    override fun onClick(view: View) {
        when (view?.id) {
            R.id.btn_calculate -> {

                if (binding.height.text!!.isEmpty() && binding.weight.text!!.isEmpty()) {
                    binding.height.requestFocus()
                    Toast.makeText(this, "Enter the height & Weight", Toast.LENGTH_SHORT).show()
                } else if (binding.weight.text!!.isEmpty()) {
                    binding.weight.requestFocus()
                    Toast.makeText(this, "Enter the weight", Toast.LENGTH_SHORT).show()
                } else if (binding.height.text!!.isEmpty()) {
                    binding.height.requestFocus()
                    Toast.makeText(
                        this@MainActivity,
                        "please enter height  ",
                        Toast.LENGTH_LONG
                    ).show()
                }

                if (isClear) {
                    isClear = false
                    binding.btnCalculate.text = "Calculate"
                    binding.BMIResult.setText("")

                    binding.weight.text!!.clear()
                    binding.height.text!!.clear()
                    Toast.makeText(this, "Cleared", Toast.LENGTH_SHORT).show()
                } else {

                    //Toast.makeText(this@MainActivity, "hello", Toast.LENGTH_LONG).show()

                    // Check if the height EditText and Weight EditText are not empty
                    if (binding.height.text.toString()
                            .isNotEmpty() && binding.weight.text.toString().isNotEmpty()
                    ) {
                        if (!isClear) {
                            // initialize the variable
                            isClear = true
                            binding.btnCalculate.setText("Clear")
                            val height = (binding.height.text.toString()).toDouble()
                            val weight = (binding.weight.text.toString()).toDouble()

                            if (height == 0.0 || weight == 0.0) {
                                Toast.makeText(
                                    this,
                                    "Invalid height or weight ",
                                    Toast.LENGTH_SHORT
                                ).show()

                            } else {
                                val Height_in_metre = height.toFloat() / 100
                                val total = weight.toFloat() / (Height_in_metre * Height_in_metre)
                                val BMI = (total * 100).roundToInt() / 100.0





                               // binding.BMIResult.text = "Your BMI is :-  ${BMI} "
                                // update the status text as per the bmi conditions
                                if (BMI < 18.5) {
                                    binding.BMIResult.text= " Your BMI is :- $BMI \n Health Status:- You are Under Weight"
                                    // Toast.makeText(this@MainActivity, R.string.under_weight, Toast.LENGTH_LONG).show()




                                } else if (BMI >= 18.5 && BMI < 24.9) {

                                    binding.BMIResult.text= " Your BMI is :- $BMI \n Health Status :- You are Healthy"
                                    //
                                    // Toast.makeText(this@MainActivity, R.string.Healthy, Toast.LENGTH_LONG).show()


                                } else if (BMI >= 24.9 && BMI < 30) {
                                    binding.BMIResult.text= " Your BMI is :- $BMI \n Health Status:-Your are Over Weight"
                                    //

                                    // Toast.makeText(this@MainActivity, R.string.over_weight, Toast.LENGTH_LONG).show()


                                } else {
                                    binding.BMIResult.text= " Your BMI is :- $BMI \n Health Status :- Suffering from Obesity"
                                    //
                                    //Toast.makeText(this@MainActivity, R.string.Suffering_from_Obesity, Toast.LENGTH_LONG).show()


                                }
                            }
                        }

                    }


                }


            }

        }
    }

    override fun onResume() {
        super.onResume()
    }


}





