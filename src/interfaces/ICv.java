package interfaces;

import model.Cv;

public interface ICv {
	public void addSpecialiteToCv(int idCv,int IdSpecialite);
	public Cv getOneCvById(int id);
}
