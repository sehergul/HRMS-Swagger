package com.example.hrmsSpringBoot.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrmsSpringBoot.business.abstracts.EmailVerificationService;
import com.example.hrmsSpringBoot.business.abstracts.EmployerService;
import com.example.hrmsSpringBoot.business.abstracts.EmployerValidationService;
import com.example.hrmsSpringBoot.business.abstracts.VerificationBySystemStaff;
import com.example.hrmsSpringBoot.core.utilities.results.DataResult;
import com.example.hrmsSpringBoot.core.utilities.results.ErrorDataResult;
import com.example.hrmsSpringBoot.core.utilities.results.Result;
import com.example.hrmsSpringBoot.core.utilities.results.SuccessDataResult;
import com.example.hrmsSpringBoot.dataAccess.abstracts.EmployerDao;
import com.example.hrmsSpringBoot.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmployerValidationService employerValidationService;
	private VerificationBySystemStaff verificationBySystemStaff;
	private EmailVerificationService emailVerificationService;
	


	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerValidationService employerValidationService, 
			EmailVerificationService emailVerificationService, VerificationBySystemStaff verificationBySystemStaff) {
		super();
		this.employerDao = employerDao;
		this.employerValidationService = employerValidationService;
		this.emailVerificationService = emailVerificationService;
		this.verificationBySystemStaff = verificationBySystemStaff;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
				(this.employerDao.findAll(), "İş verenler listelendi!");
	}

	@Override
	public Result register(Employer employer) {
		if(this.employerValidationService.totalCheck(this.employerDao.findAll(), employer)==true
				&& this.emailVerificationService.verifyEmail(employer)==true 
				&& this.verificationBySystemStaff.verify()==true) {
			this.employerDao.save(employer);
			return new SuccessDataResult("İş veren kayıt oldu!");}
		else {
			return new ErrorDataResult("İş veren kayıt olamadı!");}
		}
	

}
