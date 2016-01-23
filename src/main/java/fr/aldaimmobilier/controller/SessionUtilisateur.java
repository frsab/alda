package fr.aldaimmobilier.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import fr.aldaimmobilier.EntityTable.Annonce;
import fr.aldaimmobilier.EntityTable.Annoncefavori;
import fr.aldaimmobilier.EntityTable.User;
import fr.aldaimmobilier.ejb.SessionEJB;

/**
 * Session Bean implementation class SessionUtilisateur s
 */
@Named(value="session")
@RequestScoped

public class SessionUtilisateur {
	@EJB
	private SessionEJB sessionEJB;
	private String userName;
	private String userPassword;
	private User user;
	private List annonces;
	private List<Annonce> allUser;
	private List<Annonce> allAnnonces;
	/*public String connecter(String mail,String pw){
		user.setPassword(pw);
		user.setEmail(mail);
		user=user.getUser(u,mp);
		user=user.
		
	       allUser = employeeEJB.findEmployees();
	        return employeeList;
	        return new String("");
		
	}*/




}
