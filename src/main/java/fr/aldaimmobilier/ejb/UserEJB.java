package fr.aldaimmobilier.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import fr.aldaimmobilier.entity.User;

@Stateless

public class UserEJB {
	@PersistenceContext(unitName = "aldaImmobilierPU")
    private EntityManager em;
	// @PersistenceUnit(unitName = "aldaImmobilierPU")
	/*private EntityManagerFactory emf = Persistence.createEntityManagerFactory("aldaImmobilierPU");
	EntityManager em = emf.createEntityManager();*/
	

	public List<User> findUsers() {
		//findAllUsers
		
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	public User addNew(User user) {
		
    			user.show();
		em.persist(user);
		em.flush();
		user.show();
		return user;
	}
}
