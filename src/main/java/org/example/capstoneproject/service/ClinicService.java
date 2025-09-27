package org.example.capstoneproject.service;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.example.capstoneproject.dto.request.ClinicRequest;
import org.example.capstoneproject.dto.response.ClinicResponse;
import org.example.capstoneproject.dto.response.DoctorSummary;
import org.example.capstoneproject.entity.Clinic;
import org.example.capstoneproject.entity.Doctor;
import org.example.capstoneproject.entity.User;
import org.example.capstoneproject.repository.ClinicRepository;
import org.example.capstoneproject.repository.DoctorRepository;
import org.example.capstoneproject.repository.UserRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
@RequiredArgsConstructor
public class ClinicService {
    private final ClinicRepository clinicRepository;
    private final UserRepository userRepository;
    private final RestTemplateBuilder restTemplateBuilder;
    private final DoctorRepository doctorRepository;

    public ResponseEntity<?> createOrUpdateClinic(ClinicRequest clinicRequest,String username){
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty())
            return ResponseEntity.badRequest().build();

        Clinic clinic = clinicRepository.findByUser(user.get()).orElse(new Clinic());
        clinic.setUser(user.get());
        clinic.setAbout(clinicRequest.getAbout());
        clinic.setAddress(clinicRequest.getAddress());
        clinic.setName(clinicRequest.getName());
        clinic.setImage(clinicRequest.getImage());
        clinic.setPhone(clinicRequest.getPhone());
        clinic.setRating(clinicRequest.getRating());
        clinic.setWeblink(clinicRequest.getWeblink());
        clinic.setCertification(clinicRequest.getCertification());
        clinicRepository.save(clinic);
        return ResponseEntity.ok(clinicMapper(clinic));
    }
    public ResponseEntity<?> addDoctorToClinic(String clinicOwnerUsername, String doctorUsername) {
        User owner = userRepository.findByUsername(clinicOwnerUsername)
                .orElseThrow(() -> new IllegalArgumentException("Owner not found"));

        Clinic clinic = clinicRepository.findByUser(owner)
                .orElseThrow(() -> new IllegalArgumentException("Clinic not found for owner"));

        User doctorUser = userRepository.findByUsername(doctorUsername)
                .orElseThrow(() -> new IllegalArgumentException("Doctor user not found"));

        Doctor doctor = doctorRepository.findByUser(doctorUser)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

        clinic.addDoctor(doctor);
        clinicRepository.save(clinic);

        return ResponseEntity.ok(clinicMapper(clinic));
    }
    public List<ClinicResponse> getAllClinics(){
        List<Clinic> clinics = clinicRepository.findAll();
        return clinics.stream().map(this::clinicMapper).toList();
    }
    public List<ClinicResponse> findByClinicName(String name){
        List<Clinic> clinic = clinicRepository.findByClinicName(name);
        if(clinic.isEmpty())
            return null;
        return clinic.stream().map(this::clinicMapper).toList();
    }
    public ClinicResponse clinicMapper(Clinic clinic){
        return new ClinicResponse(
                clinic.getId(),
                clinic.getName(),
                clinic.getAbout(),
                clinic.getCertification(),
                clinic.getAddress(),
                clinic.getPhone(),
                clinic.getWeblink(),
                clinic.getRating(),
                clinic.getImage(),
                clinic.getDoctors().stream().map(d -> new DoctorSummary(d.getId(),d.getName(),d.getExperience(),d.getAbout(),d.getRating())).toList()
        );
    }

}
