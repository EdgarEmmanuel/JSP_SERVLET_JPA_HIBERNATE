package interfaces;

import model.Specialite;

public interface ISpecialite {
	public int insertOneSpecialite(Specialite specialite);
	public Specialite getOneSpeById(int id);
}
