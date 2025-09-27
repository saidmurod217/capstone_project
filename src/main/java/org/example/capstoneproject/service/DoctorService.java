package org.example.capstoneproject.service;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.capstoneproject.dto.request.DoctorRequest;
import org.example.capstoneproject.dto.response.ClinicSummary;
import org.example.capstoneproject.dto.response.DoctorResponse;
import org.example.capstoneproject.entity.Doctor;
import org.example.capstoneproject.entity.User;
import org.example.capstoneproject.repository.DoctorRepository;
import org.example.capstoneproject.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;

    public ResponseEntity<?> createOrUpdateDoctor(DoctorRequest doctorRequest, String username){
        Optional<User> user  = userRepository.findByUsername(username);
        if(user.isEmpty())
            return ResponseEntity.badRequest().body("User not found");
        Doctor doctor = doctorRepository.findByUser(user.get()).orElse(new Doctor());
                doctor.setName(doctorRequest.getName());
                doctor.setAbout(doctorRequest.getAbout());
                doctor.setExperience(doctorRequest.getExperience());
                doctor.setRating(doctorRequest.getRating());
                doctor.setUser(user.get());

        doctorRepository.save(doctor);
        return ResponseEntity.ok(doctorMapper(doctor));
    }
    public List<DoctorResponse> getAllDoctors(){
        return doctorRepository.findAll().stream().map(this::doctorMapper).toList();
    }

    public DoctorResponse doctorMapper(Doctor doctor){
        return new DoctorResponse(
                doctor.getId(),
                doctor.getName(),
                doctor.getExperience(),
                doctor.getAbout(),
                doctor.getRating(),
                doctor.getClinic().stream().map(c -> new ClinicSummary(c.getName(),c.getAddress(),c.getWeblink(),c.getPhone())).toList()
        );
    }

}
