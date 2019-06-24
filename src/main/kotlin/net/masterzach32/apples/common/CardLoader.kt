package net.masterzach32.apples.common

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection

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
        val db = Database.connect("jdbc:sqlite:cardsets.db", "org.sqlite.JDBC")

        transaction(Connection.TRANSACTION_SERIALIZABLE, 1, db) {
            cardSets.putAll(
                SetTable.innerJoin(CardTable)
                    .selectAll()
                    .groupBy { it[CardTable.cardSet] }
                    .mapValues { (name, cards) ->
                        CardSet(
                            name,
                            cards.first()[SetTable.author],
                            cards.first()[SetTable.description],
                            cards
                                .filter { it[CardTable.numBlanks] == null }
                                .map { PlayerCard(it[CardTable.id], name, it[CardTable.title], it[CardTable.body]) }
                                .toSet(),
                            cards
                                .filter { it[CardTable.numBlanks] != null }
                                .map { BlankCard(it[CardTable.id], name, it[CardTable.title], it[CardTable.body], it[CardTable.numBlanks]!!) }
                                .toSet()
                        )
                    }
            )
        }
    }

    object SetTable : Table("ap_sets") {
        val name = text("name").primaryKey()
        val author = text("author")
        val description = text("description")
    }

    object CardTable : Table("ap_cards") {
        val id = integer("id").autoIncrement().primaryKey()
        val cardSet = text("cardset") references SetTable.name
        val title = text("title")
        val body = text("body").nullable()
        val numBlanks = integer("num_blanks").nullable()
    }
}

fun main() {
    /*val db = Database.connect("jdbc:sqlite:cardsets.db", "org.sqlite.JDBC")
    val p = JSONParser()
    val raf = RandomAccessFile("playerCards", "r")
    val buffer = ByteArray(raf.length().toInt())
    raf.readFully(buffer)
    raf.close()
    val obj = p.parse(String(buffer)) as JSONObject
    val size = (obj["size"] as Long).toInt()
    val cards = mutableSetOf<BlankCard>()
    for (i in 0 until size) {
        val cardObj = obj["$i"] as JSONObject
        cards.add(BlankCard(i, "Apples to Apples", cardObj["text"] as String, null, (cardObj["numOfBlanks"] as Long).toInt()))
    }
    println(cards)
    transaction(Connection.TRANSACTION_SERIALIZABLE, 1, db) {
        CardLoader.CardTable.batchInsert(cards) {
            this[CardLoader.CardTable.cardSet] = it.set
            this[CardLoader.CardTable.title] = it.title.substring(0 until it.title.indexOf(" -"))
            this[CardLoader.CardTable.body] = it.title.substring(it.title.indexOf(" -") + 3 until it.title.length)
        }
    }*/
}
