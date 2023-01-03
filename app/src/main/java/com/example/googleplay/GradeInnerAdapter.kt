package com.example.googleplay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.googleplay.databinding.ItemBannerBinding
import com.example.googleplay.databinding.ItemGradeBinding

class GradeInnerAdapter: RecyclerView.Adapter<GradeInnerAdapter.GradeViewHolder>() {

    inner class GradeViewHolder(private val binding: ItemGradeBinding): ViewHolder(binding.root) {
        fun bind(grade: Grade) {
            binding.ivSub.setImageResource(grade.otsenki)
        }
    }

    var models = listOf<Grade>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grade, parent, false)
        val binding = ItemGradeBinding.bind(view)
        return GradeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GradeViewHolder, position: Int) {
        holder.bind(models[position])
    }
}
