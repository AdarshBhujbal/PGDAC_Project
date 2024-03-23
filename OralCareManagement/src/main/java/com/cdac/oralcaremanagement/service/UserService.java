package com.cdac.oralcaremanagement.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cdac.oralcaremanagement.dao.UserRepository;
import com.cdac.oralcaremanagement.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepoRef;

	@Autowired
	private PasswordEncoder encoder;

	public String addNewUser(User userRef) {

		User email = userRepoRef.findByEmail(userRef.getEmail());
		User mobileNo = userRepoRef.findByMobileNo(userRef.getMobileNo());

		if (email != null) {
			return "Email address already exist";
		} else if (mobileNo != null) {
			return "Mobile Number already exist";
		}
		userRef.setPassword(encoder.encode(userRef.getPassword()));

		// Save the user to the database
		userRepoRef.save(userRef);

		return "Registration successfully completed";
	}

	public Collection<User> getAllUsers() {

		Collection<User> getAllUsers = userRepoRef.findAll();
		return getAllUsers;
	}

	public User getOneUser(Integer uId) {
		// Optional class is provided since Java 8.
		// Its object may hold a value or may not.
		User foundPatient = null;
		Optional<User> opt = userRepoRef.findById(uId);
		if (!opt.isEmpty())
			foundPatient = opt.get();// Getting the User object from that Optional object
		return foundPatient;

//		return patientRepoRef.findById(id).orElseThrow(() -> new PatientHandlingException("Invalid User id!!"));
	}

	public User updatedUser(User existingUser, User updatedUser) {

		existingUser.setfName(updatedUser.getfName());
		existingUser.setlName(updatedUser.getlName());
		existingUser.setQue(updatedUser.getQue());
		existingUser.setAns(updatedUser.getAns());
		existingUser.setDob(updatedUser.getDob());

		return userRepoRef.save(existingUser);
	}

	public void deleteOnePatient(Integer uId) {
		userRepoRef.deleteById(uId);
	}

	public void updatePassword(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepoRef.save(user);
	}

}
