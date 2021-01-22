package tn.iit.service;

import tn.iit.dto.PrescriptionDTO;

import java.util.Collection;

public interface IPrescriptionDetails {
    Collection<PrescriptionDTO> getAllDossierDetails();

    PrescriptionDTO findById(int id);

    PrescriptionDTO save(PrescriptionDTO dos, String Patient);

    PrescriptionDTO update(PrescriptionDTO dos);

    void delete(int id);
}
