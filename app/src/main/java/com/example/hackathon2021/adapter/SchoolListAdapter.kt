package com.example.hackathon2021.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon2021.R
import com.example.hackathon2021.data.School
import com.example.hackathon2021.util.SchoolDiffUtil

class SchoolListAdapter(private val itemClicked: (school: School) -> Unit) :
    ListAdapter<School, SchoolListAdapter.ViewHolder>(SchoolDiffUtil()) {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvSchoolName: TextView = view.findViewById(R.id.tv_school_name_school_rv_item)
        val tvSchoolCode: TextView = view.findViewById(R.id.tv_school_code_school_rv_item)
        fun bind(school: School) {
            tvSchoolName.text = school.name
            tvSchoolCode.text = school.code

            itemView.setOnClickListener {
                itemClicked.invoke(school)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.school_rv_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}