package com.example.hrmsSpringBoot.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hrmsSpringBoot.core.utilities.results.DataResult;
import com.example.hrmsSpringBoot.core.utilities.results.Result;
import com.example.hrmsSpringBoot.entities.concretes.JobSeeker;

public interface JobSeekerService {

	DataResult<List<JobSeeker>> getAll();
	Result register(JobSeeker jobSeeker);
}
