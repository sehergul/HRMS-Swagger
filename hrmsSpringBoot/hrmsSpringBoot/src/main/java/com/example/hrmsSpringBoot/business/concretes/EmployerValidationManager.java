package com.example.hrmsSpringBoot.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrmsSpringBoot.business.abstracts.EmployerValidationService;
import com.example.hrmsSpringBoot.dataAccess.abstracts.EmployerDao;
import com.example.hrmsSpringBoot.entities.concretes.Employer;
import com.example.hrmsSpringBoot.entities.concretes.JobSeeker;

@Service
public class EmployerValidationManager implements EmployerValidationService{

	
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerValidationManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	
	@Override
	public boolean checkCompanyName(Employer employer) {
		if(employer.getCompanyName()!=null) {
			return true;}
		else {
			System.out.println("Sirket adi bilgisi zorunludur!");
			return false;
		}
	}

	@Override
	public boolean checkWebsite(Employer employer) {
		if(employer.getWebsite()!=null) {
			return true;}
		else {
			System.out.println("Website bilgisi zorunludur!");
			return false;
		}
	}

	@Override
	public boolean checkEmail(Employer employer) {
		if(employer.getEmail()!=null) {
			return true;}
		else {
			System.out.println("Email bilgisi zorunludur!");
			return false;
		}
	}


	@Override
	public boolean checkPassword(Employer employer) {
		if(employer.getPassword()!=null) {
			return true;}
		else {
			System.out.println("Parola bilgisi zorunludur!");
			return false;
		}
	}

	@Override
	public boolean checkPasswordAgain(Employer employer) {
		if(employer.getPassword()!=null) {
			return true;}
		else {
			System.out.println("Parola bilgisi zorunludur!");
			return false;
		}
	}

	@Override
	public boolean usedBeforeCheck(List<Employer> employers, Employer employer) {
		for(Employer _employer : employers) {
			if(_employer.getEmail().equals(employer.getEmail())) {
				System.out.println("Email kullanimda!");
				return false;	}
		}
		return true;
	}
	
	

	@Override
	public boolean checkPhone(Employer employer) {
		if(employer.getPhone()!=null) {
			return true;}
		else {
			System.out.println("Telefon bilgisi zorunludur!");
			return false;
		}
	}


	@Override
	public boolean totalCheck(List<Employer> employers, Employer employer) {
		if(checkCompanyName(employer)==true && checkEmail(employer)==true &&
				checkPassword(employer)==true && checkPasswordAgain(employer)==true &&
				checkWebsite(employer)==true && checkPhone(employer)==true) {
			return true;
		}
		else {
			return false;}
	}
	
	

}
