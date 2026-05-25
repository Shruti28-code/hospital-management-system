package com.hospital.controller;

import com.hospital.entity.Patient;
import com.hospital.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin("*")
public class PatientController {

    private final PatientRepository repository;

    public PatientController(PatientRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Patient> getPatients() {
        return repository.findAll();
    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return repository.save(patient);
    }
}