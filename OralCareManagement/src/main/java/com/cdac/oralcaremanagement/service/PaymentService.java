package com.cdac.oralcaremanagement.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.oralcaremanagement.dao.PaymentRepository;
import com.cdac.oralcaremanagement.entity.Payment;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository PaymentRepoRef;
	
	public void addNewPayment(Payment paymentRef) {
		PaymentRepoRef.save(paymentRef);
		
	}
	
	public Collection<Payment> getAllPayments(){
		
		Collection<Payment> getAllPayments = PaymentRepoRef.findAll();
		return getAllPayments;
	}
	
	
	public Payment getOnePayment(long pId) {
		//Optional class is provided since Java 8.
		//Its object may hold a value or may not.
		Payment foundPayment = null;
		Optional<Payment> opt = PaymentRepoRef.findById(pId);
		if(!opt.isEmpty())
			foundPayment = opt.get();//Getting the Movie object from that Optional object
		return foundPayment;
	}
	
	
	public Payment updatePayment(Payment existingPayment , Payment updatedPayment) {
		existingPayment.setDate(updatedPayment.getDate()); 
		existingPayment.setAmount(updatedPayment.getAmount());
		
		return PaymentRepoRef.save(existingPayment);
	}
	
	
	public void deleteOnePayment (long id) {
		PaymentRepoRef.deleteById(null);
	}

}
