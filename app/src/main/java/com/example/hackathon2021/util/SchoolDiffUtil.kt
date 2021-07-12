package com.example.hackathon2021.util

import androidx.recyclerview.widget.DiffUtil
import com.example.hackathon2021.data.School

class SchoolDiffUtil : DiffUtil.ItemCallback<School>() {
    override fun areItemsTheSame(oldItem: School, newItem: School): Boolean {
        return oldItem.code==newItem.code
    }

    override fun areContentsTheSame(oldItem: School, newItem: School): Boolean {
        return oldItem==newItem
    }
}