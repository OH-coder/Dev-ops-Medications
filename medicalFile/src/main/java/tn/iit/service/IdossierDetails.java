package tn.iit.service;

import java.util.List;
import java.util.Optional;
import tn.iit.entity.Dossier;
import tn.iit.entity.DossierDetails;

public interface IdossierDetails {
	List<DossierDetails> getAllDossierDetails();
    Optional<DossierDetails> findById(int id);
    DossierDetails save(DossierDetails dos);
    void delete(int id);
}
