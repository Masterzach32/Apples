package net.masterzach32.apples.common

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

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
object CardLoader {

    val cardSets = mutableMapOf<String, CardSet>()

    fun loadAllCardSets() {
        Database.connect("jdbc:sqlite:cardsets.db", "org.sqlite.JDBC")

        transaction {

        }
    }
}

fun main() {
    CardLoader.loadAllCardSets()
}