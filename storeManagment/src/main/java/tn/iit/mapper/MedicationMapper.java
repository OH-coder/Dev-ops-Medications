package tn.iit.mapper;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import tn.iit.dto.MedicationDTO;
import tn.iit.entity.Medication;

public class MedicationMapper {
	public static Medication DtoToEntity(MedicationDTO med) {
		Medication medication = new Medication();
		medication.setId(med.getId());
		medication.setDescription(med.getDescription());
        return medication;
	}
	
	   public static MedicationDTO EntityToDto(Medication med) {
		   MedicationDTO medicationDto = new MedicationDTO();
		   medicationDto.setId(med.getId());
		   medicationDto.setDescription(med.getDescription());
           return medicationDto;
       }
	   
	   public static Collection<MedicationDTO> EntityToDtos(Collection<Medication> meds) {
		   Collection<MedicationDTO> medicationDtos = new ArrayList<>();
		   meds.forEach(med -> {
			   medicationDtos.add(EntityToDto(med));
		   });
           return medicationDtos;
       }
	   
}
