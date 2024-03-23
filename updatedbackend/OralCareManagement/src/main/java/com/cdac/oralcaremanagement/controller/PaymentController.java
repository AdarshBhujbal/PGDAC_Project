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

import com.cdac.oralcaremanagement.entity.Payment;
import com.cdac.oralcaremanagement.service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin("*")
public class PaymentController {

	@Autowired
	private PaymentService paymentServiceRef;

	// http://localhost:8000/payment/addPayment
	@PostMapping("/addPayment")
	public void addNewPayment(@RequestBody Payment paymentRef) {
		System.out.println(paymentRef);
		paymentServiceRef.addNewPayment(paymentRef);
	}

	// http://localhost:8000/payment/getPayments
	@GetMapping("/getPayments")
	public Collection<Payment> getAllPayments() {

		Collection<Payment> allPayments = paymentServiceRef.getAllPayments();
		return allPayments;
	}

	// http://localhost:8000/payment/getPayment/1
	@GetMapping("/getPayment/{pId}")
	public Payment getOnePayment(@PathVariable("pId") long pId) {
		Payment foundPayment = paymentServiceRef.getOnePayment(pId);
		return foundPayment;
	}

	//http://localhost:8000/payment/updatePayment/1
	@PutMapping("/updatePayment/{pId}") // to update existing payment
	public Payment updateById(@RequestBody Payment updatedPayment, @PathVariable long pId) {
		Payment existingPayment = paymentServiceRef.getOnePayment(pId);
		return paymentServiceRef.updatePayment(existingPayment, updatedPayment);
	}

	// http://localhost:8000/payment/deletePayment/pId
	@DeleteMapping("/deletePayment/{pId}")
	public void deleteOnePayment(@PathVariable("pId") long pId) {

		paymentServiceRef.deleteOnePayment(pId);
	}

}