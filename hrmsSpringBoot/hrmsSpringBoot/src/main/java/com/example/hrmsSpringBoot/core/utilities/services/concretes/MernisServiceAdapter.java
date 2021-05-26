package com.example.hrmsSpringBoot.core.utilities.services.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import com.example.hrmsSpringBoot.core.utilities.results.ErrorDataResult;
import com.example.hrmsSpringBoot.core.utilities.results.SuccessDataResult;
import com.example.hrmsSpringBoot.core.utilities.services.abstracts.UserCheckService;
import com.example.hrmsSpringBoot.entities.concretes.JobSeeker;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements UserCheckService{

	@Override
	public boolean validationUser(JobSeeker jobSeeker) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		boolean result=true;
		try {        
			result = client.TCKimlikNoDogrula(jobSeeker.getNationalityId(), jobSeeker.getFirstName().toUpperCase(),
					jobSeeker.getLastName().toUpperCase(), jobSeeker.getDateOfBirth());
		}catch (RemoteException e) {
		        e.printStackTrace();	}
			
		if(result==true)
			new SuccessDataResult(jobSeeker.getFirstName() + " gecerli bir kisi.");
		else
			new ErrorDataResult(jobSeeker.getFirstName() + " gecersiz bir kisi.");
		return result;
			
	}
	

}
