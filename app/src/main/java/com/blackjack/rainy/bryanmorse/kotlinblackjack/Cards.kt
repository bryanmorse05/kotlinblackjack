package com.blackjack.rainy.bryanmorse.kotlinblackjack

data class Cards(var suite: String, var name: String, var value: Int, var image: Int) {
    
    object Deck {
        
        val cards = listOf<Cards>(
            Cards("Hearts", "Ace", 1, R.drawable.heartsace),
            Cards("Hearts", "Two", 2, R.drawable.hearts2),
            Cards("Hearts", "Three", 3, R.drawable.hearts3),
            Cards("Hearts", "Four", 4, R.drawable.hearts4),
            Cards("Hearts", "Five", 5, R.drawable.hearts5),
            Cards("Hearts", "Six", 6, R.drawable.hearts6),
            Cards("Hearts", "Seven", 7, R.drawable.hearts7),
            Cards("Hearts", "Eight", 8, R.drawable.hearts8),
            Cards("Hearts", "Nine", 9, R.drawable.hearts9),
            Cards("Hearts", "Ten", 10, R.drawable.hearts10),
            Cards("Hearts", "Jack", 10, R.drawable.jack_of_hearts),
            Cards("Hearts", "Queen", 10, R.drawable.queen_of_hearts),
            Cards("Hearts", "King", 10, R.drawable.king_of_hearts),
            Cards("Clubs", "Ace", 1, R.drawable.clubsace),
            Cards("Clubs", "Two", 2, R.drawable.clubs2),
            Cards("Clubs", "Three", 3, R.drawable.clubs3),
            Cards("Clubs", "Four", 4, R.drawable.clubs4),
            Cards("Clubs", "Five", 5, R.drawable.clubs5),
            Cards("Clubs", "Six", 6, R.drawable.clubs6),
            Cards("Clubs", "Seven", 7, R.drawable.clubs7),
            Cards("Clubs", "Eight", 8, R.drawable.clubs8),
            Cards("Clubs", "Nine", 9, R.drawable.clubs9),
            Cards("Clubs", "Ten", 10, R.drawable.clubs10),
            Cards("Clubs", "Jack", 10, R.drawable.jack_of_clubs),
            Cards("Clubs", "Queen", 10, R.drawable.queen_of_clubs),
            Cards("Clubs", "King", 10, R.drawable.king_of_clubs),
            Cards("Diamonds", "Ace", 1, R.drawable.diamondsace),
            Cards("Diamonds", "Two", 2, R.drawable.diamonds2),
            Cards("Diamonds", "Three", 3, R.drawable.diamonds3),
            Cards("Diamonds", "Four", 4, R.drawable.diamonds4),
            Cards("Diamonds", "Five", 5, R.drawable.diamonds5),
            Cards("Diamonds", "Six", 6, R.drawable.diamonds6),
            Cards("Diamonds", "Seven", 7, R.drawable.diamonds7),
            Cards("Diamonds", "Eight", 8, R.drawable.diamonds8),
            Cards("Diamonds", "Nine", 9, R.drawable.diamonds9),
            Cards("Diamonds", "Ten", 10, R.drawable.diamonds10),
            Cards("Diamonds", "Jack", 10, R.drawable.jack_of_diamonds),
            Cards("Diamonds", "Queen", 10, R.drawable.queen_of_diamonds),
            Cards("Diamonds", "King", 10, R.drawable.king_of_diamonds),
            Cards("Spades", "Ace", 1, R.drawable.spadesace),
            Cards("Spades", "Two", 2, R.drawable.spades2),
            Cards("Spades", "Three", 3, R.drawable.spades3),
            Cards("Spades", "Four", 4, R.drawable.spades4),
            Cards("Spades", "Five", 5, R.drawable.spades5),
            Cards("Spades", "Six", 6, R.drawable.spades6),
            Cards("Spades", "Seven", 7, R.drawable.spades7),
            Cards("Spades", "Eight", 8, R.drawable.spades8),
            Cards("Spades", "Nine", 9, R.drawable.spades9),
            Cards("Spades", "Ten", 10, R.drawable.spades10),
            Cards("Spades", "Jack", 10, R.drawable.jack_of_spades),
            Cards("Spades", "Queen", 10, R.drawable.queen_of_spades),
            Cards("Spades", "King", 10, R.drawable.king_of_spades)
        
        )
    }
}