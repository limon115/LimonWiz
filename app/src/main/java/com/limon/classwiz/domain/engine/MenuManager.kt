// Author: Khalid Hasan Limon
package com.limon.classwiz.domain.engine

import com.limon.classwiz.domain.model.MenuNode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MenuManager(private val rootMenu: MenuNode.Folder) {
    private val navigationStack = mutableListOf<MenuNode.Folder>()

    private val _currentFolder = MutableStateFlow(rootMenu)
    val currentFolder: StateFlow<MenuNode.Folder> = _currentFolder.asStateFlow()

    init {
        navigationStack.add(rootMenu)
    }

    fun navigateInto(folder: MenuNode.Folder) {
        navigationStack.add(folder)
        _currentFolder.value = folder
    }

    fun navigateBack(): Boolean {
        if (navigationStack.size > 1) {
            navigationStack.removeAt(navigationStack.size - 1)
            _currentFolder.value = navigationStack.last()
            return true
        }
        return false
    }

    fun resetToRoot() {
        navigationStack.clear()
        navigationStack.add(rootMenu)
        _currentFolder.value = rootMenu
    }
}
