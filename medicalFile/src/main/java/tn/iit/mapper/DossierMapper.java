package tn.iit.mapper;

import tn.iit.dto.DossierDTO;
import tn.iit.entity.Dossier;

public class DossierMapper {
	public static  Dossier DtoToEntity( DossierDTO dos) {
		 Dossier dossier = new  Dossier();
		 dossier.setPatient(dos.getPatient());
        return dossier ;
	}
	
	   public static DossierDTO EntityToDto(Dossier dos) {
		   DossierDTO dossierDTO = new DossierDTO();
		   dossierDTO.setPatient(dos.getPatient());
           return dossierDTO;                            
       }
}
