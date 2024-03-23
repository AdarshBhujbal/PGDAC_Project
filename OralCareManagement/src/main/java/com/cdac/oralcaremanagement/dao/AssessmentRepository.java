package com.cdac.oralcaremanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.oralcaremanagement.entity.Assessment;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {

}
