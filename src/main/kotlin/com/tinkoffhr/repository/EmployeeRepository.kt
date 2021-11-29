package com.tinkoffhr.repository

import com.tinkoffhr.model.EmployeeEntity
import com.tinkoffhr.model.EmployeeStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional

interface EmployeeRepository : JpaRepository<EmployeeEntity, String>
