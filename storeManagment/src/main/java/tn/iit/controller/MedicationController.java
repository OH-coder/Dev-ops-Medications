package tn.iit.controller;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tn.iit.dto.MedicationDTO;
import tn.iit.exception.MedicationNotFoundException;
import tn.iit.service.MedicationService;

@RestController
@RequestMapping("/api")
public class MedicationController {
    
    @Autowired
    private MedicationService medicationService;
    

    @GetMapping(value= "/medications")
    Collection<MedicationDTO> getAll(){
        return medicationService.getAllArticles();
    }
    

    @GetMapping(value= "/medications/{id}")
    ResponseEntity<MedicationDTO> getById(@PathVariable("id") int id) {
        MedicationDTO med = medicationService.findById(id);
        return ResponseEntity.ok().body(med);
    }
    

    @PostMapping(value= "/medications")
    ResponseEntity<?> createMedication(@RequestBody MedicationDTO medDTO) {
        MedicationDTO addedMed = medicationService.save(medDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                        .path("/{id}")
                                        .buildAndExpand(addedMed.getId())
                                        .toUri();
        return ResponseEntity.created(location).build();
    }
    
    
    @PutMapping(value= "/medications/{id}")
    ResponseEntity<MedicationDTO> updateArticle(@PathVariable("id") int id, @RequestBody MedicationDTO medDTO) {
    	medDTO.setId(id);
    	MedicationDTO resultdos = medicationService.update(medDTO);
        return ResponseEntity.ok().body(resultdos);    
    }
    
    
    @DeleteMapping(value= "/medications/{id}")
    ResponseEntity deleteMedication( @PathVariable("id") int id) {
        medicationService.delete(id);
        return ResponseEntity.ok().body("Medication with ID : "+id+" deleted with success!");
    }
}
