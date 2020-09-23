/*
 * TodoMVC
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.todomvc.contract.data

import java.util.*

data class Todo(
    val title: String,
    val completed: Boolean = false,
    val id: String = UUID.randomUUID().toString()
)
