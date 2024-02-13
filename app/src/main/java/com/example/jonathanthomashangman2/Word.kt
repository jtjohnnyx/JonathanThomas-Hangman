package com.example.jonathanthomashangman2

import androidx.annotation.StringRes
import java.util.LinkedList

data class Word(@StringRes val textResId: Int,  val ls: List<Char>, var hang: LinkedList<Int>, val length: Int)