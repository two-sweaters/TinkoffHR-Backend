package com.tinkoffhr.service

import com.tinkoffhr.InvalidArgumentException
import com.tinkoffhr.StringToEmployeeStatusConverter
import com.tinkoffhr.dto.EmployeeAdminDto
import com.tinkoffhr.dto.EmployeeUserDto
import com.tinkoffhr.repository.EmployeeRepository
import com.tinkoffhr.model.EmployeeEntity
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class EmployeeService(private val repository: EmployeeRepository) {

    fun getAllEmployees(): List<EmployeeEntity> = repository.findAll().toList()

    fun getEmployee(email: String): EmployeeEntity =
        repository.findByIdOrNull(email)
            ?: throw NoSuchElementException("Could not found employee with $email email address")

    fun updateEmployeeUser(email: String, dto: EmployeeUserDto) {
        val entity = getEmployee(email)

        val statusEnum = StringToEmployeeStatusConverter().convert(dto.status)
            ?: throw InvalidArgumentException("Invalid employee status ${dto.status}")

        entity.photoUrl = dto.photoUrl
        entity.bio = dto.bio
        entity.status = statusEnum

        repository.save(entity)
    }

    fun updateEmployeeAdmin(email: String, dto: EmployeeAdminDto) {
        val entity = getEmployee(email)

        entity.project = dto.project
        entity.companyPosition = dto.companyPosition
        entity.birthDate = dto.birthDate
        entity.employmentDate = dto.employmentDate
        entity.tableNumber = dto.tableNumber

        repository.save(entity)
    }
}