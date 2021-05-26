package com.example.hrmsSpringBoot.business.concretes;

import org.springframework.stereotype.Service;

import com.example.hrmsSpringBoot.business.abstracts.VerificationBySystemStaff;
import com.example.hrmsSpringBoot.entities.concretes.Employer;

@Service
public class EmployerVerificationManager implements VerificationBySystemStaff{

	@Override
	public boolean verify() {
		System.out.println("HRMS personeli tarafindan dogrulanmistir!");
		return true;
	}
	
}
