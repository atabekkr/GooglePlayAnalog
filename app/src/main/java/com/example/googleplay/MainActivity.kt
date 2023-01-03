package com.example.googleplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.googleplay.data.Constants
import com.example.googleplay.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val rvAdapter = RVAdapter()

    private val icons = Constants.getIcons()
    private val banners = Constants.getBanners()
    private val grade = Constants.getGrades()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = rvAdapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        setMockData()
    }

    private fun setMockData() {
        var i = 0
        var j = 0
        var k = 0
        val data = mutableListOf<Item>()

        val innerData = mutableListOf<Title>()
        innerData.add(Title(1, "Лучшее"))
        innerData.add(Title(1, "Детям"))
        innerData.add(Title(1, "Рекомендуем"))
        innerData.add(Title(1, "Платные"))

        data.add(RVTitle(2, innerData))

        repeat(5) { it ->

                val innerData1 = mutableListOf<Images>()
                i = 0
                repeat(10) {
                    if (i == 4) i = 0
                    innerData1.add(
                        Images(
                            it, icons[0].icons[i],
                            "Game $i",
                            "${4 + it / 10.0}",
                            com.example.googleplay.R.drawable.ic_baseline_star_24
                        )
                    )
                    i++
                }
                data.add(RVImage(it, innerData1))

                val innerData = mutableListOf<Banner>()
                j = 0
                repeat(10) {
                    if (j == 4) j = 0
                    innerData.add(
                        Banner(
                            it,
                            banners[0].banners[j],
                            banners[0].banners[j],
                            "Need for Speed",
                            "${(Random.nextInt(2, 5) * 10) / 10.0}",
                            R.drawable.ic_baseline_star_24,
                            "${Random.nextInt(100, 200)} МБ"
                        )
                    )
                    j++
                }
                data.add(RVBanner(it, innerData))

                val innerData3 = mutableListOf<Grade>()
                k = 0
                repeat(10) {
                    if (k == 3) k = 0
                    innerData3.add(Grade(1,
                        grade[0].grade[k]
                    ))
                    k++
                }
                data.add(RVGrade(k, innerData3))
            }
        rvAdapter.models = data
        }
    }
