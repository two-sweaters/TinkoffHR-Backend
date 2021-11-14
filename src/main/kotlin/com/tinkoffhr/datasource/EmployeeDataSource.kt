package com.tinkoffhr.datasource

import com.tinkoffhr.model.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeDataSource : JpaRepository<Employee, String>
