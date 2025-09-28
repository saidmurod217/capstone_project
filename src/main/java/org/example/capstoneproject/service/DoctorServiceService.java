package org.example.capstoneproject.service;

import lombok.RequiredArgsConstructor;
import org.example.capstoneproject.dto.request.DoctorServiceInfo;
import org.example.capstoneproject.dto.response.DoctorServiceResponse;
import org.example.capstoneproject.dto.response.DoctorSummary;
import org.example.capstoneproject.entity.Doctor;
import org.example.capstoneproject.entity.DoctorService;
import org.example.capstoneproject.entity.MedicalService;
import org.example.capstoneproject.repository.DoctorRepository;
import org.example.capstoneproject.repository.DoctorServiceRepository;
import org.example.capstoneproject.repository.MedicalServiceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorServiceService {
    private final DoctorServiceRepository doctorServiceRepository;
    private final MedicalServiceRepository medicalServiceRepository;
    private final DoctorRepository doctorRepository;
    public ResponseEntity<?> addService(Integer doctorId, Integer medicalServiceId, DoctorServiceInfo doctorServiceInfo) {
        Optional<MedicalService> medicalService = medicalServiceRepository.findById(medicalServiceId);
        if(medicalService.isEmpty())
            return ResponseEntity.badRequest().build();
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if(doctor.isEmpty())
            return ResponseEntity.badRequest().build();
        DoctorService doctorService = DoctorService.builder()
                .price(doctorServiceInfo.getPrice())
                .durationMinutes(doctorServiceInfo.getDurationMinutes())
                .doctor(doctor.get())
                .service(medicalService.get())
                .id(doctorId)
                .build();
        doctor.get().getServices().add(doctorService);
        doctorRepository.save(doctor.get());
        doctorServiceRepository.save(doctorService);
        DoctorSummary doctorSummary = DoctorSummary.builder()
                .about(doctor.get().getAbout())
                .name(doctor.get().getName())
                .experience(doctor.get().getExperience())
                .rating(doctor.get().getRating())
                .build();
        DoctorServiceResponse doctorServiceResponse = DoctorServiceResponse.builder()
                .price(doctorService.getPrice())
                .medicalService(doctorService.getService())
                .durationMinutes(doctorService.getDurationMinutes())
                .doctorSummary(doctorSummary)
                .build();
        return ResponseEntity.ok(doctorServiceResponse);
    }
}
