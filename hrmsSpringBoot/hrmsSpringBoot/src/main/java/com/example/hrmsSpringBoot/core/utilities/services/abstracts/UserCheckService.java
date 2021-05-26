package com.example.hrmsSpringBoot.core.utilities.services.abstracts;

import com.example.hrmsSpringBoot.entities.concretes.JobSeeker;

public interface UserCheckService {

	boolean validationUser(JobSeeker jobSeeker);
}
