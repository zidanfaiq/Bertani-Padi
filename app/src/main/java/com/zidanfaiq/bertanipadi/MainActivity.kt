package com.zidanfaiq.bertanipadi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.zidanfaiq.bertanipadi.budidaya.BudidayaActivity
import com.zidanfaiq.bertanipadi.databinding.ActivityMainBinding
import com.zidanfaiq.bertanipadi.hama.HamaActivity
import com.zidanfaiq.bertanipadi.konsultasi.KonsultasiActivity
import com.zidanfaiq.bertanipadi.penyakit.PenyakitActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.budidaya.setOnClickListener(this)
        binding.penyakit.setOnClickListener(this)
        binding.hama.setOnClickListener(this)
        binding.konsultasi.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.budidaya -> {
                val intent = Intent(this@MainActivity, BudidayaActivity::class.java)
                startActivity(intent)
            }
            R.id.penyakit -> {
                val intent = Intent(this@MainActivity, PenyakitActivity::class.java)
                startActivity(intent)
            }
            R.id.hama -> {
                val intent = Intent(this@MainActivity, HamaActivity::class.java)
                startActivity(intent)
            }
            R.id.konsultasi -> {
                val intent = Intent(this@MainActivity, KonsultasiActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onBackPressed() {
        val alertExit : AlertDialog = AlertDialog.Builder(this).create()
        alertExit.setMessage("Apakah anda yakin akan keluar dari aplikasi?")

        alertExit.setButton(AlertDialog.BUTTON_POSITIVE, "Ya") {
            dialog, which -> finish()
            dialog.dismiss()
        }

        alertExit.setButton(AlertDialog.BUTTON_NEGATIVE, "Tidak") {
            dialog, which ->
            dialog.dismiss()
        }
        alertExit.show()
    }
}