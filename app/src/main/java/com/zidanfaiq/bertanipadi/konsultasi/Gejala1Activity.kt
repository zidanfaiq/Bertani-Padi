package com.zidanfaiq.bertanipadi.konsultasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.zidanfaiq.bertanipadi.R
import com.zidanfaiq.bertanipadi.databinding.ActivityDetailHamaBinding
import kotlinx.android.synthetic.main.content_scrolling_hama.*

class Gejala1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailHamaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHamaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Tikus"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        hama_deskripsi.text = resources.getString(R.string.deskripsi_tikus)
        hama_gejala.text = resources.getString(R.string.gejala_tikus)
        hama_pengendalian.text = resources.getString(R.string.pengendalian_tikus)
        Glide.with(this)
            .load(R.drawable.tikus)
            .into(binding.hamaImg)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}