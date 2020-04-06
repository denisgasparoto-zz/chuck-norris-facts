package com.denisgasparoto.chucknorrisfacts.facts

import com.agoda.kakao.KButton
import com.agoda.kakao.Screen
import com.denisgasparoto.chucknorrisfacts.R

/**
 * @author Denis Gasparoto on 06/04/2020.
 */
class FactsScreen : Screen<FactsScreen>() {
    val button: KButton = KButton { withId(R.id.activity_facts_mb_open_facts_by_query) }
}
