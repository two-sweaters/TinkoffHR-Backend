package com.tinkoffhr.dto

import com.tinkoffhr.model.Achievement
import com.tinkoffhr.model.EmployeeStatus
import java.time.LocalDate

data class EmployeeAdminDto (
    val project: String,
    val companyPosition: String,
    val birthDate: LocalDate,
    val employmentDate: LocalDate,
    val tableNumber: String,
    )
