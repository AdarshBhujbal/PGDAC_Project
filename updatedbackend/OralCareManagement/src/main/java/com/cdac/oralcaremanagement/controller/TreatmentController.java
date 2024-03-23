package com.cdac.oralcaremanagement.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.oralcaremanagement.entity.Treatment;
import com.cdac.oralcaremanagement.service.TreatmentService;

@RestController
@RequestMapping("/treatment")
@CrossOrigin("*")
public class TreatmentController {

	@Autowired
	private TreatmentService treatmentServiceRef;

	// http://localhost:8000/treatment/newTreatment
	@PostMapping("/newTreatment")
	public void addNewTreament(@RequestBody Treatment treatmentRef) {
		System.out.println(treatmentRef);
		treatmentServiceRef.addNewTreatment(treatmentRef);
	}

	// http://localhost:8000/treatment/getTreatments
	@GetMapping("/getTreatments")
	public Collection<Treatment> getAllTreatment() {
		Collection<Treatment> allTreatment = treatmentServiceRef.getAllTreatment();
		return allTreatment;
	}

	// http://localhost:8000/treatment/getTreatment/1
	@GetMapping("/getTreament/{tId}")
	public Treatment getOneTreament(@PathVariable("tId") long tId) {
		Treatment foundTreament = treatmentServiceRef.getOneTreatment(tId);
		// System.out.println("The found treatment is: " + foundTeatment);
		return foundTreament;
	}

	// http://localhost:8000/treatment/updateTreatment/tId
	@PutMapping("/updateTreatment/{tId}") // to update existing assessment
	public Treatment updateById(@RequestBody Treatment updatedTreatment, @PathVariable long tId) {
		Treatment existingTreatment = treatmentServiceRef.getOneTreatment(tId);
		return treatmentServiceRef.updateTreatment(existingTreatment, updatedTreatment);
	}
	
	// http://localhost:8000/treatment/deleteTreatment/tId
	@DeleteMapping("/deleteTreatment/{tId}")
	public void deleteOneTreatment(@PathVariable("tId") long tId) {
		treatmentServiceRef.deleteOneTreatment(tId);
	}


}
