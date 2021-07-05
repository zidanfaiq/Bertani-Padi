package com.zidanfaiq.bertanipadi.konsultasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zidanfaiq.bertanipadi.R

class KonsultasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konsultasi)
        supportActionBar?.title = "Konsultasi"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val mFragmentManager = supportFragmentManager
        val mGejala1Fragment = Gejala1Fragment()
        val fragment = mFragmentManager.findFragmentByTag(Gejala1Fragment::class.java.simpleName)
        if (fragment !is Gejala1Fragment) {
            mFragmentManager.beginTransaction()
                .add(R.id.frame_container, mGejala1Fragment, Gejala1Fragment::class.java.simpleName)
                .commit()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}