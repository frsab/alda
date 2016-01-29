package fr.aldaimmobilier.DAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;


import fr.aldaimmobilier.EntityTable.User;
@Stateless
@LocalBean
public class UserDAO implements IntefaceUserDAO{
	@PersistenceContext(unitName = "aldaImmobilierPU")
	private EntityManager entityManager;
	public User insertUser(User user) {
		System.out.println("insertUser"+user.toString());
		if(user.getIdUser()==null){
			saveNewUser(user);
		}
		else{
			updateUser(user);
		}
		return user;
	}

	private void updateUser(User user) {
		System.out.println("updateUser"+user.toString());
		entityManager.merge(user);
	}

	private void saveNewUser(User user) {
		System.out.println("saveNewUser"+user.toString());
		entityManager.persist(user); 
	}

	public List<User> getAllUsers() {
		 List<User> list = null;
	        try {
	       //     list = entityManager.createNamedQuery(User.FIND_ALL_USERSS).getResultList();
	            list = entityManager.createNamedQuery("User.findAll").getResultList();
	        } catch (Exception e) {
	        	System.out.println("Exception, message d'erreur : " + e.toString());
	       
				//logger.error("Exception, message d'erreur : " + e.toString());
	            e.printStackTrace();
	        }
	        return list;
	}

	public boolean login(String username, String password) {
		User u=null;
        if(username != null && password != null ){
        	try{
    			u=(User) entityManager.createNamedQuery("User.findByMail").setParameter("email", username).getSingleResult();//.setParameter(arg0, arg1)//getSingleResult();
    			if(u.getEmail().equals(username)){
    				System.out.println("mail"+username+"existe");
    				if(u.getPassword().equals(password))
    					return true;
    			}
    		}
    		catch(Exception e){
            	System.out.println("Exception, message d'erreur : " + e.toString());
     	        e.printStackTrace();
    		}
        }
		return false;
	}
}
