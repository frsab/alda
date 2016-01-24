package fr.aldaimmobilier.EntityTable;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")

@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
})
public class User implements Serializable {
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", adresseUser=" + adresseUser + ", codePostalUser=" + codePostalUser
				+ ", email=" + email + ", nom=" + nom + ", password=" + password + ", telephoneNb=" + telephoneNb
				+ ", typeUser=" + typeUser + ", annonces=" + annonces + ", annoncefavoris=" + annoncefavoris
				+ ", criterederecherches=" + criterederecherches + "]";
	}

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id_user")
	private Long idUser;

	private String adresseUser;

	private Long codePostalUser;

	private String email;

	private String nom;

	private String password;

	private String telephoneNb;

	private String typeUser;

	//bi-directional many-to-one association to Annonce
	@OneToMany(mappedBy="user")
	private List<Annonce> annonces;

	//bi-directional many-to-one association to Annoncefavori
	@OneToMany(mappedBy="user")
	private List<Annoncefavori> annoncefavoris;

	//bi-directional many-to-one association to Criterederecherche
	@OneToMany(mappedBy="user")
	private List<Criterederecherche> criterederecherches;

	public User() {
	}

	public Long getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getAdresseUser() {
		return this.adresseUser;
	}

	public void setAdresseUser(String adresseUser) {
		this.adresseUser = adresseUser;
	}

	public Long getCodePostalUser() {
		return this.codePostalUser;
	}

	public void setCodePostalUser(Long codePostalUser) {
		this.codePostalUser = codePostalUser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephoneNb() {
		return this.telephoneNb;
	}

	public void setTelephoneNb(String telephoneNb) {
		this.telephoneNb = telephoneNb;
	}

	public String getTypeUser() {
		return this.typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public List<Annonce> getAnnonces() {
		return this.annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}

	public Annonce addAnnonce(Annonce annonce) {
		getAnnonces().add(annonce);
		annonce.setUser(this);

		return annonce;
	}

	public Annonce removeAnnonce(Annonce annonce) {
		getAnnonces().remove(annonce);
		annonce.setUser(null);

		return annonce;
	}

	public List<Annoncefavori> getAnnoncefavoris() {
		return this.annoncefavoris;
	}

	public void setAnnoncefavoris(List<Annoncefavori> annoncefavoris) {
		this.annoncefavoris = annoncefavoris;
	}

	public Annoncefavori addAnnoncefavori(Annoncefavori annoncefavori) {
		getAnnoncefavoris().add(annoncefavori);
		annoncefavori.setUser(this);

		return annoncefavori;
	}

	public Annoncefavori removeAnnoncefavori(Annoncefavori annoncefavori) {
		getAnnoncefavoris().remove(annoncefavori);
		annoncefavori.setUser(null);

		return annoncefavori;
	}

	public List<Criterederecherche> getCriterederecherches() {
		return this.criterederecherches;
	}

	public void setCriterederecherches(List<Criterederecherche> criterederecherches) {
		this.criterederecherches = criterederecherches;
	}

	public Criterederecherche addCriterederecherch(Criterederecherche criterederecherch) {
		getCriterederecherches().add(criterederecherch);
		criterederecherch.setUser(this);

		return criterederecherch;
	}

	public Criterederecherche removeCriterederecherch(Criterederecherche criterederecherch) {
		getCriterederecherches().remove(criterederecherch);
		criterederecherch.setUser(null);

		return criterederecherch;
	}

}