package com.example.moodring

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.ContentLoadingProgressBar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Journey.newInstance] factory method to
 * create an instance of this fragment.
 */
class Journey : Fragment(), OnListFragmentInteractionListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val view = inflater.inflate(R.layout.fragment_journey_list, container, false)





        val entries = mutableListOf<JourneyEntry>()

        val progressBar = view.findViewById<View>(R.id.progress) as ContentLoadingProgressBar
        val recyclerView = view.findViewById<View>(R.id.list) as RecyclerView
        val context = view.context



        lifecycleScope.launch {
            (activity?.applicationContext as MoodRingApplication).db.journeyDao().getAll().collect(){ databaseList ->
                entries.clear()
                databaseList.map { mappedList ->
                    entries.addAll(listOf(mappedList))
                    recyclerView.adapter?.notifyDataSetChanged()

                }

            }
        }
//
//        entries.add(JourneyTest(1, "date 1"))
//        entries.add(JourneyTest(2, "date 2"))
//        entries.add(JourneyTest(3, "date 3"))
//        entries.add(JourneyTest(4, "date 4"))
//        entries.add(JourneyTest(5, "date 5"))
//        entries.add(JourneyTest(6, "date 6"))
//        entries.add(JourneyTest(7, "date 7"))

//        lifecycleScope.launch(Dispatchers.IO){
//            (activity?.applicationContext as MoodRingApplication).db.journeyDao().insertEntry(JourneyEntry(6,"date 6"))
//        }


        recyclerView.layoutManager = GridLayoutManager(context, 1)
        //updateAdapter(progressBar, recyclerView)
        val adapter = JourneyRecyclerViewAdapter(entries, this@Journey)
        recyclerView.adapter = adapter
        //recyclerView.adapter = JourneyRecyclerViewAdapter(entries, this@Journey)
        progressBar.hide()



        val swipeGesture = object : Swiper(getContext()!!){

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                val position = viewHolder.absoluteAdapterPosition

                when(direction)
                {

                    ItemTouchHelper.LEFT -> {

                        lifecycleScope.launch(Dispatchers.IO){
                            (activity?.applicationContext as MoodRingApplication).db.journeyDao().deleteEntry(adapter.getItem(position))

                            withContext(Dispatchers.Main) {
                                adapter.deleteEntry(position)
                            }

                        }


                        //adapter.deleteEntry(position)

                    }

                }
                //super.onSwiped(viewHolder, direction)

            }

        }

        val touchHelper = ItemTouchHelper(swipeGesture)
        touchHelper.attachToRecyclerView(recyclerView)



        return view

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Journey.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Journey().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onItemClick(item: JourneyEntry) {

        return
    }
}