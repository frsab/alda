package fr.aldaimmobilier.controller;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import fr.aldaimmobilier.ejb.*;
import fr.aldaimmobilier.entity.*;


@Named(value = "userController")
@RequestScoped
public class UserController {
 
    @Inject
    private UserEJB userEJB;
    private User user = new User();
    private List<User> userList = new ArrayList<>();
 
   public List<User> getUserList() {
        userList = userEJB.findUsers();
        return userList;
    }
 
   public String viewUser(){
        return "UserList.xhtml";
    }
   public String addNewEmployee() {
       user = userEJB.addNew(user);
       userList = userEJB.findUsers();
       return "employeeList.xhtml";
   }
   
    public String addNewUser() {
    	System.out.print("je suis au niveau de la fonction UserController::addNewUser"
    			+"(, je dispose d'une instencede User :\nadresse "
    			+user.getAdresseUser()+"\nnom "+user.getNom()+"\nemail "+user.getEmail() );
    	if(user==null)
    		System.out.println("user==null");
    	else
    		System.out.println("user=*null");
    	
        user = userEJB.addNew(user);
        userList = userEJB.findUsers();
        return "userList.xhtml";
    }

	public fr.aldaimmobilier.ejb.UserEJB getUserEJB() {
		return userEJB;
	}

	public void setUserEJB(UserEJB userEJB) {
		userEJB = userEJB;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		user = user;
	}

	public void setUserList(List<User> userList) {
		userList = userList;
	}
    
}