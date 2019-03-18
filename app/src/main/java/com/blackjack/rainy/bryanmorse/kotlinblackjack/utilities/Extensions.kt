package com.blackjack.rainy.bryanmorse.kotlinblackjack.utilities

import android.content.Context
import android.widget.Toast

fun Context.showBagels(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}