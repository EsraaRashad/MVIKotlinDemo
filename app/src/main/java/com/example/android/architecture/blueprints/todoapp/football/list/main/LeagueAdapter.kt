package com.example.android.architecture.blueprints.todoapp.football.list.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.football.data.model.Round

class LeagueAdapter
    : RecyclerView.Adapter<LeagueAdapter.MyViewHolder>(){

    private var roundObject : Round?=null
    private var roundsList : ArrayList<Round> = ArrayList()

    fun addRoundsList (list: ArrayList<Round>){
        roundsList.addAll(list)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item , parent, false)
        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int = roundsList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        roundObject = roundsList[position]
        holder.bind(roundObject!!)
    }

    inner class MyViewHolder (itemView : View)
        : RecyclerView.ViewHolder(itemView) {
        var nameTextView: TextView
        var linearLayout: LinearLayout

        init {
            nameTextView = itemView.findViewById<View>(R.id.txtName) as TextView
            linearLayout = itemView.findViewById<View>(R.id.linearLayout) as LinearLayout
        }

        fun bind (item: Round){
            nameTextView.text=item.name
        }
    }
}