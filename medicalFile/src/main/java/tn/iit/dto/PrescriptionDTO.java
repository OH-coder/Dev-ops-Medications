package tn.iit.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class PrescriptionDTO {
	private int id_prescription;
	private String descriptionart;
	private Integer articleId;
	private int qte;
	private float prix;
	private LocalDateTime date;
	@Transient
	private PatientDTO patientDTO;


	public int getId_prescriptions() {
		return id_prescription;
	}

	public void setId_prescriptions(int id_prescriptions) {
		this.id_prescription = id_prescriptions;
	}

	public String getDescriptionart() {
		return descriptionart;
	}

	public void setDescriptionart(String descriptionart) {
		this.descriptionart = descriptionart;
	}

	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
