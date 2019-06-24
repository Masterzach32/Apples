package net.masterzach32.apples.common

import java.util.*

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
data class CardSet(
    val name: String,
    val author: String,
    val playerCards: Set<PlayerCard>,
    val blankCards: Set<BlankCard>
) {

    fun getPlayerCardsDeck() = playerCards.toDeck()

    fun getBlankCardsDeck() = blankCards.toDeck()

}