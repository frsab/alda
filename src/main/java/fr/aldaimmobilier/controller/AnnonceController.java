package fr.aldaimmobilier.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import fr.aldaimmobilier.DAO.AnnonceDAO;
import fr.aldaimmobilier.EntityTable.Annonce;

@Named(value = "annonceCtrl")
@RequestScoped
public class AnnonceController {
	@EJB
	private AnnonceDAO annonceDAO;
	private Annonce annonce;
	private List<Annonce> annonces;

	public AnnonceController() {
		System.out.println("In AnnonceController");
	}

	@PostConstruct
	public void postConstruct() {
		annonce = new Annonce();
		System.out.println("In AnnonceController postConstruct" + annonce.toString());
	}

	public String saveAnnonce() {
		String returnValue = "annonces";
		System.out.println("Inscription de l'tilisateur : " + annonce.toString());
		try {
			annonceDAO.insertAnnonce(annonce);
		} catch (Exception e) {
			e.printStackTrace();
			returnValue = "error_page";
			System.out.println("retour vers la page " + returnValue);
			return returnValue;
		}
		System.out.println("retour vers la page " + returnValue);
		return returnValue;
	}
    public String goToLoginPage() {
		String returnValue = "login";
		System.out.println("goToLoginPage function !!");
		return returnValue;
	}
	public List<Annonce> getAnnonces() {
		String returnValue = "annonces";
		System.out.println("ja suis au niveau de la fonction getAnnonces");
		try {
			annonces = annonceDAO.getAllAnnonces();// getAllAnnonces();
			if (annonces != null) {
				System.out.println("Nombre des utilisateurs inscrits=" + annonces.size());
				// logger.info("Taille de annonces=" + annonces.size());
			} 
			else {
				System.out.println("Nombre des Annonces inscrits=0");
				// logger.info("Taille de annonces=0");
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnValue = "error_saving";
		}
		for(Annonce u : annonces)System.out.println(u.toString());
		return annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
		annonces = new ArrayList<>();
	}

}
