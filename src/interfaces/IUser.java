package interfaces;

import model.User;

public interface IUser {
	public void addUser(User u);
	public User getOneUser(String email,String password);
}
