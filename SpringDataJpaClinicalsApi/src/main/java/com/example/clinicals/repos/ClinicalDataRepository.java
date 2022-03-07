package com.example.clinicals.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clinicals.model.ClinicalData;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer> {

}
