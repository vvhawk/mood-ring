package com.example.moodring

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.nio.channels.SelectionKey
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity()
{
    private val handFragment = Hand()
    private val journeyFragment = Journey()

    private val calendar = Calendar.getInstance()
    private val formatter = SimpleDateFormat("MMM. dd, yyyy", Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        replaceFragment(handFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_hand -> replaceFragment(Hand())
                R.id.ic_journey -> replaceFragment(Journey())

            }
            true
        }

//        var seeker = findViewById<SeekBar>(R.id.seeker)
//        var date = findViewById<TextView>(R.id.tvDate)
//        var emoji = findViewById<ImageView>(R.id.emoji)
//        var ring = findViewById<ImageView>(R.id.ring)
//        var tvDate = findViewById<TextView>(R.id.tvDate)
//
//        date.setOnClickListener{
//            DatePickerDialog(this, this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
//
//        }
//
//
//        seeker.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener
//        {
//            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean)
//            {
//
//                if(progress == 12)
//                {
//                    emoji.setImageResource(R.drawable.sad3)
//                    seeker.performHapticFeedback(4)
//
//
//                }
//                else if(progress == 24)
//                {
//                    emoji.setImageResource(R.drawable.sad2)
//                    seeker.performHapticFeedback(4)
//                }
//                else if(progress == 36)
//                {
//                    emoji.setImageResource(R.drawable.sad)
//                    seeker.performHapticFeedback(4)
//                }
//                else if (progress == 50)
//                {
//                    emoji.setImageResource(R.drawable.mid)
//                    seeker.performHapticFeedback(4)
//                }
//                else if(progress == 62)
//                {
//                    emoji.setImageResource(R.drawable.smile)
//                    seeker.performHapticFeedback(4)
//                }
//                else if(progress == 76)
//                {
//                    emoji.setImageResource(R.drawable.smile2)
//                    seeker.performHapticFeedback(4)
//                }
//                else if(progress == 88)
//                {
//                    emoji.setImageResource(R.drawable.smile3)
//                    seeker.performHapticFeedback(4)
//                }
//
//            }
//
//            override fun onStartTrackingTouch(seekBar: SeekBar?)
//            {
//
//                return
//            }
//
//            override fun onStopTrackingTouch(seekBar: SeekBar?)
//            {
//
//                return
//            }
//
//        })
//    }
//
//    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int)
//    {
//
//        //Log.e("Calender", "$year -- $month -- $dayOfMonth")
//        calendar.set(year, month, dayOfMonth)
//        displayFormattedDate(calendar.timeInMillis)
//    }
//
//    private fun displayFormattedDate(timestamp: Long)
//    {
//        findViewById<TextView>(R.id.tvDate).text = formatter.format(timestamp)
//    }
    }

        fun replaceFragment(fragment: Fragment)
    {
        if (fragment != null)
        {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.content, fragment).commit()
        }
    }

}