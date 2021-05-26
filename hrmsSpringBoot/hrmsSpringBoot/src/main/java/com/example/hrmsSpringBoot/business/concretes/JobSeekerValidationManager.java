package com.example.hrmsSpringBoot.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrmsSpringBoot.business.abstracts.JobSeekerValidationService;
import com.example.hrmsSpringBoot.core.utilities.services.abstracts.UserCheckService;
import com.example.hrmsSpringBoot.dataAccess.abstracts.JobSeekerDao;
import com.example.hrmsSpringBoot.entities.concretes.JobSeeker;

@Service
public class JobSeekerValidationManager implements JobSeekerValidationService{

	private UserCheckService userCheckService;

	@Autowired
	public JobSeekerValidationManager(UserCheckService userCheckService) {
		super();
		this.userCheckService = userCheckService;
	}

	
	@Override
	public boolean checkFirstName(JobSeeker jobSeeker) {
		if(jobSeeker.getFirstName()!=null) {
			return true;}
		else {
			System.out.println("Ad bilgisi zorunludur!");
			return false;
		}
	}

	@Override
	public boolean checkLastName(JobSeeker jobSeeker) {
		if(jobSeeker.getLastName()!=null) {
			return true;}
		else {
			System.out.println("Soyad bilgisi zorunludur!");
			return false;
		}
	}

	@Override
	public boolean checkNationalityId(JobSeeker jobSeeker) {
		if(jobSeeker.getNationalityId()!=0) {
			return true;}
		else {
			System.out.println("Tc kimlik no bilgisi zorunludur!");
			return false;
		}
	}

	@Override
	public boolean checkDateOfBirth(JobSeeker jobSeeker) {
		if(jobSeeker.getDateOfBirth()!=0) {
			return true;}
		else {
			System.out.println("Dogum tarihi bilgisi zorunludur!");
			return false;
		}
	}

	@Override
	public boolean emailCheck(JobSeeker jobSeeker) {
		if(jobSeeker.getEmail()!=null) {
			return true;}
		else {
			System.out.println("Email bilgisi zorunludur!");
			return false;
		}
	}

	@Override
	public boolean passwordCheck(JobSeeker jobSeeker) {
		if(jobSeeker.getPassword()!=null) {
			return true;}
		else {
			System.out.println("Parola bilgisi zorunludur!");
			return false;
		}
	}

	@Override
	public boolean passwordCheckAgain(JobSeeker jobSeeker) {
		if(jobSeeker.getPassword()!=null) {
			return true;}
		else {
			System.out.println("Parola bilgisi zorunludur!");
			return false;
		}
	}


	@Override
	public boolean mernisValidation(JobSeeker jobSeeker) {
		/*
		 * if(userCheckService.validationUser(jobSeeker)==true) { return true;} else {
		 * System.out.println("Gecersiz dogrulama!"); return false; }
		 */
		return true;
	}


	@Override
	public boolean usedBeforeCheck(List<JobSeeker> jobSeekers, JobSeeker jobSeeker) {
		for(JobSeeker seeker : jobSeekers) {
			if(seeker.getEmail().equals(jobSeeker.getEmail())) {
				System.out.println("Email kullanimda!");
				return false;}
			if(seeker.getNationalityId() == (jobSeeker.getNationalityId())) {
				System.out.println("Tc no kullanimda!");
				return false;
			}
		}
		return true;
		
	}


	@Override
	public boolean totalCheck(List<JobSeeker> jobSeekers, JobSeeker jobSeeker) {
		if(checkFirstName(jobSeeker)== true && checkLastName(jobSeeker)==true
				&& checkNationalityId(jobSeeker)==true && checkDateOfBirth(jobSeeker)== true
				&& usedBeforeCheck(jobSeekers, jobSeeker)==true && mernisValidation(jobSeeker)==true
				&& emailCheck(jobSeeker)==true && passwordCheck(jobSeeker)==true 
				&& passwordCheckAgain(jobSeeker)==true) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	

	
	

	
	
}