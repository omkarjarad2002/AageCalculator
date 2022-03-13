package com.jaradomkar.agtominutecalculator

import android.app.DatePickerDialog
import android.net.wifi.rtt.CivicLocationKeys.FLOOR
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.time.LocalDate.now
import java.time.MonthDay
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ID = findViewById<Button>(R.id.btnDatePicker)
        ID.setOnClickListener{View->
            ClickDatePicker(View)
        }
    }

    fun ClickDatePicker(view: View){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{
                view, selectedYear, selectedMonth, selecteddayofmonth->
                Toast.makeText(this,"Selected date is $selectedMonth/${selecteddayofmonth+1}/$selectedYear ",Toast.LENGTH_SHORT).show()

            val selectedDate = "$selecteddayofmonth/${selectedMonth+1}/$selectedYear"
            val tvSelectedDate = findViewById<TextView>(R.id.tvSelectedDate)
            tvSelectedDate.setText(selectedDate)


            val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate= simpleDateFormat.parse(selectedDate)

//                val birthTime = (selecteddayofmonth*24/60)+(((selectedMonth+1)*24/60)/60)+((((selectedYear*24)/60)/60)/60)
                val Year_Now = 2021-selectedYear
                val month_Now = 12-(selectedMonth+1)

            val ageinminuteid = findViewById<TextView>(R.id.tvSelectedInMinutes)
                if(Year_Now<=0 && month_Now != 0 && selectedYear <=2021){
                    ageinminuteid.setText("$month_Now"+" months old!")
                }else if(month_Now<=0 && Year_Now !=0){
                    ageinminuteid.setText("$Year_Now"+" years old!")
                }else if(Year_Now >=1 && month_Now>=1){
            ageinminuteid.setText("$month_Now"+" months & "+"$Year_Now"+" years old!")
            }else{
                    ageinminuteid.setText("Sorry We can't calculate your age !")
            }}
            ,year
            ,month
            ,day).show()
    }
}