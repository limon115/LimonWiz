// Author: Khalid Hasan Limon
package com.limon.classwiz.domain.model

sealed class MenuNode(val title: String) {
    class Folder(title: String, val children: List<MenuNode>) : MenuNode(title)
    class Action(title: String, val actionId: String) : MenuNode(title)
    class Toggle(title: String, val isEnabled: Boolean, val toggleId: String) : MenuNode(title)
}
