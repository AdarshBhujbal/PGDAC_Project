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

import com.cdac.oralcaremanagement.entity.Assessment;
import com.cdac.oralcaremanagement.service.AssessmentService;

@RestController
@RequestMapping("/assessment")
@CrossOrigin("*")
public class AssessmentController {

	@Autowired
	private AssessmentService assessmentServiceRef;

	// http://localhost:8000/assessment/addAssessment
	@PostMapping("/addAssessment")
	public void addNewAssessment(@RequestBody Assessment assessmentRef) {
		System.out.println(assessmentRef);
		assessmentServiceRef.addNewAssessment(assessmentRef);
	}

	// http://localhost:8000/assessment/getAssessment

	@GetMapping("/getAssessments")
	public Collection<Assessment> getAllAssessments() {

		Collection<Assessment> allAssesssments = assessmentServiceRef.getAllAssessments();
		return allAssesssments;
	}

	// http://localhost:8000/assessment/getAssessment/assmntId
	@GetMapping("/getAssessment/{assmntId}")
	public Assessment getOneAssessment(@PathVariable("assmntId") long assmntId) {
		Assessment foundAssessment = assessmentServiceRef.getOneAssessment(assmntId);
		return foundAssessment;
	}

	// http://localhost:8000/assessment/updateAssessment/
	@PutMapping("/updateAssessment/{assmntId}") // to update existing assessment
	public Assessment updateById(@RequestBody Assessment updatedAssessment, @PathVariable long assmntId) {
		Assessment existingAssessment = assessmentServiceRef.getOneAssessment(assmntId);
		return assessmentServiceRef.updateAssessment(existingAssessment, updatedAssessment);
	}

	// http://localhost:8000/assessment/getAssessment/assmntId
	@DeleteMapping("/deleteAssessment/{assmntId}")
	public void deleteOneAssessment(@PathVariable("assmntId") long assmntId) {

		assessmentServiceRef.deleteOneUser(assmntId);
	}

}
