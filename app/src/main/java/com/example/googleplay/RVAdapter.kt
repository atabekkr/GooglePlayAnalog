package com.example.googleplay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.googleplay.RVAdapter.Companion.RVBANNER
import com.example.googleplay.RVAdapter.Companion.RVIMAGES
import com.example.googleplay.RVAdapter.Companion.RVTITLE
import com.example.googleplay.databinding.*

class RVAdapter : RecyclerView.Adapter<ViewHolder>() {
    companion object {
        const val RVTITLE = 0
        const val RVIMAGES = 1
        const val RVBANNER = 2
        const val RVGRADE = 3
    }

    inner class RVTitleViewHolder(private val binding: ItemTitleRvBinding) :
        ViewHolder(binding.root) {
        fun bind(rvTitle: RVTitle) {
            val titleInnerAdapter = TitleInnerAdapter()
            binding.innerRecyclerView.adapter = titleInnerAdapter

            titleInnerAdapter.models = rvTitle.items
        }
    }

    inner class RVImageViewHolder(private val binding: ItemRvImageBinding) :
        ViewHolder(binding.root) {
        fun bind(rvImage: RVImage) {
            val imageInnerAdapter = ImageInnerAdapter()
            binding.innerImageRecyclerView.adapter = imageInnerAdapter

            imageInnerAdapter.models = rvImage.images
        }
    }

    inner class RVBannerViewHolder(private val binding: ItemRvBannerBinding) :
        ViewHolder(binding.root) {
        fun bind(rvBanner: RVBanner) {
            val bannerInnerAdapter = BannerInnerAdapter()
            binding.innerBannerRecyclerView.adapter = bannerInnerAdapter

            bannerInnerAdapter.models = rvBanner.banners
        }
    }

    inner class RVGradeViewHolder(private val binding: ItemRvGradeBinding) :
        ViewHolder(binding.root) {
            fun bind(rvGrade: RVGrade) {
                val gradeInnerAdapter = GradeInnerAdapter()
                binding.innerGradeRv.adapter = gradeInnerAdapter

                gradeInnerAdapter.models = rvGrade.grades
            }
        }

    var models = listOf<Item>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (models[position] is RVImage) RVIMAGES
        else if (models[position] is RVTitle) RVTITLE
        else if (models[position] is RVGrade) RVGRADE
        else RVBANNER
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            RVTITLE -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_title_rv, parent, false)
                val binding = ItemTitleRvBinding.bind(view)
                RVTitleViewHolder(binding)
            }
            RVIMAGES -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_rv_image, parent, false)
                val binding = ItemRvImageBinding.bind(view)
                RVImageViewHolder(binding)
            }
            RVGRADE -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_rv_grade, parent, false)
                val binding = ItemRvGradeBinding.bind(view)
                RVGradeViewHolder(binding)
            }
            else -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_rv_banner, parent, false)
                val binding = ItemRvBannerBinding.bind(view)
                RVBannerViewHolder(binding)
            }
        }
    }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            when (getItemViewType(position)) {
                RVTITLE -> {
                    (holder as RVTitleViewHolder).bind(models[position] as RVTitle)
                }
                RVIMAGES -> {
                    (holder as RVImageViewHolder).bind(models[position] as RVImage)
                }
                RVBANNER -> {
                    (holder as RVBannerViewHolder).bind(models[position] as RVBanner)
                }
                RVGRADE -> {
                    (holder as RVGradeViewHolder).bind(models[position] as RVGrade)
                }
            }
        }
    }