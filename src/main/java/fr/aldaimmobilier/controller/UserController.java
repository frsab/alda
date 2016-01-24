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
@Named(value="userCtrl")
@RequestScoped
public class UserController {
	 
	   // private  static final Logger logger = Logger.getLogger(UserController.class);
	    
	    private String nomLocal="nom local";
	    @EJB
	    private UserDAO userDAO;
		private User user;
		private List<User> users;

		public String getNomLocal() {
			return nomLocal;
		}

		public void setNomLocal(String nomLocal) {
			this.nomLocal = nomLocal;
		}
	 
	    public UserController() {
	    	System.out.println("In ProjectController");
	     ;//   logger.info("In ProjectController");
	         
	    }
	     
	    @PostConstruct
	    public void postConstruct() {
	        user = new User();
	        System.out.println("In ProjectController postConstruct"+user.toString());
	        // logger.info("In ProjectController postConstruct");
	    }
	 
	 
	    public String saveUser() {
	        String returnValue = "display_project"; //le controller renverra vers la page display_project.xhtml
	      //  logger.info("Inscription de l'tilisateur : " + user.toString());
	       // System.out.println("Inscription de l'tilisateur : " + user.toString());
	       // System.out.println("Inscription utilisateur : " + user.toString());
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
	            	System.out.println("Taille de projects=" + users.size());
	             //   logger.info("Taille de projects=" + users.size());
	            } else {
	            	System.out.println("Taille de projects=0");
	               // logger.info("Taille de projects=0");
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

