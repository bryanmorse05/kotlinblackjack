package com.blackjack.rainy.bryanmorse.kotlinblackjack.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
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
    var playerNumAces: Int = 0
    var dealerNumAces: Int = 0

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
        txtDealerHandValue.text = "0"
        txtPlayerHandValue.text = "0"

        //Shuffle the deck
        deckOfCards = Cards.Deck.cards.shuffled()

        //Reset the hand values and placements
        playerCurrentHandValue = 0
        dealerCurrentHandValue = 0
        cardToDealToPlayer = 1
        cardtoDealtoDealer = 1
        playerNumAces = 0
        dealerNumAces = 0
        carPos = 0

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
        splitButton.text = getString(R.string.split_button)

        hitButton.isClickable = true
        stayButton.isClickable = true
        doubleDownButton.isClickable = true
        splitButton.isClickable = true



        //Display the two player cards
        nextCard(0, deckOfCards[carPos], playerFirstCard)
        nextCard(0, deckOfCards[carPos], playerSecondCard)

        //Display the first Dealer card
        nextCard(1, deckOfCards[carPos], dealerFirstCard)

        //Check to see if Blackjack
        if (playerCurrentHandValue == 21) {
            endGame(playerCurrentHandValue, dealerCurrentHandValue, true)
        }

        /*
        //Check for Split
        if (firstCardTest.equals(secondCardTest)) {
            splitButton.isClickable = true
            splitButton.text = getString(R.string.split_button)
        }
*/


        //Player hits
        hitButton.setOnClickListener {

            //Disabling the Double and Split options if player chooses to hit
            doubleDownButton.isClickable = false
            doubleDownButton.text = ""
            splitButton.isClickable = false
            splitButton.text = ""

            when (cardToDealToPlayer) {
                3 -> nextCard(0, deckOfCards[carPos], playerThirdCard)
                4 -> nextCard(0, deckOfCards[carPos], playerFourthCard)
                5 -> nextCard(0, deckOfCards[carPos], playerFifthCard)
                6 -> nextCard(0, deckOfCards[carPos], playerSixthCard)
                else -> showBagels("Card limit reached")
            }

        }

        //Player DOUBLES DOWN
        doubleDownButton.setOnClickListener {
            nextCard(0, deckOfCards[carPos], playerThirdCard)       //Player only gets ONE card
            dealerTurn()
        }



        //PLAYER STAYS
        stayButton.setOnClickListener {
            dealerTurn()
        }



        //PLAYER SPLITS
        splitButton.setOnClickListener {

            nextCard(0, deckOfCards[carPos], playerSecondCard)
            nextCard(0, deckOfCards[1], playerSplitFirstCard)       //Because we know this is the 2nd card
            nextCard(0, deckOfCards[carPos], playerSplitSecondCard)

        }
    }



    private fun dealerTurn() {

        //"Reveal" the dealer second card
        nextCard(1, deckOfCards[carPos], dealerSecondCard)

        while (dealerCurrentHandValue < 17) {
            when (cardtoDealtoDealer) {
                3 -> nextCard(1, deckOfCards[carPos], dealerThirdCard)
                4 -> nextCard(1, deckOfCards[carPos], dealerFourthCard)
                5 -> nextCard(1, deckOfCards[carPos], dealerFifthCard)
                6 -> nextCard(1, deckOfCards[carPos], dealerSixthCard)
                else -> showBagels("Card limit reached")
            }
        }

        //if dealer doesn't bust, then it's time to determine the winner!
        endGame(playerCurrentHandValue, dealerCurrentHandValue, false)

    }



    private fun endGame(player: Int, dealer: Int, blackjack: Boolean) {
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



    private fun nextCard(who: Int, card: Cards, location: ImageView) {

        location.setImageResource(card.image)       //Display card

        if (who == 0) {
            //PLAYER
            playerCurrentHandValue += card.value                    //Update hand value
            txtPlayerHandValue.text = "$playerCurrentHandValue"     //Display value.  That $ converts it to string
            if (card.name.equals("Ace")) {
                playerNumAces++                                     //Update the number of aces
            }
            cardToDealToPlayer++                                    //Next position for the image to display

            if (playerCurrentHandValue > 21) {                      //Check total value
                checkForAces(0, playerNumAces)                //Check to see if player has an aces
            }
        }

        else {
            //DEALER
            dealerCurrentHandValue += card.value
            txtDealerHandValue.text = "$dealerCurrentHandValue"
            if (card.name.equals("Ace")) {
                dealerNumAces++                                     //Update number of aces
            }
            cardtoDealtoDealer++                                    //Next position for the image to display

            if (dealerCurrentHandValue > 21) {                      //Check total value
                checkForAces(1, dealerNumAces)                //Check to see if player has an aces
            }
        }

        carPos++                                                    //Next position in the array for the deck
    }



    private fun checkForAces(who: Int, number: Int) {

        if (who == 0) {
            if (number > 0) {
                playerCurrentHandValue -= 10
                playerNumAces--
                txtPlayerHandValue.text = "$playerCurrentHandValue"
            }
            else {
                endGame(playerCurrentHandValue, dealerCurrentHandValue, false)  //If no aces, end the game
            }
        }

        else {
            if (number > 0) {
                dealerCurrentHandValue -= 10
                dealerNumAces--
                txtDealerHandValue.text = "$dealerCurrentHandValue"
            }
            else {
                endGame(playerCurrentHandValue, dealerCurrentHandValue, false)  //If no aces, end the game
            }
        }
    }


}
