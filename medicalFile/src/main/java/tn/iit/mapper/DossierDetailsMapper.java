package tn.iit.mapper;

import tn.iit.dto.DossierDetailsDTO;
import tn.iit.entity.DossierDetails;



public class DossierDetailsMapper {
	public static  DossierDetails DtoToEntity( DossierDetailsDTO dos) {
		 DossierDetails dossier = new  DossierDetails();
		 dossier.setArticleId(dos.getArticleId());
		 dossier.setQte(dos.getQte());
		 dossier.setPrix(dos.getPrix());
		 dossier.setDate(dos.getDate());
		 dossier.setDossier(dos.getDossier());
       return dossier ;
	}
	
	   public static DossierDetailsDTO EntityToDto(DossierDetails dos) {
		   DossierDetailsDTO dossierDetailsDTO = new DossierDetailsDTO();
		   dossierDetailsDTO.setArticleId(dos.getArticleId());
		   dossierDetailsDTO.setQte(dos.getQte());
		   dossierDetailsDTO.setPrix(dos.getPrix());
		   dossierDetailsDTO.setDate(dos.getDate());
		   dossierDetailsDTO.setDossier(dos.getDossier());
          return dossierDetailsDTO;                            
      }
}
