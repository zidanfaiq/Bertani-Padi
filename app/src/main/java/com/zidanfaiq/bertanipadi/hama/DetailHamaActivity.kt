package com.zidanfaiq.bertanipadi.hama

import android.app.Activity
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.zidanfaiq.bertanipadi.model.Hama
import com.zidanfaiq.bertanipadi.databinding.ActivityDetailHamaBinding
import kotlinx.android.synthetic.main.content_scrolling_hama.*

class DetailHamaActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA_HAMA = "extra_data_hama"
    }

    inline fun <reified T : Parcelable> Activity.getParcelabeExtra(key: String) = lazy {
        intent.getParcelableExtra<T>(key)
    }

    private lateinit var binding: ActivityDetailHamaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHamaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val DataHama by getParcelabeExtra<Hama>(EXTRA_DATA_HAMA)
        supportActionBar?.title = DataHama?.nama_hama.toString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        hama_deskripsi.text = DataHama?.deskripsi_hama.toString()
        hama_gejala.text = DataHama?.gejala_hama.toString()
        hama_pengendalian.text = DataHama?.pengendalian_hama.toString()
        Glide.with(this)
            .load(DataHama?.image_hama)
            .into(binding.hamaImg)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}