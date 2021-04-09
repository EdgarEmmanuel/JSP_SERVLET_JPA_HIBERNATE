package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="demandeur_emploi")
public class Demandeur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	private String phone;
	private String localisation;
	private String nationalite;
	private int age;
	private String dateNaissance;
	
	@OneToOne(optional=false)
    @JoinColumn(name = "USER_ID")
	private User user;
	
	@OneToOne(optional=false)
    @JoinColumn(name = "CV_ID")
	private Cv cv;
	
	
	
	
	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public Cv getCv() {
		return cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Demandeur [id=" + id + ", name=" + name + ", surname=" + surname + ", phone=" + phone
				+ ", localisation=" + localisation + ", nationalite=" + nationalite + ", age=" + age
				+ ", dateNaissance=" + dateNaissance + ", user=" + user + ", cv=" + cv + "]";
	}
	
	
	
	
	

}
