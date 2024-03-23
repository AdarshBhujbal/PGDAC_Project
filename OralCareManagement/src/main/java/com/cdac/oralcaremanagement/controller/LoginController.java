package com.cdac.oralcaremanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.oralcaremanagement.entity.User;
import com.cdac.oralcaremanagement.service.LoginService;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/authenticate")
	public ResponseEntity<?> login(@RequestBody User user) {

		String email = user.getEmail();
		String pass = user.getPassword();
		System.out.println(email);
		System.out.println(pass);
		if (loginService.authenticate(user)) {
			return ResponseEntity.ok("Login successful");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
		}
	}

	@PostMapping("/authenticateEmail")
	public ResponseEntity<?> FindByEmail(@RequestBody User user) {

		String email = user.getEmail();
		if (loginService.authenticateEmail(user)) {
			return ResponseEntity.ok("email verify successful");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email");
		}
	}

	@GetMapping("/getUserDetails")
	public ResponseEntity<?> getUserDetails(@RequestParam String email) {
		User user = loginService.getUserByEmail(email);

		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
	}
}