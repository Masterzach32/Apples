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
class BlankCard(id: Int, set: String, title: String, body: String, val numBlanks: Int) : Card(id, set, title, body) {

    override fun toString() = "BlankCard(id=$id, title=$title, body=$body, numBlanks=$numBlanks)"
}