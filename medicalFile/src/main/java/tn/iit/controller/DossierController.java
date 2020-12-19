package tn.iit.controller;

import java.net.URI;
import java.util.Collection;
import java.util.List;

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

import tn.iit.dto.DossierDTO;
import tn.iit.entity.Dossier;
import tn.iit.exception.DossierNotFoundException;
import tn.iit.mapper.DossierMapper;
import tn.iit.service.DossierService;

@RestController
@RequestMapping("/api")
public class DossierController {
    
    @Autowired
    private DossierService dossierService;
    

    @GetMapping(value="/dossiers")
    Collection<DossierDTO> getAll(){
        return dossierService.getAllDossiers();
    }
    

    @GetMapping(value="/dossiers/{id}")
    ResponseEntity<DossierDTO> getById(@PathVariable("id") int id) {
        DossierDTO dos = dossierService.findById(id);
        return ResponseEntity.ok().body(dos);
    }
    

    @PostMapping(value="/dossiers")
    ResponseEntity<?> createDossier(@RequestBody DossierDTO indos) {
        DossierDTO addeddos = dossierService.save(indos);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                        .path("/{id}")
                                        .buildAndExpand(addeddos.getId())
                                        .toUri();
        return ResponseEntity.created(location).build();
    }
    
    
    @PutMapping(value="/dossiers/{id}")
    ResponseEntity<DossierDTO> updateDossier(@PathVariable("id") int id,  @RequestBody DossierDTO indos) {
    	indos.setId(id);  
        DossierDTO resultdos = dossierService.update(indos);
        return ResponseEntity.ok().body(resultdos);    
    }
    
    
    @DeleteMapping(value="/dossiers/{id}")
    ResponseEntity deleteDossier( @PathVariable("id") int id) {
        dossierService.delete(id);
        return ResponseEntity.ok().body("Dossier with ID : "+id+" deleted with success!");  
    }
}
