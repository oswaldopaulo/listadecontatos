package com.oswaldopaulo.listadecontatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val rvlist: RecyclerView by lazy{
        findViewById<RecyclerView>(R.id.rv_list)
    }

    private val adpter = ContactAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        updateList()
    }

    private fun bindViews(){
        rvlist.adapter = adpter
        rvlist.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList(){
        adpter.updateList(
            arrayListOf(
                Contact("Oswaldo Paulo","(99) 9999-9999","img")
            )

        )
    }

    private fun showToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item_menu1 -> {
                showToast("Menu 1")
                true
            }

            R.id.item_menu2 -> {
                showToast("Menu 2")
                true

            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}