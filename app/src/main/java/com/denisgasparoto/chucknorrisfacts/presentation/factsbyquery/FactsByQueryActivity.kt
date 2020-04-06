package com.denisgasparoto.chucknorrisfacts.presentation.factsbyquery

import android.view.MenuItem
import android.view.MotionEvent
import android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.denisgasparoto.chucknorrisfacts.R
import com.denisgasparoto.chucknorrisfacts.core.base.BaseActivity
import com.denisgasparoto.chucknorrisfacts.core.base.BaseAdapter
import com.denisgasparoto.chucknorrisfacts.core.extensions.closeKeyboard
import com.denisgasparoto.chucknorrisfacts.core.extensions.isVisible
import com.denisgasparoto.chucknorrisfacts.core.extensions.showSnackBar
import kotlinx.android.synthetic.main.activity_facts_by_query.activity_facts_by_query_et_search
import kotlinx.android.synthetic.main.activity_facts_by_query.activity_facts_by_query_ll_container
import kotlinx.android.synthetic.main.activity_facts_by_query.activity_facts_by_query_pb_loading
import kotlinx.android.synthetic.main.activity_facts_by_query.activity_facts_by_query_rv_items
import kotlinx.android.synthetic.main.activity_facts_by_query.activity_facts_by_query_toolbar
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

/**
 * @author Denis Gasparoto on 31/03/2020.
 */
class FactsByQueryActivity : BaseActivity() {

    override var layoutResId = R.layout.activity_facts_by_query

    private val viewModel: FactsByQueryContract.ViewModel by viewModel<FactsByQueryViewModel> {
        parametersOf(this)
    }
    private val factsByQueryAdapter: FactsByQueryAdapter by inject()

    override fun initialize() {
        setSupportActionBar(activity_facts_by_query_toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        activity_facts_by_query_rv_items.apply {
            layoutManager = LinearLayoutManager(
                this@FactsByQueryActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = factsByQueryAdapter.apply {
                shareUrlCallback = { viewModel.shareFact(it) }
                emptyListPlaceholder = BaseAdapter.EmptyListPlaceholder(
                    image = R.drawable.ic_app_logo,
                    title = getString(R.string.activity_facts_by_query_empty_list_title),
                    message = getString(R.string.activity_facts_by_query_empty_list_message)
                )
            }
        }

        activity_facts_by_query_et_search.let {
            it.requestFocus()
            it.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == IME_ACTION_SEARCH) {
                    viewModel.fetchFactsByQuery(it.text.toString())
                    return@setOnEditorActionListener true
                }
                return@setOnEditorActionListener false
            }
        }

        bindFactsByQueryViewModelOutputs()
    }

    override fun onBackPressed() {
        factsByQueryAdapter.clearList()
        super.onBackPressed()
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(menuItem)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        activity_facts_by_query_ll_container.closeKeyboard()
        currentFocus?.clearFocus()
        return super.dispatchTouchEvent(ev)
    }

    private fun bindFactsByQueryViewModelOutputs() {
        viewModel.apply {
            fillFactsByQuery().observe(
                this@FactsByQueryActivity,
                Observer(factsByQueryAdapter::setList)
            )

            isLoading().observe(
                this@FactsByQueryActivity,
                Observer { activity_facts_by_query_pb_loading.isVisible(it) })

            showError().observe(
                this@FactsByQueryActivity,
                Observer { activity_facts_by_query_ll_container.showSnackBar(it) })

            showInvalidSearchError().observe(this@FactsByQueryActivity, Observer {
                activity_facts_by_query_ll_container.showSnackBar(
                    getString(R.string.invalid_search_message_error)
                )
            })
        }
    }
}
