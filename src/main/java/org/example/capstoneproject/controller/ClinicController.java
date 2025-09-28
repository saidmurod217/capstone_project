package org.example.capstoneproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.capstoneproject.dto.request.ClinicRequest;
import org.example.capstoneproject.dto.response.ClinicResponse;
import org.example.capstoneproject.entity.Clinic;
import org.example.capstoneproject.service.ClinicService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clinics")
@RequiredArgsConstructor
public class ClinicController {
    private final ClinicService clinicService;

    @PostMapping("/create")
    public ResponseEntity<?> createOrUpdateClinic(ClinicRequest clinicRequest){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return clinicService.createOrUpdateClinic(clinicRequest,username);
    }
    @PostMapping("/doctorToClinic")
    public ResponseEntity<?> addDoctorToClinic(String doctorName){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return clinicService.addDoctorToClinic(username,doctorName);
    }
    @GetMapping
    public List<?> getClinics(){
        return clinicService.getAllClinics();
    }
    @GetMapping("/{name}")
    public ResponseEntity<?> getClinicByName(@PathVariable String name){
        System.out.println(name);
        List<ClinicResponse> clinicResponse = clinicService.findByClinicName(name+"%");
        if (clinicResponse == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(clinicResponse);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteById(Integer id){
        return clinicService.deleteById(id);
    }
}
