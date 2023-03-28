package com.example.moodring

import android.app.DatePickerDialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Hand.newInstance] factory method to
 * create an instance of this fragment.
 */
class Hand : Fragment(), DatePickerDialog.OnDateSetListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val calendar = Calendar.getInstance()
    private val formatter = SimpleDateFormat("MMM. dd, yyyy", Locale.US)

    private var select = 4

    //var tracker = arrayListOf<JourneyEntry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_hand, container, false)

        var seeker = view.findViewById<SeekBar>(R.id.seeker)
        var date = view.findViewById<TextView>(R.id.tvDate)
        var emoji = view.findViewById<ImageView>(R.id.emoji)
        var ring = view.findViewById<ImageView>(R.id.ring)
        var tvDate = view.findViewById<TextView>(R.id.tvDate)
        val setMood = view.findViewById<Button>(R.id.btnSet)

        date.setOnClickListener{
            context?.let { it1 -> DatePickerDialog(it1, this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show() }

        }



        seeker.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener
        {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean)
            {

                if(progress == 12)
                {
                    emoji.setImageResource(R.drawable.sad3)
                    seeker.performHapticFeedback(4)
                    select = 1


                }
                else if(progress == 24)
                {
                    emoji.setImageResource(R.drawable.sad2)
                    seeker.performHapticFeedback(4)
                    select = 2
                }
                else if(progress == 36)
                {
                    emoji.setImageResource(R.drawable.sad)
                    seeker.performHapticFeedback(4)
                    select = 3
                }
                else if (progress == 50)
                {
                    emoji.setImageResource(R.drawable.mid)
                    seeker.performHapticFeedback(4)
                    select = 4
                }
                else if(progress == 62)
                {
                    emoji.setImageResource(R.drawable.smile)
                    seeker.performHapticFeedback(4)
                    select = 5
                }
                else if(progress == 76)
                {
                    emoji.setImageResource(R.drawable.smile2)
                    seeker.performHapticFeedback(4)
                    select = 6
                }
                else if(progress == 88)
                {
                    emoji.setImageResource(R.drawable.smile3)
                    seeker.performHapticFeedback(4)
                    select = 7
                }

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?)
            {

                return
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?)
            {

                return
            }

        })

        setMood.setOnClickListener{


            if (date.text.toString().lowercase() == "Enter Date".lowercase())
            {
                //Log.d("dateTest", date.text.toString())
                //Toast.makeText(context, "Choose A Date", Toast.LENGTH_SHORT).show()

                emoji.setImageResource(R.drawable.upsidedown)
                date.setTextColor(resources.getColor(R.color.comet))
                date.text = "Enter Date"

                if(seeker.progress == 50)
                {
                    seeker.progress = 51
                }


                Handler(Looper.getMainLooper()).postDelayed(
                    {
                        date.text = "Enter Date"
                        date.setTextColor(resources.getColor(R.color.lilac))


                        seeker.progress = 50

                    },
                    1000 // value in milliseconds
                )


                return@setOnClickListener
            }
            else
            {

                //val entry = JourneyEntry(select,date.text.toString())
                //tracker.add(entry)


                emoji.setImageResource(R.drawable.wink)
                //Toast.makeText(context, "Mood Set", Toast.LENGTH_SHORT).show()

                date.setTextColor(resources.getColor(R.color.comet))
                date.text = "Setting Mood"



                if(seeker.progress == 50)
                {
                    seeker.progress = 51
                }

                Handler(Looper.getMainLooper()).postDelayed(
                    {
                        date.text = "Enter Date"
                        date.setTextColor(resources.getColor(R.color.lilac))

                        seeker.progress = 50

                    },
                    1000 // value in milliseconds
                )


            }

            //context?.resources?.let { it1 -> ring.setColorFilter(it1.getColor(R.color.white)) }
        }

        return view
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int)
    {

        //Log.e("Calender", "$year -- $month -- $dayOfMonth")
        calendar.set(year, month, dayOfMonth)
        displayFormattedDate(calendar.timeInMillis)
    }

    private fun displayFormattedDate(timestamp: Long)
    {
        view?.findViewById<TextView>(R.id.tvDate)?.text = formatter.format(timestamp)
    }




//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment Hand.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            Hand().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}