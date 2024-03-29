package fr.aldaimmobilier.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
//import javax.enterprise.context.RequestScoped;
//import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import fr.aldaimmobilier.DAO.UserDAO;
import fr.aldaimmobilier.EntityTable.User;

//import fr.aldaimmobilier.ejb.UserEJB;
@Named(value = "userCtrl")
@RequestScoped
public class UserController {
	@EJB
	private UserDAO userDAO;
	private User user;
	private List<User> users;

	public UserController() {
		System.out.println("In UserController");
	}

	@PostConstruct
	public void postConstruct() {
		user = new User();
		System.out.println("In UserController postConstruct" + user.toString());
	}

	public String saveUser() {
		String returnValue = "users";
		System.out.println("Inscription de l'tilisateur : " + user.toString());
		try {
			userDAO.insertUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			returnValue = "error_page";
			System.out.println("retour vers la page " + returnValue);
			return returnValue;
		}
		System.out.println("retour vers la page " + returnValue);
		return returnValue;
	}
    public String goToLoginPage() {
		String returnValue = "login";
		System.out.println("goToLoginPage function !!");
		return returnValue;
	}
	public List<User> getUsers() {
		String returnValue = "users";
		System.out.println("ja suis au niveau de la fonction getUsers");
		try {
			users = userDAO.getAllUsers();// getAllUsers();
			if (users != null) {
				System.out.println("Nombre des utilisateurs inscrits=" + users.size());
				// logger.info("Taille de users=" + users.size());
			} 
			else {
				System.out.println("Nombre des utilisateurs inscrits=0");
				// logger.info("Taille de users=0");
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnValue = "error_saving";
		}
		for(User u : users)System.out.println(u.toString());
		for(User u : users)System.out.println(u.getEmail());
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		users = new ArrayList<>();
	}

}
