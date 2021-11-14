package com.tinkoffhr.controller

import com.tinkoffhr.model.Employee
import com.tinkoffhr.service.EmployeeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/employees")
class EmployeeController(private val service: EmployeeService) {
    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @GetMapping
    fun getAllEmployees(): List<Employee> = service.getAllEmployees()
}
