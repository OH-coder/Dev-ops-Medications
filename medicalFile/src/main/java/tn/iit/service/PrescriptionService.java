package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.dao.PatientRepository;
import tn.iit.dao.PrescriptionRepository;
import tn.iit.dto.MedicationDTO;
import tn.iit.dto.PatientDTO;
import tn.iit.dto.PrescriptionDTO;
import tn.iit.entity.Prescription;
import tn.iit.exception.MedicationNotFoundException;
import tn.iit.exception.PatientNotFoundException;
import tn.iit.mapper.PatientMapper;
import tn.iit.mapper.PrescriptionMapper;

import java.util.Collection;


@Service
public class PrescriptionService implements IPrescriptionDetails {

    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private StoreManagmentServiceClient storeManagmentServiceClient;


    @Override
    public Collection<PrescriptionDTO> getAllDossierDetails() {
        return PrescriptionMapper.EntityToDtos(prescriptionRepository.findAll());
    }

    @Override
    public PrescriptionDTO findById(int id) {
        Prescription dos = prescriptionRepository.findById(id);
        PrescriptionDTO resultDTO = PrescriptionMapper.EntityToDto(dos);
        return resultDTO;
    }

    @Override
    public PrescriptionDTO save(PrescriptionDTO dosdto, String Patient) {
        PatientDTO patientDto = null;
        try {
            MedicationDTO medicationDTO = storeManagmentServiceClient.getMedicationDTOById(dosdto.getArticleId());
        } catch (Exception e) {
            throw new MedicationNotFoundException("medication with id " + dosdto.getArticleId() + " is not found");
        }
        try {
            patientDto = PatientMapper.EntityToDto(patientRepository.findByNameIgnoreCase(Patient));
        } catch (Exception e) {
            throw new PatientNotFoundException(" patient with name " + Patient + " is not found");
        }
        dosdto.setPatientDTO(patientDto);
        Prescription dos = PrescriptionMapper.DtoToEntity(dosdto);
        dos = prescriptionRepository.save(dos);
        PrescriptionDTO resultDTO = PrescriptionMapper.EntityToDto(dos);
        return resultDTO;
    }

    @Override
    public void delete(int id) {
        prescriptionRepository.deleteById(id);
    }


    @Override
    public PrescriptionDTO update(PrescriptionDTO dosdto) {
        Prescription dos = PrescriptionMapper.DtoToEntity(dosdto);
        dos = prescriptionRepository.save(dos);
        PrescriptionDTO resultDTO = PrescriptionMapper.EntityToDto(dos);
        return resultDTO;
    }
}