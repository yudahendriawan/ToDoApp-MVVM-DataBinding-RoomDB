package com.yudahendriawan.todoapp.fragments.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.yudahendriawan.todoapp.data.models.ToDoData

class ToDoDiffUtil(
    private val oldList: List<ToDoData>,
    private val newList: List<ToDoData>
) : DiffUtil.Callback() {

    //it returns the size of the old list
    override fun getOldListSize(): Int {
        return oldList.size
    }

    //it returns the size of new list
    override fun getNewListSize(): Int {
        return newList.size
    }

    // called by the DiffUtil to decide whether two object represent the same item.
    // if the item have unique ids, this methods should check their id equality
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    // check whether two items have the same data. it can change its behaviour depending on the UI.
    // this methods called by DiffUtil only if areItemsTheSame return true
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id &&
                oldList[oldItemPosition].title == newList[newItemPosition].title &&
                oldList[oldItemPosition].description == newList[newItemPosition].description &&
                oldList[oldItemPosition].priority == newList[newItemPosition].priority
    }
}