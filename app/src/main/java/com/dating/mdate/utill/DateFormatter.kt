package com.dating.mdate.utill

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormatter
import org.joda.time.format.ISODateTimeFormat

object DateFormatter {

    fun getDateFromISOString(inputDate: String): DateTime? {
        val isoFormatter = ISODateTimeFormat.dateTime()
        var date: DateTime? = null

        try {
            date = isoFormatter.parseDateTime(inputDate)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }

        return date
    }

    fun getDateTodayString(today: DateTime): String {
        val todayMidnight = DateTime().withTimeAtStartOfDay()
        var stringDate: String
        if (todayMidnight.isEqual(today.withTimeAtStartOfDay())) {
            stringDate = "Today - "
        } else {
            stringDate = today.toString("MMM. dd - ")
        }

        stringDate = stringDate + today.toString("hh:mma")

        return stringDate
    }

    fun getFormattedDateFromISOString(inputDate: String): String {
        return getDateTodayString(getDateFromISOString(inputDate)!!)
    }
}
