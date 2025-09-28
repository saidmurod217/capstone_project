package org.example.capstoneproject.repository;

import org.example.capstoneproject.entity.DoctorService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorServiceRepository extends JpaRepository<DoctorService, Integer> {
}
