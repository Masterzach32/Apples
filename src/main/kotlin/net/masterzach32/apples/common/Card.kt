package net.masterzach32.apples.common

/*
 * apples - Created on 6/21/2019
 * Author: Zach Kozar
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

/**
 * @author Zach Kozar
 * @version 6/21/2019
 */
open class Card(val id: Int, val set: String, val title: String, val body: String?) {

    override fun equals(other: Any?): Boolean {
        if (other != null && other is Card)
            return id == other.id
        return false
    }

    override fun toString() = "Card(id=$id, title=$title, body=$body)"

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + set.hashCode()
        return result
    }
}