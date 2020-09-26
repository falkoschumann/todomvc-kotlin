/*
 * TodoMVC
 * Copyright (c) 2020 Falko Schumann <falko.schumann@muspellheim.de>
 */

package de.muspellheim.todomvc.frontend

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import de.muspellheim.todomvc.contract.data.Todo
import javafx.scene.control.Button
import javafx.scene.control.CheckBox
import javafx.scene.control.Label
import javafx.scene.control.ListCell
import javafx.scene.control.ListView
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafx.util.Callback

class TodoListCell : ListCell<Todo>() {

    private val container = HBox()
    private val completed = CheckBox()
    private val title = Label()
    private val destroy = Button()
    private val edit = TextField()

    init {
        title.maxWidth = Double.MAX_VALUE
        title.maxHeight = Double.MAX_VALUE
        HBox.setHgrow(title, Priority.ALWAYS)

        val icon = FontAwesomeIconView(FontAwesomeIcon.CLOSE)
        icon.glyphSize = 22
        destroy.graphic = icon

        container.children.setAll(completed, title, destroy)
    }

    override fun updateItem(item: Todo?, empty: Boolean) {
        super.updateItem(item, empty)

        if (empty || item == null) {
            text = null
            graphic = null
        } else {
            graphic = container
            completed.isSelected = item.completed
            title.text = item.title
            edit.text = item.title
        }
    }
}

class TodoListCellFactory : Callback<ListView<Todo>, ListCell<Todo>> {
    override fun call(param: ListView<Todo>): ListCell<Todo> = TodoListCell()
}
