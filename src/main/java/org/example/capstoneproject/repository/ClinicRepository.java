package org.example.capstoneproject.repository;

import org.example.capstoneproject.entity.Clinic;
import org.example.capstoneproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface ClinicRepository extends JpaRepository<Clinic,Integer> {
     Optional<Clinic> findByUser(User user);

     @Query(value = "select * from clinics where name like :name",nativeQuery = true)
     List<Clinic> findByClinicName(@Param("name") String name);
}
