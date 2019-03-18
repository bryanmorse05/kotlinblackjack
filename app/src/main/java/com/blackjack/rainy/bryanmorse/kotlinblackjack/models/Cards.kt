package com.blackjack.rainy.bryanmorse.kotlinblackjack.models

import com.blackjack.rainy.bryanmorse.kotlinblackjack.R

data class Cards(var suite: String, var name: String, var value: Int, var image: Int, var isAce: Boolean) {
    
    object Deck {
        
        val cards = listOf<Cards>(
            Cards(
                "Hearts",
                "Ace",
                11,
                R.drawable.heartsace, true
            ),
            Cards(
                "Hearts",
                "Two",
                2,
                R.drawable.hearts2, false
            ),
            Cards(
                "Hearts",
                "Three",
                3,
                R.drawable.hearts3, false
            ),
            Cards(
                "Hearts",
                "Four",
                4,
                R.drawable.hearts4, false
            ),
            Cards(
                "Hearts",
                "Five",
                5,
                R.drawable.hearts5, false
            ),
            Cards(
                "Hearts",
                "Six",
                6,
                R.drawable.hearts6, false
            ),
            Cards(
                "Hearts",
                "Seven",
                7,
                R.drawable.hearts7, false
            ),
            Cards(
                "Hearts",
                "Eight",
                8,
                R.drawable.hearts8, false
            ),
            Cards(
                "Hearts",
                "Nine",
                9,
                R.drawable.hearts9, false
            ),
            Cards(
                "Hearts",
                "Ten",
                10,
                R.drawable.hearts10, false
            ),
            Cards(
                "Hearts",
                "Jack",
                10,
                R.drawable.jack_of_hearts, false
            ),
            Cards(
                "Hearts",
                "Queen",
                10,
                R.drawable.queen_of_hearts, false
            ),
            Cards(
                "Hearts",
                "King",
                10,
                R.drawable.king_of_hearts, false
            ),
            Cards(
                "Clubs",
                "Ace",
                11,
                R.drawable.clubsace, true
            ),
            Cards(
                "Clubs",
                "Two",
                2,
                R.drawable.clubs2, false
            ),
            Cards(
                "Clubs",
                "Three",
                3,
                R.drawable.clubs3, false
            ),
            Cards(
                "Clubs",
                "Four",
                4,
                R.drawable.clubs4, false
            ),
            Cards(
                "Clubs",
                "Five",
                5,
                R.drawable.clubs5, false
            ),
            Cards(
                "Clubs",
                "Six",
                6,
                R.drawable.clubs6, false
            ),
            Cards(
                "Clubs",
                "Seven",
                7,
                R.drawable.clubs7, false
            ),
            Cards(
                "Clubs",
                "Eight",
                8,
                R.drawable.clubs8, false
            ),
            Cards(
                "Clubs",
                "Nine",
                9,
                R.drawable.clubs9, false
            ),
            Cards(
                "Clubs",
                "Ten",
                10,
                R.drawable.clubs10, false
            ),
            Cards(
                "Clubs",
                "Jack",
                10,
                R.drawable.jack_of_clubs, false
            ),
            Cards(
                "Clubs",
                "Queen",
                10,
                R.drawable.queen_of_clubs, false
            ),
            Cards(
                "Clubs",
                "King",
                10,
                R.drawable.king_of_clubs, false
            ),
            Cards(
                "Diamonds",
                "Ace",
                11,
                R.drawable.diamondsace, true
            ),
            Cards(
                "Diamonds",
                "Two",
                2,
                R.drawable.diamonds2, false
            ),
            Cards(
                "Diamonds",
                "Three",
                3,
                R.drawable.diamonds3, false
            ),
            Cards(
                "Diamonds",
                "Four",
                4,
                R.drawable.diamonds4, false
            ),
            Cards(
                "Diamonds",
                "Five",
                5,
                R.drawable.diamonds5, false
            ),
            Cards(
                "Diamonds",
                "Six",
                6,
                R.drawable.diamonds6, false
            ),
            Cards(
                "Diamonds",
                "Seven",
                7,
                R.drawable.diamonds7, false
            ),
            Cards(
                "Diamonds",
                "Eight",
                8,
                R.drawable.diamonds8, false
            ),
            Cards(
                "Diamonds",
                "Nine",
                9,
                R.drawable.diamonds9, false
            ),
            Cards(
                "Diamonds",
                "Ten",
                10,
                R.drawable.diamonds10, false
            ),
            Cards(
                "Diamonds",
                "Jack",
                10,
                R.drawable.jack_of_diamonds, false
            ),
            Cards(
                "Diamonds",
                "Queen",
                10,
                R.drawable.queen_of_diamonds, false
            ),
            Cards(
                "Diamonds",
                "King",
                10,
                R.drawable.king_of_diamonds, false
            ),
            Cards(
                "Spades",
                "Ace",
                11,
                R.drawable.spadesace, true
            ),
            Cards(
                "Spades",
                "Two",
                2,
                R.drawable.spades2, false
            ),
            Cards(
                "Spades",
                "Three",
                3,
                R.drawable.spades3, false
            ),
            Cards(
                "Spades",
                "Four",
                4,
                R.drawable.spades4, false
            ),
            Cards(
                "Spades",
                "Five",
                5,
                R.drawable.spades5, false
            ),
            Cards(
                "Spades",
                "Six",
                6,
                R.drawable.spades6, false
            ),
            Cards(
                "Spades",
                "Seven",
                7,
                R.drawable.spades7, false
            ),
            Cards(
                "Spades",
                "Eight",
                8,
                R.drawable.spades8, false
            ),
            Cards(
                "Spades",
                "Nine",
                9,
                R.drawable.spades9, false
            ),
            Cards(
                "Spades",
                "Ten",
                10,
                R.drawable.spades10, false
            ),
            Cards(
                "Spades",
                "Jack",
                10,
                R.drawable.jack_of_spades, false
            ),
            Cards(
                "Spades",
                "Queen",
                10,
                R.drawable.queen_of_spades, false
            ),
            Cards(
                "Spades",
                "King",
                10,
                R.drawable.king_of_spades, false
            )
        
        )
    }
}