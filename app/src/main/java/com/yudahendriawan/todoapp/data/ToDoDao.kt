package com.yudahendriawan.todoapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yudahendriawan.todoapp.data.models.ToDoData

@Dao
interface ToDoDao {

    @Query("SELECT * FROM todo_table ORDER BY id DESC")
    fun getAllData(): LiveData<List<ToDoData>>

    //suspend is used to tell the func in under of coroutines, -> background thread
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(toDoData: ToDoData)

    @Update
    suspend fun updateData(toDoData: ToDoData)

}