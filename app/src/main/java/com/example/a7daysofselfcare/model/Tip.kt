package com.example.a7daysofselfcare.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
    @StringRes val day: Int,
    @StringRes val tip: Int,
    @StringRes val desc: Int,
    @DrawableRes val img: Int
)
