package com.example.demo.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.example.demo.repository.AuthenticationRepository;

@Aspect
@Service
public class MethodAuthentication {

	AuthenticationRepository authenticationRepository;

	public MethodAuthentication(AuthenticationRepository authenticationRepository) {
		this.authenticationRepository = authenticationRepository;
	}

	@Around("execution(* com.example.demo.controller..*(..)) && args(token,..) && !execution(* com.example.demo.controller.CustomerController.saveList(..))")
	public Object methodauthentication(ProceedingJoinPoint joinPoint, String token) throws Throwable {

		if (authenticationRepository.findByToken(token) == null) {
			throw new RuntimeException("Error,token not found ");
		}
		if (token == null) {
			throw new RuntimeException("missing token");
		}
		return joinPoint.proceed();
	}
}
