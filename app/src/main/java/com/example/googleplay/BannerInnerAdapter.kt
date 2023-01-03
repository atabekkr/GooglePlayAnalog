package com.example.googleplay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.googleplay.databinding.ItemBannerBinding

class BannerInnerAdapter: RecyclerView.Adapter<BannerInnerAdapter.BannerViewHolder>() {

    inner class BannerViewHolder(private val binding: ItemBannerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(banner: Banner) {
            binding.apply {
                mainBanner.setImageResource(banner.image)
                icon.setImageResource(banner.icon)
                needForSpeed.text = "Need for Speed"
                san.text = "4.3"
                star.setImageResource(banner.star)
                memory.text = banner.memory
            }
        }
    }

    var models = listOf<Banner>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false)
        val binding = ItemBannerBinding.bind(view)
        return BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(models[position])
    }
}