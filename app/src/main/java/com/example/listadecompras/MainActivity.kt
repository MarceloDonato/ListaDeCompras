package com.example.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpListeners()
        setUpRecyclerView()

    }

    private fun setUpListeners() {
        add_item.setOnClickListener {
            val message = edittext_item.text.toString()
            edittext_item.setText("")

            val adapter = message_list_view.adapter
            if (adapter is ListaAdapter){
                adapter.addItem(message)
                message_list_view.scrollToPosition(adapter.itemCount-1)
            }
        }
    }

    private fun setUpRecyclerView() {
        message_list_view.layoutManager = LinearLayoutManager(this)
        message_list_view.adapter = ListaAdapter()
    }
}