package fr.aldaimmobilier.controller;


import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import fr.aldaimmobilier.DAO.UserDAO;
import fr.aldaimmobilier.EntityTable.User;
@Named(value = "userLoginCtrl")
				//userLoginCtrl
@RequestScoped
//@ManagedBean
public class UserLoginController {
	@EJB
	private UserDAO userDAO;
	private User user;
     
    private String username;
     
    private String password;
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    public String goToLoginPage() {
		String returnValue = "login";
		System.out.println("goToLoginPage UserLoginPage !!");
		return returnValue;
	}
    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        System.out.println("context"+context.toString());
//        System.out.println(context
        FacesMessage message = null;
        boolean loggedIn = false;
        
         if(userDAO.login(username,password)){
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
        
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }   
}