package com.digitalhouse.dhwallet.util.ext

import java.util.*

fun Random.getIntInRange(min: Int, max: Int): Int {
    return this.nextInt(max) + min
}