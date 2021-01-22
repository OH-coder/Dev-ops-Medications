package tn.iit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.dao.PatientRepository;
import tn.iit.dto.PatientDTO;
import tn.iit.entity.Patient;
import tn.iit.mapper.PatientMapper;

import java.util.Collection;


@Service
public class PatientService implements Ipatient {
    private final Logger log = LoggerFactory.getLogger(PatientService.class);

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Collection<PatientDTO> getAllDossiers() {
        return PatientMapper.EntityToDtos(patientRepository.findAll());
    }

    @Override
    public PatientDTO findById(int id) {
        Patient patient = patientRepository.findById(id);
        PatientDTO patientDTO = PatientMapper.EntityToDto(patient);
        return patientDTO;
    }

    @Override
    public PatientDTO save(PatientDTO dosdto) {
        Patient dos = PatientMapper.DtoToEntity(dosdto);
        dos = patientRepository.save(dos);
        PatientDTO resultDTO = PatientMapper.EntityToDto(dos);
        return resultDTO;
    }

    @Override
    public PatientDTO update(PatientDTO dosdto) {
        Patient dos = PatientMapper.DtoToEntity(dosdto);
        dos = patientRepository.save(dos);
        PatientDTO resultDTO = PatientMapper.EntityToDto(dos);
        return resultDTO;
    }

    @Override
    public void delete(int id) {
        patientRepository.deleteById(id);
    }
}