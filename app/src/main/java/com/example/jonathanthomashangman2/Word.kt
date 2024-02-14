package com.example.jonathanthomashangman2

import androidx.annotation.StringRes
data class Word(@StringRes val textResId: Int,  val ls: List<Char>, val mip: List<Int>, val length: Int, val hint: String)