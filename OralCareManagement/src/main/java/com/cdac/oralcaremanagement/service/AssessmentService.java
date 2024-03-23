package com.cdac.oralcaremanagement.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdac.oralcaremanagement.dao.AssessmentRepository;
import com.cdac.oralcaremanagement.entity.Assessment;


@Service
public class AssessmentService {
	
	@Autowired
	private AssessmentRepository assessmentRepoRef;
	
	public void addNewAssessment(Assessment assessmentRef) {
		assessmentRepoRef.save(assessmentRef);
		
	}
	
	public Collection<Assessment> getAllAssessments(){
		
		Collection<Assessment> getAllAssessments = assessmentRepoRef.findAll();
		return getAllAssessments;
	}
	
	
	public Assessment getOneAssessment(long assmntId) {
		//Optional class is provided since Java 8.
		//Its object may hold a value or may not.
		Assessment foundAssessment = null;
		Optional<Assessment> opt = assessmentRepoRef.findById(assmntId);
		if(!opt.isEmpty())
			foundAssessment = opt.get();//Getting the Movie object from that Optional object
		return foundAssessment;
	}
	
	
	public Assessment updateAssessment(Assessment existingAssessment, Assessment updatedAssessment) {
		existingAssessment.setDescription(updatedAssessment.getDescription());
		return assessmentRepoRef.save(existingAssessment);
	}
	
	
	public void deleteOneUser (long assmntId) {
		assessmentRepoRef.deleteById(null);
	}

}
