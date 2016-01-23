package fr.aldaimmobilier.ejb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.aldaimmobilier.EntityTable.User;

public class SessionEJB {
	@PersistenceContext(unitName = "aldaImmobilierPU")
    private EntityManager entityManager;
       
       public List<User> findUsers(){
 //   	   @NamedQuery(name="User.findAll", query="SELECT u FROM User u")
    	   TypedQuery<User> query = entityManager.createNamedQuery("findAllEmployees", User.class);        
              return query.getResultList();
       }
       
       public User addNew(User user) {
              entityManager.persist(user);
              return user;
       }

}
