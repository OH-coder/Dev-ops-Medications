package tn.iit.controller;

import java.net.URI;
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
    
    // Get all dossier GET /api/dosseirs
    @GetMapping(value="/dossiers")
    List<Dossier> getAll(){
        return dossierService.getAllDossiers();
    }
    
    // Get single dossier by ID  GET /api/dossiers/{id}
    @GetMapping(value="/dossiers/{id}")
    ResponseEntity<Dossier> getById(@PathVariable("id") int id) {
        Dossier dos = dossierService.findById(id)
                                    .orElseThrow(()->new DossierNotFoundException("No Dossier with ID : "+id));
        return ResponseEntity.ok().body(dos);
    }
    
    // Create new dossier POST /api/dossiers
    @PostMapping(value="/dossiers")
    ResponseEntity<?> createDossier(@RequestBody DossierDTO indos) {
        Dossier dos      = DossierMapper.DtoToEntity(indos);
        Dossier addeddos = dossierService.save(dos);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                        .path("/{id}")
                                        .buildAndExpand(addeddos.getId_dossier())
                                        .toUri();
        return ResponseEntity.created(location).build();
    }
    
    
    // Update dossier PUT /api/dossier/{id}
    @PutMapping(value="/dossiers/{id}")
    ResponseEntity<Dossier> updateDossier(@PathVariable("id") int id,  @RequestBody DossierDTO indos) {
        Dossier dos = dossierService.findById(id)
                                    .orElseThrow(()->new DossierNotFoundException("No Dossier with ID : "+id));
        
        Dossier newdos = DossierMapper.DtoToEntity(indos);
        newdos.setId_dossier(dos.getId_dossier());
        dossierService.save(newdos);
        return ResponseEntity.ok().body(newdos);    
    }
    
    
    // Delete dossier by ID DELETE /api/dossiers/{id}
    @DeleteMapping(value="/dossiers/{id}")
    ResponseEntity deleteDossier( @PathVariable("id") int id) {
        Dossier dos = dossierService.findById(id)
                                    .orElseThrow(()->new DossierNotFoundException("No Dossier with ID : "+id));
        dossierService.delete(dos.getId_dossier());
        return ResponseEntity.ok().body("Dossier with ID : "+id+" deleted with success!");  
    }
}
