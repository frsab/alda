package fr.aldaimmobilier.DAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import fr.aldaimmobilier.EntityTable.User;
@Stateless
@LocalBean
public class UserDAO implements IntefaceUserDAO{
	//private static final Logger logger = Logger.getLogger(UserDAO.class);
	
	@PersistenceContext(unitName = "aldaImmobilierPU")
	private EntityManager entityManager;
	
	EntityManagerFactory emf= Persistence.createEntityManagerFactory( "aldaImmobilierPU" );
    //entityManager=emf.createEntityManager();
	
	//private Category logger;

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
        //EntityManager em = emf.createEntityManager();
        
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
}
