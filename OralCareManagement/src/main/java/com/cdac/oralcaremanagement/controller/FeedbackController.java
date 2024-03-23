package com.cdac.oralcaremanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.oralcaremanagement.entity.Feedback;
import com.cdac.oralcaremanagement.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
@CrossOrigin("*")
public class FeedbackController {
	@Autowired
	private FeedbackService feedbackService;

	// http://localhost:8000/feedback/saveFeedback
	@PostMapping("/saveFeedback")
	public void saveFeedback(@RequestBody Feedback feedback) {
		feedbackService.saveFeedback(feedback);
	}
}
