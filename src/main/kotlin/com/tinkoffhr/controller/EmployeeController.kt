package com.tinkoffhr.controller

import com.tinkoffhr.InvalidArgumentException
import com.tinkoffhr.StringToEmployeeStatusConverter
import com.tinkoffhr.model.Employee
import com.tinkoffhr.model.EmployeeEntity
import com.tinkoffhr.service.EmployeeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/employees")
class EmployeeController(private val service: EmployeeService) {

    @GetMapping
    fun getAllEmployees(): List<Employee> = service.getAllEmployees().map {entity -> Employee(entity) }

    @PatchMapping("/photo")
    fun postPhotoUrl(@RequestParam email: String, @RequestBody photoUrl: String) =
        service.updatePhotoUrl(email, photoUrl)

    @PatchMapping("/status")
    fun postStatus(@RequestParam email: String, @RequestBody status: String) {
        val statusEnum = StringToEmployeeStatusConverter().convert(status)
            ?: throw InvalidArgumentException("Invalid employee status $status")

        service.updateStatus(email, statusEnum)
    }

    @PatchMapping("/bio")
    fun postBio(@RequestParam email: String, @RequestBody bio: String) =
        service.updatePhotoUrl(email, bio)
}
