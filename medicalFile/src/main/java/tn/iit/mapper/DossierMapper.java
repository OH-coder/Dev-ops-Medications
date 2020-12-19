package tn.iit.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import tn.iit.dto.DossierDTO;
import tn.iit.dto.DossierDetailsDTO;
import tn.iit.entity.Dossier;
import tn.iit.entity.DossierDetails;

public class DossierMapper {
	
	public static  Dossier DtoToEntity(DossierDTO dosdto) {
		 Dossier dossier = new  Dossier();
		 dossier.setId_dossier(dosdto.getId());
		 dossier.setPatient(dosdto.getPatient());
		 dossier.setDossierdetails(dosdto.getDossierdetails().stream().map(dos ->{
			 DossierDetails dosdet = dossierdetailsDtoToEntity(dos);
			 dosdet.setDossier(dossier);
		     return dosdet ;
		 }).collect(Collectors.toList())
		);
		 return dossier;
	}
	
	   public static DossierDTO EntityToDto(Dossier dos) {
		   DossierDTO dossierDTO = new DossierDTO();
		   dossierDTO.setId(dos.getId_dossier());
		   dossierDTO.setPatient(dos.getPatient());
		   dossierDTO.setDossierdetails(DossierdetailsEntityToDto(dos.getDossierdetails()));
           return dossierDTO;                            
       }
	   
	   
	   public static Collection<DossierDTO> EntityToDtos(Collection<Dossier> doss) {
		   List<DossierDTO> dosdets = new ArrayList<>();
		   doss.forEach(dos -> {
			   dosdets.add(EntityToDto(dos));
		   });
           return dosdets;                            
       }
	   
	   
	   public static List<DossierDetailsDTO> DossierdetailsEntityToDto(List<DossierDetails> doss) {
		   List<DossierDetailsDTO> dosdets = new ArrayList<>();
		   doss.forEach(dos -> {
			   dosdets.add(EntityToDtodosdet(dos));
		   });
           return dosdets;                            
       }
	   
	   public static DossierDetailsDTO EntityToDtodosdet(DossierDetails dos) {
		   DossierDetailsDTO dossierDetailsDTO = new DossierDetailsDTO();
		   dossierDetailsDTO.setId_dossierdetails(dos.getId_dossierdetails()); 
		   dossierDetailsDTO.setArticleId(dos.getArticleId());
		   dossierDetailsDTO.setQte(dos.getQte());
		   dossierDetailsDTO.setPrix(dos.getPrix());
		   dossierDetailsDTO.setDate(dos.getDate());
		   //dossierDetailsDTO.setDossier(dos.getDossier());
          return dossierDetailsDTO;                            
      }
	   
	   public static  DossierDetails dossierdetailsDtoToEntity(DossierDetailsDTO dos) {
			 DossierDetails dossier = new  DossierDetails();
			 dossier.setId_dossierdetails(dos.getId_dossierdetails());
			 dossier.setArticleId(dos.getArticleId());
			 dossier.setQte(dos.getQte());
			 dossier.setPrix(dos.getPrix());
			 dossier.setDate(dos.getDate());
			 //dossier.setDossier(dos.getDossier());
	       return dossier ;
		}
	   
	   
}
