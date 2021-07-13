package com.example.hackathon2021.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon2021.R
import com.example.hackathon2021.data.Board
import com.example.hackathon2021.util.BoardDiffUtil


class BoardListAdapter(val onClick: (board: Board) -> Unit) :
    ListAdapter<Board, BoardListAdapter.ViewHolder>(BoardDiffUtil()) {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tv_title_rv_item_board)
        val tvContent: TextView = view.findViewById(R.id.tv_contents_rv_item_board)
        val btnComments: Button = view.findViewById(R.id.btn_comments_rv_item_board)
        val tvName: TextView = view.findViewById(R.id.tv_name_rv_item_board)
        val tvTime: TextView = view.findViewById(R.id.tv_time_rv_item_board)

        fun bind(board: Board) {
            tvTitle.text = board.title
            tvContent.text = board.content
            btnComments.apply {
                text = board.commentsNum.toString()
                setOnClickListener {
                    onClick.invoke(board)
                }
            }
            if (board.isMe) {
                tvName.apply {
                    text = "나"
                    setTextColor(Color.parseColor("#FF6200EE"))
                }
            } else {
                tvName.apply {
                    if (board.user.name == "익명") {
                        text = board.user.name
                    } else {
                        text = "${board.user.grade}-${board.user.classNum} ${board.user.name}"
                    }
                    setTextColor(Color.BLACK)
                }
            }
            tvTime.text = board.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_item_board,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}