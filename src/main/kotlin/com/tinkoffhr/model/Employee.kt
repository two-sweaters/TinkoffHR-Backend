package com.tinkoffhr.model

import java.time.LocalDate
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id

data class Employee (val employee: EmployeeEntity)
{
    var email: String = employee.email
    var fio: String = employee.fio
    var photoUrl: String? = employee.photoUrl
    var bio: String? = employee.bio
    var project: String? = employee.project
    var companyPosition: String = employee.companyPosition
    var birthDate: LocalDate = employee.birthDate
    var employmentDate: LocalDate = employee.employmentDate
    var tableNumber: String? = employee.tableNumber
    var status: EmployeeStatus = employee.status
    var achievement: Achievement? = employee.achievement
}