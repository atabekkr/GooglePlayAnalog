package com.example.googleplay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.googleplay.databinding.ItemImageBinding

class ImageInnerAdapter: RecyclerView.Adapter<ImageInnerAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(private val binding: ItemImageBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(image: Images) {
            binding.cardIv.setImageResource(image.image)
            binding.tvName.text = image.name
            binding.san.text = image.san
            binding.star.setImageResource(R.drawable.ic_baseline_star_24)
        }
    }

    var models = listOf<Images>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = models.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        val binding = ItemImageBinding.bind(view)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(models[position])
    }
}