package com.simo.etudiant.entite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Etudiant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="nom",length=30)
	@NotEmpty
	@Size(min=3, max=30,message="Je ne veux pas moi")
	private String nom;
	@Column(name="email",length=40)
	@NotEmpty(message="Je ne veux pas moi de toi")
	@Email
	private String email;
	//@NotEmpty
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date dateNaissance;
	private String photo;
	
	
	public Etudiant() {
		
	}
	
	public Etudiant(String nom, String email, Date dateNaissance, String photo) {
		super();
		this.nom = nom;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.photo = photo;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", email=" + email + ", dateNaissance=" + dateNaissance
				+ ", photo=" + photo + "]";
	}
	
	
	

}
