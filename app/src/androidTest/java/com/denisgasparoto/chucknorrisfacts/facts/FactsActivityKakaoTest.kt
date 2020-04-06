package com.denisgasparoto.chucknorrisfacts.facts

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.denisgasparoto.chucknorrisfacts.presentation.facts.FactsActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Denis Gasparoto on 06/04/2020.
 */
@RunWith(AndroidJUnit4::class)
class FactsActivityKakaoTest {

    @JvmField
    @Rule
    val testRule = ActivityTestRule(FactsActivity::class.java)

    private val factsScreen = FactsScreen()

    @Test
    fun initialViewsDisplayedProperly() {
        factsScreen {
            button.click()
        }
    }
}
