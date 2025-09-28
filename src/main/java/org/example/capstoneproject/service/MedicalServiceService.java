package org.example.capstoneproject.service;

import lombok.RequiredArgsConstructor;
import org.example.capstoneproject.dto.request.MedicalServiceRequest;
import org.example.capstoneproject.entity.MedicalService;
import org.example.capstoneproject.repository.MedicalServiceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicalServiceService {
    private final MedicalServiceRepository medicalServiceRepository;

    public ResponseEntity<?> createMedicalService(MedicalServiceRequest medicalService){
        if(medicalService == null)
            return ResponseEntity.badRequest().build();
        MedicalService medicalService1 = MedicalService.builder()
                .name(medicalService.getName())
                .description(medicalService.getDescription())
                .build();
        medicalServiceRepository.save(medicalService1);
        return ResponseEntity.ok(medicalService1);
    }
    public List<MedicalService> getAllMedicalServices(){
        return medicalServiceRepository.findAll();
    }
    public Optional<MedicalService> findById(Integer medicalServiceId){
        return medicalServiceRepository.findById(medicalServiceId);
    }
}
