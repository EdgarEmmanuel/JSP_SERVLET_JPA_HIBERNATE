package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="entreprise")
public class Entreprise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom_entreprise;
	private String localisation;
	
	@OneToOne(optional=false)
    @JoinColumn(name = "USER_ID")
	private User user;
	
	// an Enterprise is linked
	@OneToMany(mappedBy="entreprise",targetEntity=Offre.class,
		       fetch=FetchType.LAZY)
	private List<Offre> orders; 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom_entreprise() {
		return nom_entreprise;
	}
	public void setNom_entreprise(String nom_entreprise) {
		this.nom_entreprise = nom_entreprise;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	@Override
	public String toString() {
		return "Entreprise [id=" + id + ", nom_entreprise=" + nom_entreprise + ", localisation=" + localisation
				+ ", user=" + user + ", orders=" + orders + "]";
	}
	
	
}
