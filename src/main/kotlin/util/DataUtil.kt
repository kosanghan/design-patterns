package util

private val DAY = 0
private val NIGHT = 1

fun Int.toBoolean(): Boolean {
    return this == DAY
}

fun Boolean.toInt(): Int {
    return if (this) DAY else NIGHT
}