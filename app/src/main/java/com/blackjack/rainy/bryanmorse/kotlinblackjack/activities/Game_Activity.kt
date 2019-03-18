package com.blackjack.rainy.bryanmorse.kotlinblackjack.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.blackjack.rainy.bryanmorse.kotlinblackjack.models.Cards
import com.blackjack.rainy.bryanmorse.kotlinblackjack.R
import com.blackjack.rainy.bryanmorse.kotlinblackjack.utilities.showBagels
import kotlinx.android.synthetic.main.activity_main.*

class Game_Activity : AppCompatActivity() {

    var deckOfCards: List<Cards> =
        Cards.Deck.cards
    var dealerCurrentHandValue: Int = 0     //The Dealer's current hand value
    var playerCurrentHandValue: Int = 0     //The Player's current hand value
    var carPos: Int = 0                     //Current position in the array
    var cardToDealToPlayer: Int = 0
    var cardtoDealtoDealer: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Setting up the game board
        resetGame()

    }

    private fun resetGame() {

        //Clearing dealer cards and displaying just the backs
        dealerFirstCard.setImageResource(R.drawable.gray_back)
        dealerSecondCard.setImageResource(R.drawable.gray_back)
        dealerThirdCard.setImageResource(0)
        dealerFourthCard.setImageResource(0)
        dealerFifthCard.setImageResource(0)
        dealerSixthCard.setImageResource(0)

        //Clearing players cards and displaying just the backs
        playerFirstCard.setImageResource(R.drawable.gray_back)
        playerSecondCard.setImageResource(R.drawable.gray_back)
        playerThirdCard.setImageResource(0)
        playerFourthCard.setImageResource(0)
        playerFifthCard.setImageResource(0)
        playerSixthCard.setImageResource(0)

        //Clearing the text of the buttons so only the first button is active
        hitButton.text = getString(R.string.deal_text)
        stayButton.text = ""
        doubleDownButton.text = ""
        splitButton.text = ""

        //Clear the text
        dealerHandValue.text = "0"
        playerHandValue.text = "0"

        //Shuffle the deck
        deckOfCards = Cards.Deck.cards.shuffled()

        //Reset the hand values and placements
        playerCurrentHandValue = 0
        dealerCurrentHandValue = 0
        cardToDealToPlayer = 3      //3 will be the next card handed out to either player
        cardtoDealtoDealer = 3

        //Begin Game
        hitButton.setOnClickListener {
            playerTurn()
        }

    }

    private fun playerTurn() {

        //Set text and activate the Hit and Stay buttons first
        hitButton.text = getString(R.string.hit_button)
        stayButton.text = getString(R.string.stay_button)
        doubleDownButton.text = getString(R.string.double_down_button)

        hitButton.isClickable = true
        stayButton.isClickable = true
        doubleDownButton.isClickable = true

        //Display the two player cards
        playerFirstCard.setImageResource(deckOfCards[carPos].image)
        playerCurrentHandValue = deckOfCards[carPos].value
        carPos++
        playerSecondCard.setImageResource(deckOfCards[carPos].image)
        playerCurrentHandValue += deckOfCards[carPos].value
        carPos++

        //Display Player hand value
        playerHandValue.text = "$playerCurrentHandValue"    //That $ converts it to string

        //Check for Split
        if (deckOfCards[carPos].name.equals(deckOfCards[carPos--].name)) {
            splitButton.isClickable = true
            splitButton.text = getString(R.string.split_button)
        }

        //Display the first Dealer card
        dealerFirstCard.setImageResource(deckOfCards[carPos].image)
        dealerCurrentHandValue = deckOfCards[carPos].value
        carPos++
        dealerHandValue.text = "$dealerCurrentHandValue"

        //Check to see if Blackjack
        if (playerCurrentHandValue == 21) {
            endgame(playerCurrentHandValue, dealerCurrentHandValue, true)
        }



        //Player hits
        hitButton.setOnClickListener {

            //Disabling the Double option if player chooses to hit
            if (doubleDownButton.isClickable) {
                doubleDownButton.isClickable = false
                doubleDownButton.text = ""
            }

            when (cardToDealToPlayer) {
                3 -> playerThirdCard.setImageResource(deckOfCards[carPos].image)
                4 -> playerFourthCard.setImageResource(deckOfCards[carPos].image)
                5 -> playerFifthCard.setImageResource(deckOfCards[carPos].image)
                6 -> playerSixthCard.setImageResource(deckOfCards[carPos].image)
                else -> showBagels("Card limit reached")
            }
            playerCurrentHandValue += deckOfCards[carPos].value
            carPos++
            cardToDealToPlayer++
            playerHandValue.text = "$playerCurrentHandValue"
            if (playerCurrentHandValue > 21) {
//                busted(0)
                endgame(playerCurrentHandValue, dealerCurrentHandValue, false)
            }
        }

        //Player Doubles Down
        doubleDownButton.setOnClickListener {
            playerThirdCard.setImageResource(deckOfCards[carPos].image)
            playerCurrentHandValue += deckOfCards[carPos].value
            carPos++
            playerHandValue.text = "$playerCurrentHandValue"
            if (playerCurrentHandValue > 21) {
                endgame(playerCurrentHandValue, dealerCurrentHandValue, false)
            }
            else {
                dealerTurn()
            }
        }

        //Player Stays
        stayButton.setOnClickListener {
            dealerTurn()
        }
    }

    private fun dealerTurn() {

        //"Reveal" the dealer second card
        dealerSecondCard.setImageResource(deckOfCards[carPos].image)
        dealerCurrentHandValue += deckOfCards[carPos].value
        carPos++
        dealerHandValue.text = "$dealerCurrentHandValue"

        while (dealerCurrentHandValue < 17) {
            when (cardtoDealtoDealer) {
                3 -> dealerThirdCard.setImageResource(deckOfCards[carPos].image)
                4 -> dealerFourthCard.setImageResource(deckOfCards[carPos].image)
                5 -> dealerFifthCard.setImageResource(deckOfCards[carPos].image)
                6 -> dealerSixthCard.setImageResource(deckOfCards[carPos].image)
                else -> showBagels("Card limit reached")
            }

            dealerCurrentHandValue += deckOfCards[carPos].value
            carPos++
            cardtoDealtoDealer++
        }

        dealerHandValue.text = "$dealerCurrentHandValue"

        if (dealerCurrentHandValue > 21) {
            endgame(playerCurrentHandValue, dealerCurrentHandValue, false)
        } else {
          //if dealer doesn't bust, then it's time to determine the winner!
            endgame(playerCurrentHandValue, dealerCurrentHandValue, false)
        }
    }

    private fun endgame(player: Int, dealer: Int, blackjack: Boolean) {
        when {
            blackjack -> showBagels("BLACKJACK!")
            player > 21 -> showBagels("Player Bust")
            dealer > 21 -> showBagels("Dealer Bust")
            player > dealer -> showBagels("Player Wins!")
            dealer > player -> showBagels("Dealer unfortunately wins")
            player == dealer -> showBagels("Game ends in a tie")
            else -> showBagels("Something went wrong")
        }

        deactivateButtons()
    }

    private fun deactivateButtons() {

        //Changing the state of the buttons when the game is over
        //Setting the player buttons to non-functional
        stayButton.isClickable = false
        doubleDownButton.isClickable = false
        splitButton.isClickable = false

        hitButton.text = "Clear"
        stayButton.text = ""
        doubleDownButton.text = ""
        splitButton.text = ""

        //Reset the game back to start
        hitButton.setOnClickListener {
            resetGame()
        }
    }


}
