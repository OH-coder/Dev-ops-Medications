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

import tn.iit.dto.DossierDetailsDTO;
import tn.iit.entity.DossierDetails;
import tn.iit.exception.DossierDetailsNotFoundException;
import tn.iit.mapper.DossierDetailsMapper;
import tn.iit.service.DossierDetailsService;

@RestController
@RequestMapping("/api")
public class DossierDetailsController {
    
    @Autowired
    private DossierDetailsService dossierDetailsService;
    
    // Get all dossierdetails GET /api/dossierdetails
    @GetMapping(value="/dossierdetails")
    List<DossierDetails> getAll(){
        return dossierDetailsService.getAllDossierDetails();
    }
    
    // Get single dossierdetails by ID  GET /api/dossierdetails/{id}
    @GetMapping(value="/dossierdetails/{id}")
    ResponseEntity<DossierDetails> getById(@PathVariable("id") int id) {
        DossierDetails dos = dossierDetailsService.findById(id)
                                    .orElseThrow(()->new DossierDetailsNotFoundException("No Dossier Details with ID : "+id));
        return ResponseEntity.ok().body(dos);
    }
    
    // Create new dossierdetails POST /api/dossierdetails
    @PostMapping(value="/dossierdetails")
    ResponseEntity<?> createDossierDetails(@RequestBody DossierDetailsDTO indos) {
        DossierDetails dos      = DossierDetailsMapper.DtoToEntity(indos);
        DossierDetails addeddos = dossierDetailsService.save(dos);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                        .path("/{id}")
                                        .buildAndExpand(addeddos.getId_dossierdetails())
                                        .toUri();
        return ResponseEntity.created(location).build();
    }
    
    
    // Update dossierdetails PUT /api/dossierdetails/{id}
    @PutMapping(value="/dossierdetails/{id}")
    ResponseEntity<DossierDetails> updateDossierDetails(@PathVariable("id") int id,  @RequestBody DossierDetailsDTO indos) {
        DossierDetails dos = dossierDetailsService.findById(id)
                                    .orElseThrow(()->new DossierDetailsNotFoundException("No Dossier Details with ID : "+id));
        
        DossierDetails newdos = DossierDetailsMapper.DtoToEntity(indos);
        newdos.setId_dossierdetails(dos.getId_dossierdetails());
        dossierDetailsService.save(newdos);
        return ResponseEntity.ok().body(newdos);    
    }
    
    
    // Delete dossier by ID DELETE /api/dossierdetails/{id}
    @DeleteMapping(value="/dossierdetails/{id}")
    ResponseEntity deleteDossierDetails( @PathVariable("id") int id) {
        DossierDetails dos = dossierDetailsService.findById(id)
                                    .orElseThrow(()->new DossierDetailsNotFoundException("No Dossier Details with ID : "+id));
        dossierDetailsService.delete(dos.getId_dossierdetails());
        return ResponseEntity.ok().body("Dossier Details with ID : "+id+" deleted with success!");  
    }
}
