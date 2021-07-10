package com.zidanfaiq.bertanipadi.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zidanfaiq.bertanipadi.R
import com.zidanfaiq.bertanipadi.model.Penyakit
import com.zidanfaiq.bertanipadi.databinding.ItemPenyakitBinding
import com.zidanfaiq.bertanipadi.penyakit.DetailPenyakitActivity

class PenyakitAdapter(val listDataPenyakit: ArrayList<Penyakit>, val context: Context) : RecyclerView.Adapter<PenyakitAdapter.PenyakitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PenyakitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_penyakit, parent, false)
        return PenyakitViewHolder(view)
    }

    override fun getItemCount(): Int = listDataPenyakit.size

    override fun onBindViewHolder(holder: PenyakitViewHolder, position: Int) {
        holder.bind(listDataPenyakit[position])
    }

    inner class PenyakitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPenyakitBinding.bind(itemView)
        fun bind(penyakit: Penyakit) {
            binding.titlePenyakit.text = penyakit.nama_penyakit
            binding.deskripsiPenyakit.text = penyakit.deskripsi_penyakit
            binding.gejalaPenyakit.text = penyakit.gejala_penyakit
            binding.pengendalianPenyakit.text = penyakit.pengendalian_penyakit
            Glide.with(context)
                .load(penyakit.image_penyakit)
                .into(binding.gambarPenyakit)
            binding.cvPenyakit.setOnClickListener() {
                val i = Intent(context, DetailPenyakitActivity::class.java)
                i.putExtra(DetailPenyakitActivity.EXTRA_DATA_PENYAKIT, penyakit)
                context.startActivity(i)
            }
        }
    }
}