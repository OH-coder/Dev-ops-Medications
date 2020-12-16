package tn.iit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.dao.DossierRepository;
import tn.iit.entity.Dossier;


@Service
public class DossierService implements Idossier {
    @Autowired
    private DossierRepository dossierRepository;
    @Override
    public List<Dossier> getAllDossiers() {
        return dossierRepository.findAll();
    }
    @Override
    public Optional<Dossier> findById(int id) {
        return dossierRepository.findById(id);
    }
    @Override
    public Dossier save(Dossier dos) {
        return dossierRepository.save(dos);
    }
    @Override
    public void delete(int id) {
    	dossierRepository.deleteById(id);
    }
}