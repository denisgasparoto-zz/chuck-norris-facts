package com.denisgasparoto.chucknorrisfacts.core.base

import android.view.View
import com.denisgasparoto.chucknorrisfacts.core.extensions.drawable
import kotlinx.android.synthetic.main.empty_list.view.empty_list_iv_image
import kotlinx.android.synthetic.main.empty_list.view.empty_list_tv_message
import kotlinx.android.synthetic.main.empty_list.view.empty_list_tv_title

/**
 * @author Denis Gasparoto on 04/04/2020.
 */
class EmptyListViewHolder<T>(
    itemView: View,
    emptyListPlaceholder: BaseAdapter.EmptyListPlaceholder
) : BaseViewHolder<T>(itemView) {

    init {
        emptyListPlaceholder.let {
            with(itemView) {
                empty_list_iv_image.setImageDrawable(context.drawable { it.image })
                empty_list_tv_title.text = it.title
                empty_list_tv_message.text = it.message
            }
        }
    }

    override fun bind(item: T) {
        // unused
    }
}
