package com.cdac.oralcaremanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cdac.oralcaremanagement.entity.Treatment;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

}
