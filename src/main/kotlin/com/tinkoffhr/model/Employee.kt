package com.tinkoffhr.model

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="employees")
class Employee (
    @Id var email: String,
    var fio: String,
    var photoUrl: String?,
    var bio: String?,
    var project: String?,
    var companyPosition: String,
    var birthDate: LocalDate,
    var employmentDate: LocalDate,
    var tableNumber: String?,
    var status: EmployeeStatus,
    var achievement: String?
)

enum class EmployeeStatus {
    OFFICE,
    HOME,
    SICK,
    TRIP,
    VACATION,
    FIRED
}

enum class Achievement {
    NONE,
    SPEAKER,
    TEACHER
}