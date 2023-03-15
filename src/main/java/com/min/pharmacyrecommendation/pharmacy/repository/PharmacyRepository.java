package com.min.pharmacyrecommendation.pharmacy.repository;

import com.min.pharmacyrecommendation.pharmacy.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
}
