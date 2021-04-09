package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity(name="cv")
public class Cv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// a cv has one and only one description and a descrition is in only one CV
	@OneToOne(optional=false)
    @JoinColumn(name = "DESCRIPTION_ID")
    private DescriptionCv order;
	
	// a cv can have 0 or many experience and an experience can be in 1 or many cv 
		@ManyToMany(fetch=FetchType.LAZY)
		@JoinColumn(name = "cv_experience")
		private List<ExperienceProf> experiences;
	
	
	// a cv can have 0 or many realisation and a realisation can be in 1 or many cv 
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinColumn(name = "cv_realisation")
		private List<Realisation> realisations;
		
	// a cv can have 0 or many niveaux and a niveaux can be in 1 or many cv 
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinColumn(name = "cv_niveaux")
		private List<NiveauEtudes> niveaux;
		
	// a cv can have 0 or many realisation and a realisation can be in 1 or many cv 
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinColumn(name = "cv_specialites")
		private List<Specialite> specialites;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public DescriptionCv getOrder() {
			return order;
		}

		public void setOrder(DescriptionCv order) {
			this.order = order;
		}

		public List<ExperienceProf> getExperiences() {
			return experiences;
		}

		public void setExperiences(List<ExperienceProf> experiences) {
			this.experiences = experiences;
		}

		public List<Realisation> getRealisations() {
			return realisations;
		}

		public void setRealisations(List<Realisation> realisations) {
			this.realisations = realisations;
		}

		public List<NiveauEtudes> getNiveaux() {
			return niveaux;
		}

		public void setNiveaux(List<NiveauEtudes> niveaux) {
			this.niveaux = niveaux;
		}

		public List<Specialite> getSpecialites() {
			return specialites;
		}

		public void setSpecialites(List<Specialite> specialites) {
			this.specialites = specialites;
		}

		@Override
		public String toString() {
			return "Cv [id=" + id + ", order=" + order + ", experiences=" + experiences + ", realisations="
					+ realisations + ", niveaux=" + niveaux + ", specialites=" + specialites + "]";
		}
		
		
		
		
	

}
