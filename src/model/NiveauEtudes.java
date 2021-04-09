package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="niveau_etudes")
public class NiveauEtudes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	private String anneeDebut;
	private String anneeFin;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getAnneeDebut() {
		return anneeDebut;
	}
	public void setAnneeDebut(String anneeDebut) {
		this.anneeDebut = anneeDebut;
	}
	public String getAnneeFin() {
		return anneeFin;
	}
	public void setAnneeFin(String anneeFin) {
		this.anneeFin = anneeFin;
	}
	@Override
	public String toString() {
		return "NiveauEtudes [id=" + id + ", libelle=" + libelle + ", anneeDebut=" + anneeDebut + ", anneeFin="
				+ anneeFin + "]";
	}
	
	
}
