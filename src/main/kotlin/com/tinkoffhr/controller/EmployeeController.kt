package com.tinkoffhr.controller

import com.tinkoffhr.model.Employee
import com.tinkoffhr.model.EmployeeStatus
import com.tinkoffhr.service.EmployeeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/employees")
class EmployeeController(private val service: EmployeeService) {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleNotFound(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping
    fun getAllEmployees(): List<Employee> = service.getAllEmployees()

    @PatchMapping("/{email}/photo/{photoUrl}")
    fun postPhotoUrl(@PathVariable email: String, @PathVariable photoUrl: String) =
        service.savePhotoUrl(email, photoUrl)
}
