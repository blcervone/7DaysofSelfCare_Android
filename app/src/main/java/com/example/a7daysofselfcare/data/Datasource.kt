package com.example.a7daysofselfcare.data

import com.example.a7daysofselfcare.R
import com.example.a7daysofselfcare.model.Tip

class Datasource {
    val taskList = listOf<Tip>(
        Tip(R.string.day1, R.string.tip1, R.string.description1, R.drawable.image1),
        Tip(R.string.day2, R.string.tip2, R.string.description2, R.drawable.image2),
        Tip(R.string.day3, R.string.tip3, R.string.description3, R.drawable.image3),
        Tip(R.string.day4, R.string.tip4, R.string.description4, R.drawable.image4),
        Tip(R.string.day5, R.string.tip5, R.string.description5, R.drawable.image5),
        Tip(R.string.day6, R.string.tip6, R.string.description6, R.drawable.image6),
        Tip(R.string.day7, R.string.tip7, R.string.description7, R.drawable.image7),
    )
}