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
            binding.titleTxt.text = toDoData.title
            binding.descriptionTxt.text = toDoData.description

            when(toDoData.priority){
                Priority.HIGH -> binding.priorityIndicator.setCardBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.red))
                Priority.MEDIUM -> binding.priorityIndicator.setCardBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.yellow))
                Priority.LOW -> binding.priorityIndicator.setCardBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.green))
            }

            binding.rowBackground.setOnClickListener {
                val action = ListFragmentDirections.actionListFragmentToUpdateFragment(toDoData)
                binding.root.findNavController().navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(toDoData: List<ToDoData>){
        this.dataList = toDoData
        notifyDataSetChanged()
    }
}