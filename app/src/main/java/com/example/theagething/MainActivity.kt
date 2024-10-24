package com.example.theagething

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.theagething.databinding.ActivityMainBinding
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.ZoneId
import android.icu.util.Calendar
import android.icu.util.ULocale
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor= ContextCompat.getColor(this ,R.color.black)


    binding.butt.setOnClickListener {
        var cons = true
        var c = true
        if(binding.edtxS1.text.toString()==""||binding.edtxS2.text.toString()==""||binding.edtxM1.text.toString()==""||binding.edtxM2.text.toString()==""||binding.edtxD1.text.toString()==""||binding.edtxD2.text.toString()=="")
        {
            c = false
            cons=false
            Toast.makeText(applicationContext, "Empty Fields ...", Toast.LENGTH_LONG).show()
        }

        if (c) {
        if (binding.edtxS1.text.toString().toInt() > binding.edtxS2.text.toString()
                .toInt() ||binding.edtxM1.text.toString()
                .toInt() > 12 || binding.edtxM2.text.toString()
                .toInt() > 12 || binding.edtxD1.text.toString()
                .toInt() <= 0 || binding.edtxD2.text.toString()
                .toInt() <= 0 || binding.edtxM1.text.toString()
                .toInt() <= 0 || binding.edtxM2.text.toString()
                .toInt() <= 0 || binding.edtxS1.text.toString()
                .toInt() <= 0 || binding.edtxS2.text.toString().toInt() <= 0
        ) {
            cons = false
            Toast.makeText(applicationContext, "Invalid value", Toast.LENGTH_LONG).show()

        }
        if (binding.edtxM1.text.toString().toInt() <= 6) {
            if (binding.edtxD1.text.toString().toInt() > 31) {
                cons = false
                Toast.makeText(applicationContext, "Too day", Toast.LENGTH_LONG).show()
            }
        } else if (binding.edtxM1.text.toString().toInt() == 12) {
            var i = 1399
            var flag = false
            while (i >= 0) {
                if (i == binding.edtxS1.text.toString().toInt()) {
                    flag = true
                }
                i -= 4
            }
            if (flag) {
                if (binding.edtxD1.text.toString().toInt() > 30) {
                    cons = false
                    Toast.makeText(applicationContext, "Too day", Toast.LENGTH_LONG).show()
                }

            } else {
                if (binding.edtxD1.text.toString().toInt() > 29) {
                    cons = false
                    Toast.makeText(applicationContext, "Too day", Toast.LENGTH_LONG).show()
                }
            }

        } else {
            if (binding.edtxD1.text.toString().toInt() > 30) {
                cons = false
                Toast.makeText(applicationContext, "Too day", Toast.LENGTH_LONG).show()
            }
        }


        if (binding.edtxM2.text.toString().toInt() <= 6) {
            if (binding.edtxD2.text.toString().toInt() > 31) {
                cons = false
                Toast.makeText(applicationContext, "Too day", Toast.LENGTH_LONG).show()
            }
        } else if (binding.edtxM2.text.toString().toInt() == 12) {
            var i = 1399
            var flag = false
            while (i >= 0) {
                if (i == binding.edtxS2.text.toString().toInt()) {
                    flag = true

                }
                i -= 4
            }
            if (flag) {
                if (binding.edtxD2.text.toString().toInt() > 30) {
                    cons = false
                    Toast.makeText(applicationContext, "Too day", Toast.LENGTH_LONG).show()
                }

            } else {
                if (binding.edtxD2.text.toString().toInt() > 29) {
                    cons = false
                    Toast.makeText(applicationContext, "Too day", Toast.LENGTH_LONG).show()
                }
            }

        } else {
            if (binding.edtxD2.text.toString().toInt() > 30) {
                cons = false
                Toast.makeText(applicationContext, "too day", Toast.LENGTH_LONG).show()
            }
        }


        ///////////////////////
        if (binding.edtxS1.text.toString().toInt() == binding.edtxS2.text.toString().toInt()) {
            if (binding.edtxM1.text.toString().toInt() > binding.edtxM2.text.toString()
                    .toInt()
            ) {
                cons = false
                Toast.makeText(applicationContext, "are you time trveler?", Toast.LENGTH_LONG).show()
            }
            if (binding.edtxM1.text.toString().toInt() == binding.edtxM2.text.toString()
                    .toInt()
            ) {
                if (binding.edtxD1.text.toString().toInt() > binding.edtxD2.text.toString()
                        .toInt()
                ) {
                    cons = false
                    Toast.makeText(applicationContext, "haven't birth yet", Toast.LENGTH_LONG).show()
                }
                if (binding.edtxD1.text.toString().toInt() == binding.edtxD2.text.toString()
                        .toInt()
                ) {
                    cons = false
                    Toast.makeText(applicationContext, "Happy Birthday", Toast.LENGTH_LONG).show()
                    //kinda not birth yet
                }
            }

        }
        if (cons) {
            var totalD = 0
            var totalM = 0
            var totalS = 0
            /////DAY
//            if(binding.edtxM1.text.toString().toInt()==binding.edtxM2.text.toString().toInt())
//            {
//
//            }
            if (binding.edtxM1.text.toString().toInt() <= 6) {
                totalD = 31 - binding.edtxD1.text.toString().toInt()
            } else if (binding.edtxM1.text.toString().toInt() == 12) {
                var i = 1399
                var flag = false
                while (i >= 0) {
                    if (i == binding.edtxS1.text.toString().toInt()) {
                        flag = true

                    }
                    i -= 4
                }
                if (flag) {
                    totalD = 30 - binding.edtxD1.text.toString().toInt()

                } else {
                    totalD = 29 - binding.edtxD1.text.toString().toInt()

                }
            } else {
                totalD = 30 - binding.edtxD1.text.toString().toInt()
            }
            /////month
            totalM = 12 - binding.edtxM1.text.toString().toInt()
            ////saal both together
            totalS = (binding.edtxS2.text.toString().toInt() - binding.edtxS1.text.toString()
                .toInt()) - 1
            /////day 2
            totalD += binding.edtxD2.text.toString().toInt()
            /////month 2
            totalM += binding.edtxM2.text.toString().toInt() - 1

            ///////

            if (binding.edtxM2.text.toString().toInt() <= 6) {
                while (totalD >= 31) {
                    totalD -= 31
                    totalM++
                }
            } else if (binding.edtxM2.text.toString().toInt() == 12) {
                var i = 1399
                var flag = false
                while (i >= 0) {
                    if (i == binding.edtxS2.text.toString().toInt()) {
                        flag = true

                    }
                    i -= 4
                }
                if (flag) {
                    while (totalD >= 30) {
                        totalD -= 30
                        totalM++
                    }

                } else {
                    while (totalD >= 29) {
                        totalD -= 29
                        totalM++
                    }
                }
            } else {
                while (totalD >= 30) {
                    totalD -= 30
                    totalM++
                }
            }
            while (totalM >= 12) {
                totalM -= 12
                totalS++
            }
            if (totalS>70)
            {Toast.makeText(applicationContext, "Hi Granny...", Toast.LENGTH_LONG).show()}



            //////
            binding.txvuh.text = "You have : "
            binding.txviewR.text = "$totalS Year(s) & $totalM Month(es) & $totalD Day(s)"
            binding.textQ.text = "Time is runnig out , stand up & Do some shit"

            /////end of onclick butt

        }
    }
}
/////
//        val tehranTime = ZonedDateTime.now(ZoneId.of("Asia/Tehran"))
//
//        val yearT = tehranTime.year.toString()
//        val monthT = tehranTime.monthValue.toString()
//        val dayT = tehranTime.dayOfMonth.toString()

        val calendar = Calendar.getInstance(ULocale("fa_IR@calendar=persian"))

        val yearT = calendar.get(Calendar.YEAR)
        val monthT = calendar.get(Calendar.MONTH) + 1 // Months are zero-indexed
        val dayT = calendar.get(Calendar.DAY_OF_MONTH)

        binding.buttonNow.setOnClickListener {
            binding.edtxM2.setText(monthT.toString())
            binding.edtxD2.setText(dayT.toString())
            binding.edtxS2.setText(yearT.toString())
        }
    }
////

}