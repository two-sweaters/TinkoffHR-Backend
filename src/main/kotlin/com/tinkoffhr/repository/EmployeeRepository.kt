package com.tinkoffhr.repository

import com.tinkoffhr.model.EmployeeEntity
import com.tinkoffhr.model.EmployeeStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional

interface EmployeeRepository : JpaRepository<EmployeeEntity, String> {

    @Modifying
    @Transactional
    @Query("UPDATE EmployeeEntity SET photoUrl = ?2 WHERE email = ?1")
    fun savePhotoUrl(email: String, url: String) : Int

    @Modifying
    @Transactional
    @Query("UPDATE EmployeeEntity SET status = ?2 WHERE email = ?1")
    fun saveStatus(email: String, status: EmployeeStatus) : Int

    @Modifying
    @Transactional
    @Query("UPDATE EmployeeEntity SET bio = ?2 WHERE email = ?1")
    fun saveBio(email: String, bio: String) : Int
}
