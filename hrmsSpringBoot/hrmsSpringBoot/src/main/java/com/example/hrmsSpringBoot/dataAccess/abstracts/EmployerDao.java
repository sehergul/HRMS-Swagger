package com.example.hrmsSpringBoot.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrmsSpringBoot.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
