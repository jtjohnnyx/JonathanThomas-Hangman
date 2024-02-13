package com.example.jonathanthomashangman2

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes

data class Button (@IdRes val buttonId: Int, @DrawableRes var imageId: Int, var enabled: Boolean)