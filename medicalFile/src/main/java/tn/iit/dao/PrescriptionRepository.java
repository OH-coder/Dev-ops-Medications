package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iit.entity.Prescription;


public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
	Prescription findById(int id);
}
