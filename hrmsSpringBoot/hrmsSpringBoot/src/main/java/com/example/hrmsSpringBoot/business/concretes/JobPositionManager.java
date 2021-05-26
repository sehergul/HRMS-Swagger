package com.example.hrmsSpringBoot.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrmsSpringBoot.business.abstracts.JobPositionService;
import com.example.hrmsSpringBoot.core.utilities.results.DataResult;
import com.example.hrmsSpringBoot.core.utilities.results.ErrorDataResult;
import com.example.hrmsSpringBoot.core.utilities.results.Result;
import com.example.hrmsSpringBoot.core.utilities.results.SuccessDataResult;
import com.example.hrmsSpringBoot.dataAccess.abstracts.JobPositionDao;
import com.example.hrmsSpringBoot.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;



	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>
			(this.jobPositionDao.findAll(), "İş pozisyonları listelendi!");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		boolean result = false;
		for(JobPosition _jobPosition: this.jobPositionDao.findAll()) {
			if((_jobPosition).equals(jobPosition)) {
				this.jobPositionDao.save(jobPosition);
			}else {
				this.jobPositionDao.save(jobPosition);
				result = true;
			}
		}
		
		if(result == true)
			return new SuccessDataResult("İş pozisyonu eklendi!");
		else
			return new ErrorDataResult("İş pozisyonu zaten mevcut!");
	
	}
	
	
	

}
