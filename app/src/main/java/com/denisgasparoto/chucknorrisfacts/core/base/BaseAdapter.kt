package com.denisgasparoto.chucknorrisfacts.core.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import com.denisgasparoto.chucknorrisfacts.R
import com.denisgasparoto.chucknorrisfacts.core.extensions.emptyString


/**
 * @author Denis Gasparoto on 02/04/2020.
 */
abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    private var items = listOf<T>()
    internal var emptyListPlaceholder: EmptyListPlaceholder? = null

    @LayoutRes
    abstract fun getLayoutResId(viewType: Int): Int

    abstract fun getViewHolder(itemView: View, viewType: Int): BaseViewHolder<T>

    @NonNull
    protected fun inflate(@LayoutRes layoutResId: Int, @Nullable parent: ViewGroup): View =
        LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        if (viewType == VIEW_TYPE_EMPTY) {
            emptyListPlaceholder?.also {
                return EmptyListViewHolder(inflate(R.layout.empty_list, parent), it)
            }
        }
        return getViewHolder(inflate(getLayoutResId(viewType), parent), viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return if (items.isEmpty()) VIEW_TYPE_EMPTY else VIEW_TYPE_FILLED
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        if (holder is EmptyListViewHolder) return else holder.bind(items[position])
    }

    override fun getItemCount() =
        if (items.isEmpty() && this.emptyListPlaceholder != null) EMPTY_LIST else items.size

    open fun setList(items: List<T>) {
        this.items = items
        notifyDataSetChanged()
    }

    open fun clearList() {
        this.items = listOf()
        notifyDataSetChanged()
    }

    data class EmptyListPlaceholder(
        @DrawableRes var image: Int = 0,
        var title: String = String.emptyString(),
        var message: String = String.emptyString()
    )

    companion object {
        private const val VIEW_TYPE_EMPTY = 0
        private const val VIEW_TYPE_FILLED = 1
        private const val EMPTY_LIST = 1
    }
}
