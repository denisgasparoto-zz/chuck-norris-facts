package com.denisgasparoto.chucknorrisfacts.presentation.facts

import com.denisgasparoto.chucknorrisfacts.R
import com.denisgasparoto.chucknorrisfacts.core.base.BaseActivity
import com.denisgasparoto.chucknorrisfacts.core.base.viewBinding
import com.denisgasparoto.chucknorrisfacts.core.extensions.setSafeOnClickListener
import com.denisgasparoto.chucknorrisfacts.databinding.ActivityFactsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

/**
 * @author Denis Gasparoto on 26/03/2020.
 */
class FactsActivity : BaseActivity() {

    override var layoutResId = R.layout.activity_facts

    private val viewModel: FactsContract.ViewModel by viewModel<FactsViewModel> {
        parametersOf(this)
    }
    private val binding by viewBinding(ActivityFactsBinding::inflate)

    override fun initialize() = binding.activityFactsMbOpenFactsByQuery.setSafeOnClickListener {
        viewModel.callRouteToFactsByQueryActivity()
    }
}
