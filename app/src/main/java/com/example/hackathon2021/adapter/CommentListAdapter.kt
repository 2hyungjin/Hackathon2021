package com.example.hackathon2021.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon2021.R
import com.example.hackathon2021.data.Comment
import com.example.hackathon2021.util.CommentDiffUtil
import java.time.LocalDateTime

class CommentListAdapter : ListAdapter<Comment, CommentListAdapter.ViewHolder>(CommentDiffUtil()) {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvWriter: TextView = view.findViewById(R.id.tv_writer_rv_item_comments)
        val tvTime: TextView = view.findViewById(R.id.tv_time_rv_item_comments)
        val tvContent: TextView = view.findViewById(R.id.tv_comment_rv_item_comments)
        fun bind(comment: Comment) {
            if (comment.isWriter) {
                tvWriter.text = "익명(작성자)"
                tvWriter.setTextColor(Color.parseColor("#FF6200EE"))
            } else {
                tvWriter.text = "익명"
                tvWriter.setTextColor(Color.BLACK)
            }
            tvContent.text = comment.comment
            tvTime.text=comment.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_comments, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}