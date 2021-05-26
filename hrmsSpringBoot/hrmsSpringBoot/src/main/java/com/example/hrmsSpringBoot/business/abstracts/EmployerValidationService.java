package com.example.hrmsSpringBoot.business.abstracts;

import java.util.List;

import com.example.hrmsSpringBoot.entities.concretes.Employer;

public interface EmployerValidationService {
	boolean checkCompanyName(Employer employer);
	boolean checkWebsite(Employer employer);
	boolean checkEmail(Employer employer);
	boolean checkPhone(Employer employer);
	boolean checkPassword(Employer employer);
	boolean checkPasswordAgain(Employer employer);
	boolean usedBeforeCheck(List<Employer> employers, Employer employer);
	boolean totalCheck(List<Employer> employers, Employer employer);
}
