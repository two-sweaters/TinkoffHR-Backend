package com.tinkoffhr.controller

import com.tinkoffhr.InvalidArgumentException
import com.tinkoffhr.StringToEmployeeStatusConverter
import com.tinkoffhr.dto.EmployeeAdminDto
import com.tinkoffhr.dto.EmployeeUserDto
import com.tinkoffhr.model.Employee
import com.tinkoffhr.model.EmployeeEntity
import com.tinkoffhr.service.EmployeeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/employees")
class EmployeeController(private val service: EmployeeService) {

    @GetMapping
    fun getAllEmployees(): List<Employee> = service.getAllEmployees().map {entity -> Employee(entity) }

    @PutMapping("/user")
    fun putEmployeeUser(@RequestParam email: String, @RequestBody employee: EmployeeUserDto) =
        service.updateEmployeeUser(email, employee)

    @PutMapping("/admin")
    fun putEmployeeAdmin(@RequestParam email: String, @RequestBody employee: EmployeeAdminDto) =
        service.updateEmployeeAdmin(email, employee)
}
