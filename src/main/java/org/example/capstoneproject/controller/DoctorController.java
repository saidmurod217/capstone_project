package org.example.capstoneproject.controller;


import lombok.RequiredArgsConstructor;
import org.example.capstoneproject.dto.request.DoctorRequest;
import org.example.capstoneproject.entity.Doctor;
import org.example.capstoneproject.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping("/profile")
    public ResponseEntity<?> createOrUpdateDoctor(DoctorRequest doctorRequest){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return doctorService.createOrUpdateDoctor(doctorRequest,username);
    }

    @GetMapping
    public List<?> getAllDoctors(){
        return doctorService.getAllDoctors();
    }


}
