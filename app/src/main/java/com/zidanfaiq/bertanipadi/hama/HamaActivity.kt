package com.zidanfaiq.bertanipadi.hama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.zidanfaiq.bertanipadi.R
import com.zidanfaiq.bertanipadi.adapter.HamaAdapter
import com.zidanfaiq.bertanipadi.data.Hama
import com.zidanfaiq.bertanipadi.databinding.ActivityHamaBinding
import java.util.*
import kotlin.collections.ArrayList

class HamaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHamaBinding
    val displayList = ArrayList<Hama>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHamaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Hama"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.rvDataHama.setHasFixedSize(true)
        displayList.addAll(arrayList())

        binding.rvDataHama.layoutManager = GridLayoutManager(this, 2)
        val DataHamaAdapter = HamaAdapter(displayList, this)
        binding.rvDataHama.adapter = DataHamaAdapter
    }

    fun arrayList(): ArrayList<Hama> {
        val title_hama = resources.getStringArray(R.array.title_hama)
        val deskripsi_hama = resources.getStringArray(R.array.deskripsi_hama)
        val gejala_hama = resources.getStringArray(R.array.gejala_hama)
        val pengendalian_hama = resources.getStringArray(R.array.pengendalian_hama)
        val image_hama = resources.obtainTypedArray(R.array.image_hama)
        val listHama = ArrayList<Hama>()
        for (position in title_hama.indices) {
            val dataHama = Hama(
                title_hama[position],
                deskripsi_hama[position],
                gejala_hama[position],
                pengendalian_hama[position],
                image_hama.getResourceId(position, 0)
            )
            listHama.add(dataHama)
        }
        image_hama.recycle()
        return  listHama
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val menuItem = menu!!.findItem(R.id.search)

        if (menuItem != null) {
            val searchView = menuItem.actionView as SearchView
            val editText = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
            editText.hint = "Cari.."

            searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isNotEmpty()) {
                        displayList.clear()
                        val search = newText.toLowerCase(Locale.getDefault())
                        arrayList().forEach {
                            if (it.nama_hama.toLowerCase(Locale.getDefault()).contains(search)) {
                                displayList.add(it)
                            }
                            binding.rvDataHama.adapter!!.notifyDataSetChanged()
                        }
                    } else {
                        displayList.clear()
                        displayList.addAll(arrayList())
                        binding.rvDataHama.adapter!!.notifyDataSetChanged()
                    }
                    return true
                }
            })
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}