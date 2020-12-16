package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.entity.Dossier;


public interface DossierRepository extends JpaRepository<Dossier, Integer> {

}
