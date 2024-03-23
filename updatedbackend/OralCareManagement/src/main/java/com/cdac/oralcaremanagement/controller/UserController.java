package com.cdac.oralcaremanagement.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.oralcaremanagement.dto.ErrorResponse;
import com.cdac.oralcaremanagement.entity.User;
import com.cdac.oralcaremanagement.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userServiceRef;

	// http://localhost:8000/patient/addPatient
	// @PostMapping("/addPatient")
//	public void addNewPatient(@RequestBody User patientRef) {
//		System.out.println(patientRef);
//		patientServiceRef.addNewPatient(patientRef);
//	}

	// http://localhost:8000/user/addUser
	@PostMapping("/addUser")
	public ResponseEntity<?> AddUser(@RequestBody User transientUser) {
		try {
			String user = userServiceRef.addNewUser(transientUser);
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(new ErrorResponse("Failed to add user", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// http://localhost:8000/user/getUsers
	@GetMapping("/getUsers")
	public Collection<User> getAllUsers() {

		Collection<User> allUsers = userServiceRef.getAllUsers();
		return allUsers;
	}

	// http://localhost:8000/user/getUser/P1003
	@GetMapping("/getUser/{uId}")
	public User getOneUser(@PathVariable("uId") Integer uId) {
		User foundUser = userServiceRef.getOneUser(uId);
		return foundUser;
	}

	// http://localhost:8000/user/updateUser/P1005

//@PutMapping("/updateUser/{uId}") // to update existing user
//	public User updateById(@RequestBody User updatedUser, @PathVariable Integer uId) {
//		User existingUser = userServiceRef.getOneUser(uId);
//		return userServiceRef.updatedUser(existingUser, updatedUser);
//	}

	// http://localhost:8000/updateUser/1
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<?> updateById(@RequestBody User updatedUser, @PathVariable Integer uId) {
		User existingUser = userServiceRef.getOneUser(uId);
		if (existingUser == null) {
			return ResponseEntity.notFound().build(); // Return 404 Not Found if user doesn't exist
		}
		// Update the existing patient and return a response
		return ResponseEntity.ok(userServiceRef.updatedUser(existingUser, updatedUser));
	}

	// http://localhost:8000/deleteUser/uId
	@DeleteMapping("/deleteUser/{userId}")
	public void deleteOneUser(@PathVariable("userId") Integer uId) {

		userServiceRef.deleteOnePatient(uId);
	}

	@PutMapping("/updatePassword/{userId}")
	public ResponseEntity<?> updatePassword(@RequestBody User updatedUser, @PathVariable Integer userId) {
		User existingUser = userServiceRef.getOneUser(userId);
		if (existingUser == null) {
			return ResponseEntity.notFound().build(); // Return 404 Not Found if the user doesn't exist
		}

		// Update the password of the existing user and return a response
		existingUser.setPassword(updatedUser.getPassword()); // You might want to hash the password before saving it

		try {
			userServiceRef.updatePassword(existingUser);
			return ResponseEntity.ok("Password updated successfully");
		} catch (RuntimeException e) {
			return new ResponseEntity<>(new ErrorResponse("Failed to update password", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
