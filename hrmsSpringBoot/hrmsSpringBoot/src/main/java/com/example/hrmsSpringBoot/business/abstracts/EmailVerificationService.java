package com.example.hrmsSpringBoot.business.abstracts;

import com.example.hrmsSpringBoot.entities.concretes.User;

public interface EmailVerificationService {
	boolean verifyEmail(User user);
	
}
