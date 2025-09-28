package org.example.capstoneproject.controller;

import lombok.AllArgsConstructor;
import org.example.capstoneproject.dto.request.MedicalServiceRequest;
import org.example.capstoneproject.entity.MedicalService;
import org.example.capstoneproject.service.MedicalServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical/service")
@AllArgsConstructor
public class MedicalServiceController {
    private final MedicalServiceService medicalServiceService;
    @PostMapping
    public ResponseEntity<?> createMedicalService(@RequestBody MedicalServiceRequest medicalService){
        return medicalServiceService.createMedicalService(medicalService);
    }
    @GetMapping
    public List<MedicalService> getAllMedicalServices(){
       return medicalServiceService.getAllMedicalServices();
    }
}
