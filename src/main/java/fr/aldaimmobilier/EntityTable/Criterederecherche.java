package fr.aldaimmobilier.EntityTable;

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
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id_annonce")
	private Long idAnnonce;

	private Long codePostalBienCherche;

	private Long priMin;

	private Long prixMax;

	private Long surfaceBienCherche;

	private String typeBienCherche;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public Criterederecherche() {
	}

	public Long getIdAnnonce() {
		return this.idAnnonce;
	}

	public void setIdAnnonce(Long idAnnonce) {
		this.idAnnonce = idAnnonce;
	}

	public Long getCodePostalBienCherche() {
		return this.codePostalBienCherche;
	}

	public void setCodePostalBienCherche(Long codePostalBienCherche) {
		this.codePostalBienCherche = codePostalBienCherche;
	}

	public Long getPriMin() {
		return this.priMin;
	}

	public void setPriMin(Long priMin) {
		this.priMin = priMin;
	}

	public Long getPrixMax() {
		return this.prixMax;
	}

	public void setPrixMax(Long prixMax) {
		this.prixMax = prixMax;
	}

	public Long getSurfaceBienCherche() {
		return this.surfaceBienCherche;
	}

	public void setSurfaceBienCherche(Long surfaceBienCherche) {
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