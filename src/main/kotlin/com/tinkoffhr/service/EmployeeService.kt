package com.tinkoffhr.service

import com.tinkoffhr.EntityNotFoundException
import com.tinkoffhr.repository.EmployeeRepository
import com.tinkoffhr.model.EmployeeEntity
import com.tinkoffhr.model.EmployeeStatus
import org.springframework.stereotype.Service

@Service
class EmployeeService(private val dataSource: EmployeeRepository) {

    fun getAllEmployees(): List<EmployeeEntity> = dataSource.findAll().toList()

    fun updatePhotoUrl(email: String, photoUrl: String) {
        if (dataSource.savePhotoUrl(email, photoUrl) == 0)
            throw EntityNotFoundException("Could not found employee with $email email address")
    }

    fun updateStatus(email: String, status: EmployeeStatus) {
        if (dataSource.saveStatus(email, status) == 0)
            throw EntityNotFoundException("Could not found employee with $email email address")
    }

    fun updateBio(email: String, bio: String) {
        if (dataSource.saveBio(email, bio) == 0)
            throw EntityNotFoundException("Could not found employee with $email email address")
    }
}