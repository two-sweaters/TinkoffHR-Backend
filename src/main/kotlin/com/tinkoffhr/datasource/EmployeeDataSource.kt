package com.tinkoffhr.datasource

import com.tinkoffhr.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface EmployeeDataSource : CrudRepository<Employee, String>
