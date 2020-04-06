package com.denisgasparoto.chucknorrisfacts.presentation.factsbyquery

import android.util.TypedValue
import android.view.View
import com.denisgasparoto.chucknorrisfacts.R
import com.denisgasparoto.chucknorrisfacts.core.base.BaseAdapter
import com.denisgasparoto.chucknorrisfacts.core.base.BaseViewHolder
import com.denisgasparoto.chucknorrisfacts.core.extensions.setSafeOnClickListener
import com.denisgasparoto.chucknorrisfacts.core.extensions.toConcatenate
import com.denisgasparoto.chucknorrisfacts.domain.model.display.FactsQueryResultDisplay
import kotlinx.android.synthetic.main.facts_by_query_adapter_item.view.facts_by_query_adapter_item_iv_share
import kotlinx.android.synthetic.main.facts_by_query_adapter_item.view.facts_by_query_adapter_item_tv_categories
import kotlinx.android.synthetic.main.facts_by_query_adapter_item.view.facts_by_query_adapter_item_tv_content

/**
 * @author Denis Gasparoto on 28/03/2020.
 */
class FactsByQueryAdapter : BaseAdapter<FactsQueryResultDisplay>() {

    internal var shareUrlCallback: ((String) -> Unit)? = null
    
    override fun getLayoutResId(viewType: Int) = R.layout.facts_by_query_adapter_item

    override fun getViewHolder(itemView: View, viewType: Int) =
        FactsByQueryViewHolder(itemView, shareUrlCallback)

    inner class FactsByQueryViewHolder(
        itemView: View,
        private val shareUrlCallback: ((String) -> Unit)?
    ) : BaseViewHolder<FactsQueryResultDisplay>(itemView) {

        override fun bind(item: FactsQueryResultDisplay) {
            with(itemView) {
                facts_by_query_adapter_item_tv_content.apply {
                    text = item.fact
                    setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(item.factLength))
                }
                facts_by_query_adapter_item_tv_categories.text = item.categories?.toConcatenate()
                facts_by_query_adapter_item_iv_share.setSafeOnClickListener {
                    shareUrlCallback?.invoke(
                        item.url
                    )
                }
            }
        }
    }
}
