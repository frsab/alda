package fr.aldaimmobilier.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the annoncefavori database table.
 * 
 */
@Entity
@NamedQuery(name="Annoncefavori.findAll", query="SELECT a FROM Annoncefavori a")
public class Annoncefavori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_favoris")
	private int idFavoris;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-one association to Annonce
	@ManyToOne
	@JoinColumn(name="id_annonce")
	private Annonce annonce;

	public Annoncefavori() {
	}

	public int getIdFavoris() {
		return this.idFavoris;
	}

	public void setIdFavoris(int idFavoris) {
		this.idFavoris = idFavoris;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Annonce getAnnonce() {
		return this.annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

}