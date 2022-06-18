package com.example.foodfor_kmm.common.utils

import kotlinx.datetime.*


class DataTimeUtil {
    fun now(): LocalDateTime {
        val currentMoment: Instant = Clock.System.now()
        return currentMoment.toLocalDateTime(TimeZone.UTC)
    }

    fun toLocalDate(date: Double): LocalDateTime {
        return Instant.fromEpochMilliseconds(date.toLong()).toLocalDateTime(TimeZone.UTC)
    }

    fun toEpochMilliseconds(date: LocalDateTime): Double {
        return date.toInstant(TimeZone.UTC).toEpochMilliseconds().toDouble()
    }

    // States: yesterday, today, tomorrow and everything else
    fun humanizeDatetime(date: LocalDateTime?): String {
        val sb = StringBuilder()


        date?.run {
            try {
                val hour = if (this.hour > 12) {
                    (this.hour - 12).toString() + "pm"
                } else {
                    if (this.hour != 0) this.hour.toString() + "am" else "midnight"
                }
                val today = now()
                val currentMoment: Instant = Clock.System.now()

                val tomorrow = currentMoment.plus(1, DateTimeUnit.DAY, TimeZone.UTC)
                    .toLocalDateTime(TimeZone.UTC)
                if (this.date == today.date) {
                    sb.append("Today at $hour")
                } else if (this.date == tomorrow.date) {
                    sb.append("Tomorrow at $hour")
                } else {
                    sb.append(this.date.month.name.lowercase() + " ${this.date.dayOfMonth}")
                }
            } catch (e: Exception) {
                println("ERROR WITH ${e.message.toString()}")
            }
        } ?: sb.append("Unknown")
        return sb.toString()
    }
}