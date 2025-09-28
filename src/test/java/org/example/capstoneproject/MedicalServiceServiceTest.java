package org.example.capstoneproject;

import org.example.capstoneproject.entity.MedicalService;
import org.example.capstoneproject.repository.MedicalServiceRepository;
import org.example.capstoneproject.service.MedicalServiceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MedicalServiceServiceTest {

    @Mock
    private MedicalServiceRepository medicalServiceRepository;

    @InjectMocks
    private MedicalServiceService medicalServiceService;

    @Test
    void testFindById_returnsMedicalService() {
        MedicalService mockEntity =
                new MedicalService(1, "General Checkup", "Routine health examination for overall wellness");

        when(medicalServiceRepository.findById(1)).thenReturn(Optional.of(mockEntity));

        Optional<MedicalService> result = medicalServiceService.findById(1);

        assertTrue(result.isPresent(), "Expected a MedicalService to be present");
        assertEquals("General Checkup", result.get().getName());
        assertEquals("Routine health examination for overall wellness", result.get().getDescription());

        verify(medicalServiceRepository, times(1)).findById(1);
        verifyNoMoreInteractions(medicalServiceRepository);
    }
}
