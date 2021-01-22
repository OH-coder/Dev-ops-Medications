package tn.iit.service;

import tn.iit.dto.PatientDTO;

import java.util.Collection;

public interface Ipatient {
	Collection<PatientDTO> getAllDossiers();

	PatientDTO findById(int id);

	PatientDTO save(PatientDTO dos);

	PatientDTO update(PatientDTO dos);

	void delete(int id);
}
