package com.zidanfaiq.bertanipadi.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zidanfaiq.bertanipadi.R
import com.zidanfaiq.bertanipadi.budidaya.DetailBudidayaActivity
import com.zidanfaiq.bertanipadi.model.Budidaya
import com.zidanfaiq.bertanipadi.databinding.ItemBudidayaBinding

class BudidayaAdapter(val listDataBudidaya: ArrayList<Budidaya>, val context: Context) : RecyclerView.Adapter<BudidayaAdapter.BudidayaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudidayaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_budidaya, parent, false)
        return BudidayaViewHolder(view)
    }

    override fun getItemCount(): Int = listDataBudidaya.size

    override fun onBindViewHolder(holder: BudidayaViewHolder, position: Int) {
        holder.bind(listDataBudidaya[position])
    }

    inner class BudidayaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemBudidayaBinding.bind(itemView)
        fun bind(budidaya: Budidaya) {
            binding.titleBudidaya.text = budidaya.nama
            binding.deskripsiBudidaya.text = budidaya.deskripsi
            Glide.with(context)
                .load(budidaya.image)
                .into(binding.gambarBudidaya)
            binding.cvBudidaya.setOnClickListener() {
                val i = Intent(context, DetailBudidayaActivity::class.java)
                i.putExtra(DetailBudidayaActivity.EXTRA_DATA_BUDIDAYA, budidaya)
                context.startActivity(i)
            }
        }
    }
}