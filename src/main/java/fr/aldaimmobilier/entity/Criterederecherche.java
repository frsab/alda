package fr.aldaimmobilier.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the criterederecherche database table.
 * 
 */
@Entity
@NamedQuery(name="Criterederecherche.findAll", query="SELECT c FROM Criterederecherche c")
public class Criterederecherche implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_annonce")
	private int idAnnonce;

	private int codePostalBienCherche;

	private int priMin;

	private int prixMax;

	private int surfaceBienCherche;
	@Column(length = 254)

	private String typeBienCherche;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public Criterederecherche() {
	}

	public int getIdAnnonce() {
		return this.idAnnonce;
	}

	public void setIdAnnonce(int idAnnonce) {
		this.idAnnonce = idAnnonce;
	}

	public int getCodePostalBienCherche() {
		return this.codePostalBienCherche;
	}

	public void setCodePostalBienCherche(int codePostalBienCherche) {
		this.codePostalBienCherche = codePostalBienCherche;
	}

	public int getPriMin() {
		return this.priMin;
	}

	public void setPriMin(int priMin) {
		this.priMin = priMin;
	}

	public int getPrixMax() {
		return this.prixMax;
	}

	public void setPrixMax(int prixMax) {
		this.prixMax = prixMax;
	}

	public int getSurfaceBienCherche() {
		return this.surfaceBienCherche;
	}

	public void setSurfaceBienCherche(int surfaceBienCherche) {
		this.surfaceBienCherche = surfaceBienCherche;
	}

	public String getTypeBienCherche() {
		return this.typeBienCherche;
	}

	public void setTypeBienCherche(String typeBienCherche) {
		this.typeBienCherche = typeBienCherche;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}