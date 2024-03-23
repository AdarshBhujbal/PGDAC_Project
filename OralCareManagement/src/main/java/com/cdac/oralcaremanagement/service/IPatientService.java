package com.cdac.oralcaremanagement.service;

import java.util.List;

import com.cdac.oralcaremanagement.entity.User;

public interface IPatientService {

	//register User
		User addNewPatient(User user);
		 //     (classname object)

		
		//get User
		List<User> getPatients();
		
		
		//get specific patient
		User getPatient(String pId);
		
		
		//delete specific patient
		String deletePatient(String pId);
		
		//update Specific patient
		User updatePatient(User updatedPatient, User existingPatient);
	}
