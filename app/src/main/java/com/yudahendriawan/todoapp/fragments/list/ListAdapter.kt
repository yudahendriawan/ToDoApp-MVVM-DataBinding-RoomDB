package com.yudahendriawan.todoapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.yudahendriawan.todoapp.R
import com.yudahendriawan.todoapp.data.models.Priority
import com.yudahendriawan.todoapp.data.models.ToDoData
import com.yudahendriawan.todoapp.databinding.RowLayoutBinding

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    var dataList = emptyList<ToDoData>()

    class MyViewHolder(private val binding: RowLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(toDoData: ToDoData){
            binding.toDoData = toDoData
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(toDoData: List<ToDoData>){
        this.dataList = toDoData
        notifyDataSetChanged()
    }
}