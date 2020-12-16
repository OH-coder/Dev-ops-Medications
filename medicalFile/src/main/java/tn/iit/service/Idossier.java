package tn.iit.service;

import java.util.List;
import java.util.Optional;
import tn.iit.entity.Dossier;

public interface Idossier {
	List<Dossier> getAllDossiers();
    Optional<Dossier> findById(int id);
    Dossier save(Dossier dos);
    void delete(int id);
}
