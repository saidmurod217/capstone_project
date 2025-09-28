package org.example.capstoneproject.repository;

import org.example.capstoneproject.entity.MedicalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalServiceRepository extends JpaRepository<MedicalService,Integer> {

}
