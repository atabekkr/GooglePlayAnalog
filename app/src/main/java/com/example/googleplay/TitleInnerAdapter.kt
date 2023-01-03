package com.example.googleplay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.googleplay.databinding.ItemTitleBinding

class TitleInnerAdapter: RecyclerView.Adapter<TitleInnerAdapter.TitleViewHolder>() {

    inner class TitleViewHolder(private val binding: ItemTitleBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(title: Title) {
            binding.tvRecom.text = title.title

            /*  binding.innerRecyclerView.addItemDecoration(
                  DividerItemDecoration(binding.root.context, DividerItemDecoration.HORIZONTAL)
              )*/
        }
    }

    var models = listOf<Title>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = models.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_title, parent, false)
        val binding = ItemTitleBinding.bind(view)
        return TitleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TitleViewHolder, position: Int) {
        holder.bind(models[position])
    }
}