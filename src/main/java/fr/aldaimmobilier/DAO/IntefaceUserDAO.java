package fr.aldaimmobilier.DAO;

import java.util.List;

import fr.aldaimmobilier.EntityTable.User;

public interface IntefaceUserDAO {
	    public User insertUser(User user);
	    public List<User> getAllUsers();
}
