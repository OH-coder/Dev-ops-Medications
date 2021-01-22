package tn.iit.mapper;

import tn.iit.dto.PrescriptionDTO;
import tn.iit.entity.Prescription;

import java.util.ArrayList;
import java.util.Collection;


public class PrescriptionMapper {
	public static Prescription DtoToEntity(PrescriptionDTO dos) {
		Prescription prescription = new Prescription();
		prescription.setArticleId(dos.getArticleId());
		prescription.setId(dos.getId_prescriptions());
		prescription.setQte(dos.getQte());
		prescription.setPrix(dos.getPrix());
		prescription.setDate(dos.getDate());
		prescription.setDescription(dos.getDescriptionart());
		prescription.setPatient(PatientMapper.DtoToEntity(dos.getPatientDTO()));
		return prescription;
	}

	public static PrescriptionDTO EntityToDto(Prescription dos) {
		PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
		prescriptionDTO.setId_prescriptions(dos.getId());
		prescriptionDTO.setArticleId(dos.getArticleId());
		prescriptionDTO.setQte(dos.getQte());
		prescriptionDTO.setPrix(dos.getPrix());
		prescriptionDTO.setDate(dos.getDate());
		prescriptionDTO.setDescriptionart(dos.getDescription());
		prescriptionDTO.setPatientDTO(PatientMapper.EntityToDto(dos.getPatient()));
		return prescriptionDTO;
	}

	public static Collection<PrescriptionDTO> EntityToDtos(Collection<Prescription> doss) {
		Collection<PrescriptionDTO> dosdets = new ArrayList<>();
		doss.forEach(dos -> {
			dosdets.add(EntityToDto(dos));
		});
		return dosdets;
	}
}
