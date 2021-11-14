package com.tinkoffhr.service

import com.tinkoffhr.datasource.EmployeeDataSource
import com.tinkoffhr.model.Employee
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class EmployeeService(private val dataSource: EmployeeDataSource) {

    fun getAllEmployees(): List<Employee> = dataSource.findAll().toList()

    fun getEmployee(email: String): Employee =
        dataSource.findByIdOrNull(email)
            ?: throw NoSuchElementException("Could not found employee with $email email address")

    fun post(employee: Employee) = dataSource.save(employee)
}