package com.cdac.oralcaremanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cdac.oralcaremanagement.dao.UserRepository;
import com.cdac.oralcaremanagement.entity.User;

@Service
public class LoginService {

	@Autowired
	private UserRepository patientRepo;

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public boolean authenticate(User user) {
		System.out.println(user.getEmail());
		User dbUser = patientRepo.findByEmail(user.getEmail());
		System.out.println(dbUser);
		if (dbUser != null && bCryptPasswordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
			System.out.println("hii");
			return true; // Authentication successful
		}
		return false; // Authentication failed
	}

	public boolean authenticateEmail(User user) {
	
		User dbUser = patientRepo.findByEmail(user.getEmail());
		System.out.println(user.getEmail());
		System.out.println(dbUser);
		if (dbUser != null)
			return true;
		else
			return false;
	}

	public User getUserByEmail(String email) {
		return patientRepo.findByEmail(email);
	}
}