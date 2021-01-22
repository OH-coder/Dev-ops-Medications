package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.entity.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Integer>{
	Medication findById(int id);
}
