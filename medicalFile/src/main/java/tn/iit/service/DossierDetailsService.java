package tn.iit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.dao.DossierDetailsRepository;
import tn.iit.entity.DossierDetails;


@Service
public class DossierDetailsService implements IdossierDetails {
    @Autowired
    private DossierDetailsRepository dossierDetailsRepository;
    @Override
    public List<DossierDetails> getAllDossierDetails() {
        return dossierDetailsRepository.findAll();
    }
    @Override
    public Optional<DossierDetails> findById(int id) {
        return dossierDetailsRepository.findById(id);
    }
    @Override
    public DossierDetails save(DossierDetails dos) {
        return dossierDetailsRepository.save(dos);
    }
    @Override
    public void delete(int id) {
    	dossierDetailsRepository.deleteById(id);
    }
}