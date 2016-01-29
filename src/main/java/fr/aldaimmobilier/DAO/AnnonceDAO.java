package fr.aldaimmobilier.DAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import fr.aldaimmobilier.EntityTable.Annonce;
import fr.aldaimmobilier.EntityTable.User;
import fr.aldaimmobilier.EntityTable.Annonce;
@Stateless
@LocalBean
public class AnnonceDAO implements IntefaceAnnonceDAO{

	@PersistenceContext(unitName = "aldaImmobilierPU")
	private EntityManager entityManager;
	public Annonce insertAnnonce(Annonce annonce) {
		System.out.println("insertAnnonce"+annonce.toString());
		if(annonce.getIdAnnonce()==null){
			saveNewAnnonce(annonce);
		}
		else{
			updateAnnonce(annonce);
		}
		return annonce;
	}

	private void updateAnnonce(Annonce annonce) {
		System.out.println("updateAnnonce"+annonce.toString());
		entityManager.merge(annonce);
	}

	private void saveNewAnnonce(Annonce annonce) {
		System.out.println("saveNewAnnonce"+annonce.toString());
		entityManager.persist(annonce); 
	}

	public List<Annonce> getAllAnnonces() {
		 List<Annonce> list = null;
	        try {
	       //     list = entityManager.createNamedQuery(Annonce.FIND_ALL_USERSS).getResultList();
	            list = entityManager.createNamedQuery("Annonce.findAll").getResultList();
	        } catch (Exception e) {
	        	System.out.println("Exception, message d'erreur : " + e.toString());
	       
				//logger.error("Exception, message d'erreur : " + e.toString());
	            e.printStackTrace();
	        }
	        return list;
	}

	@Override
	public List<Annonce> getAnnonces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAnnonces() {
		// TODO Auto-generated method stub
		
	}
	public Annonce getAnnonceByDate(Long id) {
		Annonce a=null;
        	try{
    			a=(Annonce) entityManager.createNamedQuery("Annonce.findById").setParameter("Id", id).getSingleResult();
    		}
    		catch(Exception e){
            	System.out.println("Exception, message d'erreur : " + e.toString());
     	        e.printStackTrace();
    		}
		return a;
	}


}
