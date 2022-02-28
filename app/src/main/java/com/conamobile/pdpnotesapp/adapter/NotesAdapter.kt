package com.conamobile.pdpnotesapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.conamobile.pdpnotesapp.R
import com.conamobile.pdpnotesapp.model.Story
import com.conamobile.pdpnotesapp.model.Time
import com.google.android.material.imageview.ShapeableImageView

class NotesAdapter(var context: Context, var items: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notes_item, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is StoryViewHolder){
            var tv_time = holder.dateTime
            var tv_name = holder.nameNote

            tv_time.text = Time.timeStamp()
            tv_name.text = items[position]


        }
    }


    override fun getItemCount(): Int {
        return items.size
    }
}

class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var dateTime = view.findViewById<TextView>(R.id.timeNote)
    var nameNote = view.findViewById<TextView>(R.id.name)
}
