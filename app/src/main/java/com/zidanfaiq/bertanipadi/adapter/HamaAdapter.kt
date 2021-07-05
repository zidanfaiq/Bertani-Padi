package com.zidanfaiq.bertanipadi.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zidanfaiq.bertanipadi.R
import com.zidanfaiq.bertanipadi.data.Hama
import com.zidanfaiq.bertanipadi.databinding.ItemHamaBinding
import com.zidanfaiq.bertanipadi.hama.DetailHamaActivity

class HamaAdapter(val listDataHama: ArrayList<Hama>, val context: Context) : RecyclerView.Adapter<HamaAdapter.HamaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HamaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hama, parent, false)
        return HamaViewHolder(view)
    }

    override fun getItemCount(): Int = listDataHama.size

    override fun onBindViewHolder(holder: HamaViewHolder, position: Int) {
        holder.bind(listDataHama[position])
    }

    inner class HamaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemHamaBinding.bind(itemView)
        fun bind(hama: Hama) {
            binding.titleHama.text = hama.nama_hama
            binding.deskripsiHama.text = hama.deskripsi_hama
            binding.gejalaHama.text = hama.gejala_hama
            binding.pengendalianHama.text = hama.pengendalian_hama
            Glide.with(context)
                .load(hama.image_hama)
                .into(binding.gambarHama)
            binding.cvHama.setOnClickListener() {
                val i = Intent(context, DetailHamaActivity::class.java)
                i.putExtra(DetailHamaActivity.EXTRA_DATA_HAMA, hama)
                context.startActivity(i)
            }
        }
    }
}
