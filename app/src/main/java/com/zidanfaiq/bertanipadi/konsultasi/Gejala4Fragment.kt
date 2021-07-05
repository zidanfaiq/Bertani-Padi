package com.zidanfaiq.bertanipadi.konsultasi

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import com.zidanfaiq.bertanipadi.R
import com.zidanfaiq.bertanipadi.databinding.FragmentGejala4Binding
import kotlinx.android.synthetic.main.alert_diagnosa.*


class Gejala4Fragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gejala4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentGejala4Binding.bind(view)

        binding.yes.setOnClickListener(this)
        binding.no.setOnClickListener(this)
    }

    private fun alertDiagnosa() {
        val dialog = Dialog(activity!!)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.alert_diagnosa)
        dialog.nama_hama.text = resources.getString(R.string.wereng)

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
                val mGejala5Fragment = Gejala5Fragment()
                val mFragmentManager = fragmentManager as FragmentManager
                mFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, mGejala5Fragment, Gejala5Fragment::class.java.simpleName)
                    .commit()
            }
        }
    }
}