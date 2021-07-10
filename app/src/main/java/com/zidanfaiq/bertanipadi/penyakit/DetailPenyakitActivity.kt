package com.zidanfaiq.bertanipadi.penyakit

import android.app.Activity
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.zidanfaiq.bertanipadi.model.Penyakit
import com.zidanfaiq.bertanipadi.databinding.ActivityDetailPenyakitBinding
import kotlinx.android.synthetic.main.content_scrolling_penyakit.*

class DetailPenyakitActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA_PENYAKIT = "extra_data_penyakit"
    }

    inline fun <reified T : Parcelable> Activity.getParcelabeExtra(key: String) = lazy {
        intent.getParcelableExtra<T>(key)
    }

    private lateinit var binding: ActivityDetailPenyakitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPenyakitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val DataPenyakit by getParcelabeExtra<Penyakit>(EXTRA_DATA_PENYAKIT)
        supportActionBar?.title = DataPenyakit?.nama_penyakit.toString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        penyakit_deskripsi.text = DataPenyakit?.deskripsi_penyakit.toString()
        penyakit_gejala.text = DataPenyakit?.gejala_penyakit.toString()
        penyakit_pengendalian.text = DataPenyakit?.pengendalian_penyakit.toString()
        Glide.with(this)
            .load(DataPenyakit?.image_penyakit)
            .into(binding.penyakitImg)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}