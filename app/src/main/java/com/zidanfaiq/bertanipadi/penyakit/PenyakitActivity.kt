package com.zidanfaiq.bertanipadi.penyakit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.zidanfaiq.bertanipadi.R
import com.zidanfaiq.bertanipadi.adapter.PenyakitAdapter
import com.zidanfaiq.bertanipadi.model.Penyakit
import com.zidanfaiq.bertanipadi.databinding.ActivityPenyakitBinding
import java.util.*
import kotlin.collections.ArrayList

class PenyakitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPenyakitBinding
    val displayList = ArrayList<Penyakit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPenyakitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Penyakit"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.rvDataPenyakit.setHasFixedSize(true)
        displayList.addAll(arrayList())

        binding.rvDataPenyakit.layoutManager = GridLayoutManager(this, 2)
        val DataPenyakitAdapter = PenyakitAdapter(displayList, this)
        binding.rvDataPenyakit.adapter = DataPenyakitAdapter
    }

    fun arrayList(): ArrayList<Penyakit> {
        val nama_penyakit = resources.getStringArray(R.array.nama_penyakit)
        val deskripsi_penyakit = resources.getStringArray(R.array.deskripsi_penyakit)
        val gejala_penyakit = resources.getStringArray(R.array.gejala_penyakit)
        val pengendalian_penyakit = resources.getStringArray(R.array.pengendalian_penyakit)
        val image_penyakit = resources.obtainTypedArray(R.array.image_penyakit)
        val listPenyakit = ArrayList<Penyakit>()
        for (position in nama_penyakit.indices) {
            val dataPenyakit = Penyakit(
                nama_penyakit[position],
                deskripsi_penyakit[position],
                gejala_penyakit[position],
                pengendalian_penyakit[position],
                image_penyakit.getResourceId(position, 0)
            )
            listPenyakit.add(dataPenyakit)
        }
        image_penyakit.recycle()
        return  listPenyakit
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
                            if (it.nama_penyakit.toLowerCase(Locale.getDefault()).contains(search)) {
                                displayList.add(it)
                            }
                            binding.rvDataPenyakit.adapter!!.notifyDataSetChanged()
                        }
                    } else {
                        displayList.clear()
                        displayList.addAll(arrayList())
                        binding.rvDataPenyakit.adapter!!.notifyDataSetChanged()
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