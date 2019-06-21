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
open class Player(val name: String) {

    var score = 0
    var isCardCzar = false
    var lastCardPlayed: Card? = null

    val hand = mutableListOf<PlayerCard>()

    override fun toString() = "Player(name=$name)"
}