package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonNumbersEvent(view: View) {
        if (isNewOp) {
            etShowText.setText("")
        }
        isNewOp = false
        val buSelect = view as Button
        var buClickValue = etShowText.text.toString()
        when (buSelect.id) {
            bu0.id -> {
                buClickValue += "0"
            }
            bu1.id -> {
                buClickValue += "1"
            }
            bu2.id -> {
                buClickValue += "2"
            }
            bu3.id -> {
                buClickValue += "3"
            }
            bu4.id -> {
                buClickValue += "4"
            }
            bu5.id -> {
                buClickValue += "5"
            }
            bu6.id -> {
                buClickValue += "6"
            }
            bu7.id -> {
                buClickValue += "7"
            }
            bu8.id -> {
                buClickValue += "8"
            }
            bu9.id -> {
                buClickValue += "9"
            }
            buDot.id -> {
//                TODO :prevent adding more than 1 dot
                buClickValue = "."
            }
            buPM.id -> {
                buClickValue = "-" + buClickValue
            }
        }
        etShowText.setText(buClickValue)
    }

    var op = "*"
    var oldNumbers = ""
    var isNewOp = true;
    fun buttonOpsEvent(view: View) {
        val buSelect = view as Button
        var buClickValue = etShowText.text.toString()
        when (buSelect.id) {
            bumultiply.id -> {
                op = "*"
            }
            buplus.id -> {
                op = "+"
            }
            buminus.id -> {
                op = "-"
            }
            budivide.id -> {
                op = "/"
            }
        }
        oldNumbers = etShowText.text.toString()
        isNewOp = true
    }

    fun buttonEqualEvent(view: View) {
        try{
        val newNumber = etShowText.text.toString()
        var finalnumber:Double?=null
        when (op) {
            "*" -> {
                    finalnumber=oldNumbers.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalnumber=oldNumbers.toDouble() / newNumber.toDouble()
            }
            "+" -> {
                finalnumber=oldNumbers.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                finalnumber=oldNumbers.toDouble() - newNumber.toDouble()
            }
        }
        etShowText.setText(finalnumber.toString())
    isNewOp=true}catch(E:NumberFormatException){
                Toast.makeText(this,"Please don't press any button without any reason",Toast.LENGTH_SHORT).show()
        }
    }

    fun buttonPercentageEvent(view: View) {
        try{
        val number:Double=etShowText.text.toString().toDouble()/100
        etShowText.setText(number.toString())
        isNewOp=true}catch(E:NumberFormatException){
            Toast.makeText(this,"Please don't press any button without any reason",Toast.LENGTH_SHORT).show()
        }
    }

    fun buttonCleanEvent(view: View) {
        etShowText.setText("0")
        isNewOp=true
    }

}
