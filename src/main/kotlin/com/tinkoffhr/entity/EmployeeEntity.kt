package com.tinkoffhr.model

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name="employees")
class EmployeeEntity (
    @Id var email: String,
    var fio: String,
    var photoUrl: String?,
    var bio: String?,
    var project: String?,
    var companyPosition: String,
    var birthDate: LocalDate,
    var employmentDate: LocalDate,
    var tableNumber: String?,
    @Enumerated(EnumType.STRING) var status: EmployeeStatus,
    @Enumerated(EnumType.STRING) var achievement: Achievement?
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
    SPEAKER,
    TEACHER
}