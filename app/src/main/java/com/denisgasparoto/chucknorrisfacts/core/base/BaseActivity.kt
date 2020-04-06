package com.denisgasparoto.chucknorrisfacts.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


/**
 * @author Denis Gasparoto on 26/03/2020.
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract var layoutResId: Int

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        initialize()
    }

    abstract fun initialize()
}
