package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList = mutableListOf(
            Todo("Test Todo 1", isChecked = false)
        )

        val adapter = TodoAdapter(todoList)
        rvTodo.adapter = adapter
        rvTodo.layoutManager = LinearLayoutManager(this)

        addTodo.setOnClickListener {
            val title = etTodo.text.toString()
            val todo = Todo(title, isChecked = false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}