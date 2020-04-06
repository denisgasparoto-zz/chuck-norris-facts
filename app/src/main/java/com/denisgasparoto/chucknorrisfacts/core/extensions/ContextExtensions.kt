package com.denisgasparoto.chucknorrisfacts.core.extensions

import android.content.Context
import android.widget.Toast
import androidx.core.content.ContextCompat

/**
 * @author Denis Gasparoto on 28/03/2020.
 */

fun Context.showToast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

inline fun Context.drawable(drawableRes: () -> Int) = ContextCompat.getDrawable(this, drawableRes())
