package tn.iit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tn.iit.dto.PrescriptionDTO;
import tn.iit.exception.MedicationNotFoundException;
import tn.iit.exception.PatientNotFoundException;
import tn.iit.service.PatientService;
import tn.iit.service.PrescriptionService;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/api")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private PatientService patientService;

    @GetMapping(value = "/prescriptions")
    Collection<PrescriptionDTO> getAll() {
        return prescriptionService.getAllDossierDetails();
    }


    @GetMapping(value = "/prescriptions/{id}")
    ResponseEntity<PrescriptionDTO> getById(@PathVariable("id") int id) {
        PrescriptionDTO dos = prescriptionService.findById(id);
        return ResponseEntity.ok().body(dos);
    }


    @PostMapping(value = "/prescriptions")
    ResponseEntity<?> createDossierDetails(@RequestBody PrescriptionDTO indos, @RequestParam String patient) throws PatientNotFoundException, MedicationNotFoundException {

        PrescriptionDTO addeddos = prescriptionService.save(indos, patient);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addeddos.getId_prescriptions())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @PutMapping(value = "/prescriptions/{id}")
    ResponseEntity<PrescriptionDTO> updateDossierDetails(@PathVariable("id") int id, @RequestBody PrescriptionDTO indos) {
        indos.setId_prescriptions(id);
        PrescriptionDTO resultdos = prescriptionService.update(indos);
        return ResponseEntity.ok().body(resultdos);
    }


    // Delete patient by ID DELETE /api/dossierdetails/{id}
    @DeleteMapping(value = "/prescriptions/{id}")
    ResponseEntity deleteDossierDetails(@PathVariable("id") int id) {
        prescriptionService.delete(id);
        return ResponseEntity.ok().body("Patient Details with ID : " + id + " deleted with success!");
    }
}
