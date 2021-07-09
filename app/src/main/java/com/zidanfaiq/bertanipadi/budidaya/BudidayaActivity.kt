package com.zidanfaiq.bertanipadi.budidaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.zidanfaiq.bertanipadi.R
import com.zidanfaiq.bertanipadi.adapter.BudidayaAdapter
import com.zidanfaiq.bertanipadi.data.Budidaya
import com.zidanfaiq.bertanipadi.databinding.ActivityBudidayaBinding
import java.util.*
import kotlin.collections.ArrayList

class BudidayaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBudidayaBinding
    val displayList = ArrayList<Budidaya>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBudidayaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Budidaya"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.rvDataBudidaya.setHasFixedSize(true)
        displayList.addAll(arrayList())

        binding.rvDataBudidaya.layoutManager = GridLayoutManager(this, 2)
        val DataBudidayaAdapter = BudidayaAdapter(displayList, this)
        binding.rvDataBudidaya.adapter = DataBudidayaAdapter
    }

    fun arrayList(): ArrayList<Budidaya> {
        val nama_budidaya = resources.getStringArray(R.array.nama_budidaya)
        val deskripsi_budidaya = resources.getStringArray(R.array.deskripsi_budidaya)
        val image_budidaya = resources.obtainTypedArray(R.array.image_budidaya)
        val listBudidaya = ArrayList<Budidaya>()
        for (position in nama_budidaya.indices) {
            val dataBudidaya = Budidaya(
                nama_budidaya[position],
                deskripsi_budidaya[position],
                image_budidaya.getResourceId(position, 0)
            )
            listBudidaya.add(dataBudidaya)
        }
        image_budidaya.recycle()
        return  listBudidaya
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
                            if (it.nama.toLowerCase(Locale.getDefault()).contains(search)) {
                                displayList.add(it)
                            }
                            binding.rvDataBudidaya.adapter!!.notifyDataSetChanged()
                        }
                    } else {
                        displayList.clear()
                        displayList.addAll(arrayList())
                        binding.rvDataBudidaya.adapter!!.notifyDataSetChanged()
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