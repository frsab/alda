package fr.aldaimmobilier.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;

import fr.aldaimmobilier.DAO.UserDAO;
import fr.aldaimmobilier.EntityTable.User;
import fr.aldaimmobilier.ejb.UserEJB;
@Named(value="userCtrl")
@RequestScoped
public class UserController {
	 
	    private  static final Logger logger = Logger.getLogger(UserController.class);
	    
	    private String nomLocal="nom local";
	    public String getNomLocal() {
			return "nom local";
		}

		public void setNomLocal(String nomLocal) {
			this.nomLocal = nomLocal;
		}
 	private User user;
 	private List<User> users;
	 
	    public UserController() {
	        logger.info("In ProjectController");
	         
	    }
	     
	    @PostConstruct
	    public void postConstruct() {
	        user = new User();
	         logger.info("In ProjectController postConstruct");
	    }
	 
	    @EJB
	    private UserDAO userDAO;
	 
	    public String saveProject() {
	        String returnValue = "display_project"; //le controller renverra vers la page display_project.xhtml
	        logger.info("Sauvegarde du projet : " + user.
	                toString());
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
	            users = userDAO.getAllUsers();//getAllUsers();
	            if (users != null) {
	                logger.info("Taille de projects=" + users.size());
	            } else {
	                logger.info("Taille de projects=0");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            returnValue = "error_saving";
	        }
	        return returnValue;
	    }
	 
	    public List<User> getUserss() {
	        return users;
	    }
	 
	    public void setUsers(List<User> projects) {
	        this.users = projects;
	    }
	 
	    public User getUser() {
	        return user;
	    }
	 
	    public void setUser(User user) {
	        this.user = user;
	        users = new ArrayList<>();
	    }

		 
	}
	/*
	@EJB
    private UserEJB userEJB;
    private User user = new User();
    private List<User> userList = new ArrayList<>();
	private int idUser;

	private String adresseUser;

	private int codePostalUser;

	private String email;

	private String nom;

	private String password;

	private String telephoneNb;

	private String typeUser;

*/

