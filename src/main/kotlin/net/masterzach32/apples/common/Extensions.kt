package net.masterzach32.apples.common

import java.util.*

/*  ===== CARDS ===== */

typealias Deck = Stack<Card>

fun Iterable<Card>.toDeck(): Deck = Stack<Card>().also { this.forEach { e -> it.push(e) } }

fun Deck.draw(count: Int): Set<Card> = mutableSetOf<Card>().also { (0 until count).forEach { _ -> it.add(this.pop()) } }

fun Deck.draw(): Card = draw(1).first()

fun Deck.shuffled(): Deck = apply { shuffle() }


