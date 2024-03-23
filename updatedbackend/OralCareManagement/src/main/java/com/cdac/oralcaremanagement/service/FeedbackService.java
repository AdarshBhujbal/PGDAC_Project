package com.cdac.oralcaremanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.oralcaremanagement.dao.IfeedbackRepository;
import com.cdac.oralcaremanagement.entity.Feedback;

@Service
public class FeedbackService {

	@Autowired
	private IfeedbackRepository feedbackRepo;
	
	public String saveFeedback(Feedback feedback) {
		
		feedbackRepo.save(feedback);
		return "feedback saved";
	}
}
