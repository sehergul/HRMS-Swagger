package com.example.hrmsSpringBoot.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrmsSpringBoot.entities.concretes.SystemStaff;

public interface SystemStaffDao extends JpaRepository<SystemStaff, Integer> {

}
