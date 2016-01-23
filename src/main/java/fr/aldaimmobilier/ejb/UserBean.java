package fr.aldaimmobilier.ejb;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.apache.log4j.Logger;

import fr.aldaimmobilier.DAO.UserDAO;
import fr.aldaimmobilier.EntityTable.User;
import fr.aldaimmobilier.controller.UserController;
@Named(value="user")
@RequestScoped
//@ManagedBean(name = "user")
public class UserBean {
	
	private  static final Logger logger = Logger.getLogger(UserController.class);
	private User user;
	private List<User> listUser;
	
	public UserBean() {
		logger.info("In UserController");
	}
	@EJB
    private UserDAO userDAO;
	public String saveProject() {
		String returnValue = "display_project"; //le controller renverra vers la page display_project.xhtml
        logger.info("Sauvegarde du projet : " + user.toString());
        try {
            userDAO.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            returnValue = "error_saving";
            return returnValue;
        }
        // on récupère la liste des projets
        //returnValue = getAllProjects();
        return returnValue;
	    }
	public String getAllProjects() {
        String returnValue = "display_projects";
        try {
        	listUser = userDAO.getAllUsers();
            if (listUser != null) {
                logger.info("Taille de projects=" + listUser.size());
            } else {
                logger.info("Taille de projects=0");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnValue = "error_saving";
        }
        return returnValue;
    }
 
    public List<User> getListUser() {
        return listUser;
    }
 
    public void setListUser(List<User> projects) {
        this.listUser = projects;
    }
 
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
        listUser = new ArrayList<>();
    }

	
	
	
	
	
	private String nom = "This editor is provided by PrimeFaces SABER";

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}