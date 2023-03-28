package com.example.moodring

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//import com.bumptech.glide.annotation.GlideModule
//import com.bumptech.glide.module.AppGlideModule
//
//@GlideModule
//class MyAppGlideModule : AppGlideModule() {
//    // leave empty for now
//}

class JourneyRecyclerViewAdapter(
    private val entries: List<JourneyTest>,
    private val mListener: OnListFragmentInteractionListener?
    )
    : RecyclerView.Adapter<JourneyRecyclerViewAdapter.EntryViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_journey, parent, false)
        return EntryViewHolder(view)
    }


    inner class EntryViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: JourneyTest? = null
        val mEntryDate: TextView = mView.findViewById<View>(R.id.date) as TextView
        val mEntryEmoji: ImageView = mView.findViewById<View>(R.id.emoji) as ImageView



        override fun toString(): String {
            return mEntryDate.toString()
        }
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val entry = entries[position]

        holder.mItem = entry
        holder.mEntryDate.text = entry.date



        when (entry.select)
            {
                1 -> holder.mEntryEmoji.setImageResource(R.drawable.sad3)
                2 -> holder.mEntryEmoji.setImageResource(R.drawable.sad2)
                3 -> holder.mEntryEmoji.setImageResource(R.drawable.sad)
                4 -> holder.mEntryEmoji.setImageResource(R.drawable.mid)
                5 -> holder.mEntryEmoji.setImageResource(R.drawable.smile)
                6 -> holder.mEntryEmoji.setImageResource(R.drawable.smile2)
                7 -> holder.mEntryEmoji.setImageResource(R.drawable.smile3)
            }


//        Glide.with(holder.mView)
//            .load(R.drawable.kiss)
//            //.placeholder(R.drawable.carrot)
//            .centerInside()
//            .into(holder.mEntryEmoji)


        holder.mView.setOnClickListener {
            holder.mItem?.let { book ->
                mListener?.onItemClick(book)
            }
        }
    }

    override fun getItemCount(): Int {
        return entries.size
    }
}

