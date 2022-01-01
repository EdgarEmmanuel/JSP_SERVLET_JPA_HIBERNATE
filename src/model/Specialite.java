package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="specialite")
public class Specialite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	private int level;
	
	@ManyToMany(mappedBy = "specialites", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Cv> cvs = new HashSet<>();
	
	
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public Set<Cv> getCv() {
        return cvs;
    }

    public void addCv(Cv cv) {
        cvs.add(cv);
        cv.getSpecialites().add(this);
    }
	
	@Override
	public String toString() {
		return "Specialite [id=" + id + ", libelle=" + libelle + ", level=" + level + "]";
	}
	
	

}
