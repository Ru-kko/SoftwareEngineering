package com.taller02.activities

import android.view.View
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.taller02.R
import java.lang.NumberFormatException

class CreditCapacity : AppCompatActivity() {
    private val ACTUAL_TAX = 0.09
    private lateinit var monthIngress: EditText
    private lateinit var netEgress: EditText
    private lateinit var creditDeb: EditText
    private lateinit var creditTime: EditText
    override fun onStart() {
        super.onStart()
        setContentView(R.layout.credit_capacity)

        monthIngress = findViewById(R.id.inp_net_ingress)
        netEgress = findViewById(R.id.inp_net_egress)
        creditDeb = findViewById(R.id.inp_actual_deb)
        creditTime = findViewById(R.id.inp_credit_time)

        findViewById<AppCompatButton>(R.id.credit_btn).setOnClickListener{
            calculate()
        }

    }
    private fun calculateDebCapacity(ingress: String, actualDeb: String): Float {
        try {
            val ingressValue = ingress.toFloat()
            val debValue = actualDeb.toFloat()

            return (ingressValue * 0.40f) - debValue
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Hay un numero no valido", Toast.LENGTH_SHORT).show()
            return 0f
        }
    }

    private fun maxCredit(capacity: Float, time: String): Int {
       try {
          val timeValue = time.toInt()

          return capacity.toInt() * timeValue
       } catch (e: NumberFormatException) {
           Toast.makeText(this, "Hay un numero no valido", Toast.LENGTH_SHORT).show()
            return 0
       }
    }

    private fun calculate() {
        val resView = findViewById<TableLayout>(R.id.res_view)
        val debCapacity = findViewById<TextView>(R.id.deb_capacity_res)
        val maxMonthPayment = findViewById<TextView>(R.id.max_credit)
        val monthPayment = findViewById<TextView>(R.id.res_month_pay)


        val debCapacityValue = calculateDebCapacity(monthIngress.text.toString(), creditTime.text.toString())
        val maxCredit = maxCredit(debCapacityValue, creditTime.text.toString())
        val monthlyPayment = (maxCredit/creditTime.text.toString().toInt()) * (1+ACTUAL_TAX)


        debCapacity.text = debCapacityValue.toString()
        maxMonthPayment.text = maxCredit.toString()
        monthPayment.text = monthlyPayment.toString()

        resView.visibility = View.VISIBLE
        resView.invalidate()
    }
}