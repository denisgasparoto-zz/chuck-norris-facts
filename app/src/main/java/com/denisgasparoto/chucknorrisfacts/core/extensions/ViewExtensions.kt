package com.denisgasparoto.chucknorrisfacts.core.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.google.android.material.snackbar.Snackbar
import com.jakewharton.rxbinding2.view.RxView
import java.util.concurrent.TimeUnit

/**
 * @author Denis Gasparoto on 29/03/2020.
 */
private const val CLICK_DELAY = 1000L

@SuppressLint("CheckResult")
fun View.setSafeOnClickListener(onClick: (View) -> Unit) {
    RxView
        .clicks(this)
        .throttleFirst(CLICK_DELAY, TimeUnit.MILLISECONDS)
        .subscribe { onClick(this) }
}

fun View.closeKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun View.isVisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.INVISIBLE
}

fun View.showSnackBar(message: String) = Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
