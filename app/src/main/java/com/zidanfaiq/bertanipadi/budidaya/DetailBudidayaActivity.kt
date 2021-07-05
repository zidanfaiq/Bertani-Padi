package com.zidanfaiq.bertanipadi.budidaya

import android.app.Activity
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.zidanfaiq.bertanipadi.data.Budidaya
import com.zidanfaiq.bertanipadi.databinding.ActivityDetailBudidayaBinding
import kotlinx.android.synthetic.main.content_scrolling_budidaya.*

class DetailBudidayaActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA_BUDIDAYA = "extra_data_budidaya"
    }

    inline fun <reified T : Parcelable> Activity.getParcelabeExtra(key: String) = lazy {
        intent.getParcelableExtra<T>(key)
    }

    private lateinit var binding: ActivityDetailBudidayaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBudidayaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val DataBudidaya by getParcelabeExtra<Budidaya>(EXTRA_DATA_BUDIDAYA)
        supportActionBar?.title = DataBudidaya?.nama.toString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        budidaya_deskripsi.text = DataBudidaya?.deskripsi.toString()
        Glide.with(this)
            .load(DataBudidaya?.image)
            .into(binding.budidayaImg)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}