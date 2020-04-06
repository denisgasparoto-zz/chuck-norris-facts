package com.denisgasparoto.chucknorrisfacts.core.extensions

/**
 * @author Denis Gasparoto on 03/04/2020.
 */
private const val STRING_SEPARATOR = " | "

fun List<String>.toConcatenate() = this.joinToString(STRING_SEPARATOR) { it }
