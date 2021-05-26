package com.example.hrmsSpringBoot.business.concretes;

import org.springframework.stereotype.Service;

import com.example.hrmsSpringBoot.business.abstracts.EmailVerificationService;
import com.example.hrmsSpringBoot.entities.concretes.User;

@Service
public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public boolean verifyEmail(User user) {
		System.out.println(user.getEmail() + " dogrulanmistir!");
		return true;
	}

}
