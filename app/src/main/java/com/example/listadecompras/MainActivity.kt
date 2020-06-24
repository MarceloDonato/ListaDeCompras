package com.example.listadecompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpListeners()
        setUpRecyclerView()

    }

    // para compartilhar a lista
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.share_menu){
            val shareIntent = Intent().apply {
                this.action = Intent.ACTION_SEND
                this.putExtra(Intent.EXTRA_TEXT, "We are sharing data betwwen two app")
                this.type = "text/plain"
            }
            startActivity(shareIntent)
        }else{
            return super.onOptionsItemSelected(item)
        }
        return true
    }
    // até aqui
    // começo do codigo
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
