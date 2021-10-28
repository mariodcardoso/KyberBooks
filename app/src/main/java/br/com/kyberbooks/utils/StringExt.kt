package br.com.kyberbooks.utils

import android.util.Log


fun String.isValidIsbn13(): Boolean {
    var sumResult = 0

    for (i in 0 until this.length - 1) {
        val number = this.substring(i, i+1)

        val multiplyResult = if (i % 2 == 0) number.toInt() * 1 else number.toInt() * 3
        sumResult += multiplyResult
    }
    val module = sumResult % 10

    return 10 - module == this.substring(this.lastIndex).toInt()

}