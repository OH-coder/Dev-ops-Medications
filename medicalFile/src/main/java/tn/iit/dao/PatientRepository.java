package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iit.entity.Patient;


public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findById(int id);

    Patient findByNameIgnoreCase(String patient);

}
