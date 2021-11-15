package com.tinkoffhr

import com.tinkoffhr.model.Achievement
import com.tinkoffhr.model.EmployeeStatus
import org.springframework.core.convert.converter.Converter
import java.lang.IllegalArgumentException
import java.util.*

class StringToAchievementConverter : Converter<String?, Achievement?> {
    override fun convert(value: String): Achievement? {
        return try {
            Achievement.valueOf(value.uppercase(Locale.getDefault()))
        } catch (e: IllegalArgumentException) {
            null
        }
    }
}

class StringToEmployeeStatusConverter : Converter<String?, EmployeeStatus?> {
    override fun convert(value: String): EmployeeStatus? {
        return try {
            EmployeeStatus.valueOf(value.uppercase(Locale.getDefault()))
        } catch (e: IllegalArgumentException) {
            null
        }
    }
}