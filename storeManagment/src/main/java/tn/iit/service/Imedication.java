package tn.iit.service;

import java.util.Collection;
import tn.iit.dto.MedicationDTO;

public interface Imedication {
	Collection<MedicationDTO> getAllArticles();
	MedicationDTO findById(int id);
    MedicationDTO save(MedicationDTO art);
    MedicationDTO update(MedicationDTO art);
    void delete(int id);
}
