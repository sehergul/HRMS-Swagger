package com.example.hrmsSpringBoot.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrmsSpringBoot.business.abstracts.EmailVerificationService;
import com.example.hrmsSpringBoot.business.abstracts.JobSeekerService;
import com.example.hrmsSpringBoot.business.abstracts.JobSeekerValidationService;
import com.example.hrmsSpringBoot.core.utilities.results.DataResult;
import com.example.hrmsSpringBoot.core.utilities.results.ErrorDataResult;
import com.example.hrmsSpringBoot.core.utilities.results.Result;
import com.example.hrmsSpringBoot.core.utilities.results.SuccessDataResult;
import com.example.hrmsSpringBoot.dataAccess.abstracts.JobSeekerDao;
import com.example.hrmsSpringBoot.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	private JobSeekerValidationService jobSeekerValidationService;
	private EmailVerificationService emailVerificationService;
	
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, JobSeekerValidationService jobSeekerValidationService,
			EmailVerificationService emailVerificationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.jobSeekerValidationService = jobSeekerValidationService;
		this.emailVerificationService = emailVerificationService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>
			(this.jobSeekerDao.findAll(), "İş arayanlar listelendi!");
	}

	@Override
	public Result register(JobSeeker jobSeeker) {
		if(this.jobSeekerValidationService.totalCheck(this.jobSeekerDao.findAll(), jobSeeker)==true
				&& (this.emailVerificationService.verifyEmail(jobSeeker))==true) {
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessDataResult("İş arayan kayıt oldu!");
			}
		else {
			return new ErrorDataResult("İş arayan kayıt olamadı!");
			}
	}
	
}
	
	

	
