package org.example.capstoneproject.repository;

import org.example.capstoneproject.entity.Doctor;
import org.example.capstoneproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    Optional<Doctor> findByUser(User user);
}
