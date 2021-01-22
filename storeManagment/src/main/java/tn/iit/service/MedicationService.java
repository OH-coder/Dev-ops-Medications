package tn.iit.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.dao.MedicationRepository;
import tn.iit.dto.MedicationDTO;
import tn.iit.entity.Medication;
import tn.iit.mapper.MedicationMapper;

@Service
public class MedicationService implements Imedication {
    @Autowired
    private MedicationRepository medicationRepository;
    
    @Override
    public Collection<MedicationDTO> getAllArticles() {
        return MedicationMapper.EntityToDtos(medicationRepository.findAll());
    }
    
    @Override
    public MedicationDTO findById(int id) {
    	Medication med = medicationRepository.findById(id);
    	MedicationDTO resultDTO = MedicationMapper.EntityToDto(med);
        return resultDTO;
        }
    
    @Override
    public MedicationDTO save(MedicationDTO artdto) {
        Medication med = MedicationMapper.DtoToEntity(artdto);
        med =  medicationRepository.save(med);
        MedicationDTO resultDTO = MedicationMapper.EntityToDto(med);
        return resultDTO;
    }
    
    @Override
    public void delete(int id) {
        medicationRepository.deleteById(id);
    }
    
	@Override
	public MedicationDTO update(MedicationDTO meddto) {
		Medication med = MedicationMapper.DtoToEntity(meddto);
        med =  medicationRepository.save(med);
        MedicationDTO resultDTO = MedicationMapper.EntityToDto(med);
        return resultDTO;
	}
}