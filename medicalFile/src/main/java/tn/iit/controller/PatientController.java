package tn.iit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tn.iit.dto.PatientDTO;
import tn.iit.service.PatientService;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientService patientService;


    @GetMapping(value = "/patients")
    Collection<PatientDTO> getAll() {
        return patientService.getAllDossiers();
    }


    @GetMapping(value = "/patients/{id}")
    ResponseEntity<PatientDTO> getById(@PathVariable("id") int id) {
        PatientDTO dos = patientService.findById(id);
        return ResponseEntity.ok().body(dos);
    }


    @PostMapping(value = "/patients")
    ResponseEntity<?> createDossier(@RequestBody PatientDTO indos) {
        PatientDTO addeddos = patientService.save(indos);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addeddos.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @PutMapping(value = "/patients/{id}")
    ResponseEntity<PatientDTO> updateDossier(@PathVariable("id") int id, @RequestBody PatientDTO indos) {
        indos.setId(id);
        PatientDTO resultdos = patientService.update(indos);
        return ResponseEntity.ok().body(resultdos);
    }


    @DeleteMapping(value = "/patients/{id}")
    ResponseEntity deleteDossier(@PathVariable("id") int id) {
        patientService.delete(id);
        return ResponseEntity.ok().body("Patient with ID : " + id + " deleted with success!");
    }
}
