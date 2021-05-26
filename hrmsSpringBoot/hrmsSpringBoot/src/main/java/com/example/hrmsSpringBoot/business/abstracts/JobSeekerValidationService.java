package com.example.hrmsSpringBoot.business.abstracts;

import java.util.List;
import com.example.hrmsSpringBoot.entities.concretes.JobSeeker;

public interface JobSeekerValidationService {
	boolean checkFirstName(JobSeeker jobSeeker);
	boolean checkLastName(JobSeeker jobSeeker);
	boolean checkNationalityId(JobSeeker jobSeeker);
	boolean checkDateOfBirth(JobSeeker jobSeeker);
	boolean emailCheck(JobSeeker jobSeeker);
	boolean passwordCheck(JobSeeker jobSeeker);
	boolean passwordCheckAgain(JobSeeker jobSeeker);
	boolean mernisValidation(JobSeeker jobSeeker);
	boolean usedBeforeCheck(List<JobSeeker> jobSeekers, JobSeeker jobSeeker);
	boolean totalCheck(List<JobSeeker> jobSeekers, JobSeeker jobSeeker);
}
