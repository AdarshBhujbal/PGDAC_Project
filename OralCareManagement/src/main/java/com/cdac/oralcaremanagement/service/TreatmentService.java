package com.cdac.oralcaremanagement.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.oralcaremanagement.dao.TreatmentRepository;
import com.cdac.oralcaremanagement.entity.Treatment;

@Service
public class TreatmentService {

	@Autowired
	private TreatmentRepository treatmentRepoRef;

	public void addNewTreatment(Treatment treatmentRef) {

		treatmentRepoRef.save(treatmentRef);
	}

	public void deleteOneTreatment(long tId) {
		treatmentRepoRef.deleteById(tId);
	}

	public Collection<Treatment> getAllTreatment() {

		Collection<Treatment> allTreatment = treatmentRepoRef.findAll();
		return allTreatment;
	}

	public Treatment getOneTreatment(long tId) {
		//Optional class is provided since Java 8.
		//Its object may hold a value or may not.
		Treatment foundTreatment = null;
		Optional<Treatment> opt = treatmentRepoRef.findById(tId);
		if(!opt.isEmpty())
			foundTreatment = opt.get();//Getting the Movie object from that Optional object
		return foundTreatment;
	}
	
	public Treatment updateTreatment(Treatment existingTreatment, Treatment updatedTreatment) {
		existingTreatment.setDescription(updatedTreatment.getDescription());
		existingTreatment.setName(updatedTreatment.getName());
		existingTreatment.setPrice(updatedTreatment.getPrice());

		return treatmentRepoRef.save(existingTreatment);
	}
}
