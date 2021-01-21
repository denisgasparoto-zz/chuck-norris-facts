package com.denisgasparoto.chucknorrisfacts.core.extensions

import android.content.Context
import androidx.core.content.ContextCompat

/**
 * @author Denis Gasparoto on 28/03/2020.
 */

inline fun Context.drawable(drawableRes: () -> Int) = ContextCompat.getDrawable(this, drawableRes())
