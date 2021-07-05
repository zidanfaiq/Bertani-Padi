package com.zidanfaiq.bertanipadi.konsultasi

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import com.zidanfaiq.bertanipadi.R
import com.zidanfaiq.bertanipadi.databinding.FragmentGejala1Binding
import kotlinx.android.synthetic.main.alert_diagnosa.*

class Gejala1Fragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gejala1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentGejala1Binding.bind(view)

        binding.yes.setOnClickListener(this)
        binding.no.setOnClickListener(this)
    }

    private fun alertDiagnosa() {
        val dialog = Dialog(activity!!)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.alert_diagnosa)
        dialog.nama_hama.text = resources.getString(R.string.tikus)

        val close = dialog.findViewById<ImageView>(R.id.close)
        close.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.yes -> {
                alertDiagnosa()
            }
            R.id.no -> {
                val mGejala2Fragment = Gejala2Fragment()
                val mFragmentManager = fragmentManager as FragmentManager
                mFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, mGejala2Fragment, Gejala2Fragment::class.java.simpleName)
                    .commit()
            }
        }
    }
}