package org.example.capstoneproject.repository;

import org.example.capstoneproject.entity.Clinic;
import org.example.capstoneproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic,Integer> {
     Optional<Clinic> findByUser(User user);

     @Query(value = "select * from clinics where name like :name",nativeQuery = true)
     List<Clinic> findByClinicName(@Param("name") String name);
}
