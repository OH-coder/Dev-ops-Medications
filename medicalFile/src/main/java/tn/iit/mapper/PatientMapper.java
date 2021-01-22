package tn.iit.mapper;

import tn.iit.dto.PatientDTO;
import tn.iit.entity.Patient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PatientMapper {

	public static Patient DtoToEntity(PatientDTO dosdto) {
		Patient patient = new Patient();
		patient.setId(dosdto.getId());
		patient.setName(dosdto.getName());
		return patient;
	}

	public static PatientDTO EntityToDto(Patient dos) {
		PatientDTO patientDTO = new PatientDTO();
		patientDTO.setId(dos.getId());
		patientDTO.setName(dos.getName());
		return patientDTO;
	}


	public static Collection<PatientDTO> EntityToDtos(Collection<Patient> doss) {
		List<PatientDTO> dosdets = new ArrayList<>();
		doss.forEach(dos -> {
			dosdets.add(EntityToDto(dos));
		});
		return dosdets;
	}


}
