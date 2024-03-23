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

import com.cdac.oralcaremanagement.entity.Appointment;
import com.cdac.oralcaremanagement.service.AppointmentService;


@RestController
@RequestMapping("/appointment")
@CrossOrigin("*")
public class AppointmentController {
	
	@Autowired
	private AppointmentService apptServiceref;
	
		//http://localhost:8000/appointment/addAppt
		@PostMapping("/addAppt")
		public Appointment addNewAppt(@RequestBody Appointment apptRef) {	
			System.out.println(apptRef);
			 return apptServiceref.addNewAppt(apptRef);
		}
		
		
		//http://localhost:8000/appointment/getAppts
		@GetMapping("/getAppts")
		public Collection<Appointment> getAllAppts(){
			Collection<Appointment> allAppts = apptServiceref.getAllAppts();
			return allAppts;
		}
		
		 //http://localhost:8000/appointment/getAppt/2
		@GetMapping("/getAppt/{apptId}")
		public Appointment getOneAppt(@PathVariable("apptId") Long apptId) {
			Appointment foundAppt = apptServiceref.getOneAppt(apptId);
			return foundAppt;
		}
		
	
		//http://localhost:8000/appointment/updateAppt/1
		@PutMapping("/updateAppt/{apptId}") // to update existing user
		public Appointment updateById(@RequestBody Appointment updatedAppt, @PathVariable Long apptId) {
		Appointment	existingAppt = apptServiceref.getOneAppt(apptId);
			return apptServiceref.updateAppt(existingAppt, updatedAppt);
		}
		
		
		//DELETE delete one appointment /getAppt/id
		@DeleteMapping("/deleteAppt/{apptId}")
		public void deleteOneAppt(@PathVariable("apptId") Long apptId) {
			apptServiceref.deleteOneAppt(apptId);
		}
}
