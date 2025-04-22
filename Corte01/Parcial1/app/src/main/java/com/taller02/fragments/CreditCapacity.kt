package com.taller02.fragments

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.taller02.R
import com.taller02.domain.CreditCapacity
import java.text.ParseException

class CreditCapacity : Fragment(R.layout.credit_capacity) {
    private lateinit var monthIngress: EditText
    private lateinit var netEgress: EditText
    private lateinit var creditDeb: EditText
    private lateinit var creditTime: EditText
    private lateinit var resView: TableLayout
    private lateinit var debCapacity: TextView
    private lateinit var maxMonthPayment: TextView
    private lateinit var monthPayment: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onStart()

        monthIngress = view.findViewById(R.id.inp_net_ingress)
        netEgress = view.findViewById(R.id.inp_net_egress)
        creditDeb = view.findViewById(R.id.inp_actual_deb)
        creditTime = view.findViewById(R.id.inp_credit_time)
        resView = view.findViewById(R.id.res_view)
        debCapacity = view.findViewById(R.id.deb_capacity_res)
        maxMonthPayment = view.findViewById(R.id.max_credit)
        monthPayment = view.findViewById(R.id.res_month_pay)


        view.findViewById<AppCompatButton>(R.id.credit_btn).setOnClickListener {
            calculate()
        }

    }

    private fun calculate() {
        try {
            val calculator = CreditCapacity(
                monthIngress = monthIngress.text.toString().toFloat(),
                creditTime = creditTime.text.toString().toInt(),
                creditDeb = creditDeb.text.toString().toFloat(),
                netEgress = netEgress.text.toString().toFloat()
            )

            val debCapacityValue = calculator.calculateDebCapacity()
            val maxCredit = calculator.maxCredit()
            val monthlyPayment = calculator.maxCredit()

            debCapacity.text = debCapacityValue.toString()
            maxMonthPayment.text = maxCredit.toString()
            monthPayment.text = monthlyPayment.toString()

        } catch (e: ParseException) {
            Toast.makeText(requireContext(), "Hay un numero no valido", Toast.LENGTH_SHORT).show()
        }




        resView.visibility = View.VISIBLE
        resView.invalidate()
    }
}