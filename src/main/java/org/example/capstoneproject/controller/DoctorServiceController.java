package org.example.capstoneproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.capstoneproject.dto.request.DoctorServiceInfo;
import org.example.capstoneproject.service.DoctorServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/doctor/service")
@RequiredArgsConstructor
public class DoctorServiceController {
    private final DoctorServiceService doctorServiceService;
    @PostMapping("/{doctorId}/{serviceId}")
    public ResponseEntity<?> addService(@PathVariable Integer doctorId,
                                        @PathVariable Integer serviceId,
                                        @RequestBody DoctorServiceInfo doctorServiceInfo){
       return doctorServiceService.addService(doctorId,serviceId,doctorServiceInfo);
    }
}
