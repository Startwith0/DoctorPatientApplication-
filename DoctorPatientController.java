package com.example.doctorpatientsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class DoctorPatientController {

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientRepo.save(patient);
    }

    @GetMapping("/suggest-doctors/{patientId}")
    public List<Doctor> suggestDoctors(@PathVariable Long patientId) {
        Patient patient = patientRepo.findById(patientId).orElse(null);
        if (patient == null) return new ArrayList<>();

        String specialty = switch (patient.getSymptom()) {
            case "Arthritis", "Back Pain", "Tissue injuries" -> "Orthopaedic";
            case "Dysmenorrhea" -> "Gynecology";
            case "Skin infection", "Skin burn" -> "Dermatology";
            case "Ear pain" -> "ENT";
            default -> null;
        };

        if (specialty == null) return new ArrayList<>();

        return doctorRepo.findByCityAndSpecialty(patient.getCity(), specialty);
    }
}
