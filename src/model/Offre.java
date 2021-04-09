package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="offre")
public class Offre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titre;
	private String description;
	private String delai;
	private String email;
	private String telephone;
	
	// many offer are link to one Entrprise
	@ManyToOne(optional=false)
    @JoinColumn(name="ENT_ID")
    private Entreprise entreprise;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDelai() {
		return delai;
	}
	public void setDelai(String delai) {
		this.delai = delai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "Offre [id=" + id + ", titre=" + titre + ", description=" + description + ", delai=" + delai + ", email="
				+ email + ", telephone=" + telephone + ", entreprise=" + entreprise + "]";
	}
	
	
	
}
