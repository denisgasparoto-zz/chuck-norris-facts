package com.denisgasparoto.chucknorrisfacts.core.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Denis Gasparoto on 02/04/2020.
 */
abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(item: T)
}
