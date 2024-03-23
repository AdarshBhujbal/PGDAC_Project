package com.cdac.oralcaremanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.oralcaremanagement.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
