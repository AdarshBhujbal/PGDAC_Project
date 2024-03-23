package com.cdac.oralcaremanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.oralcaremanagement.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
