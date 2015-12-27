package fr.aldaimmobilier.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the annonce database table.
 * 
 */
@Entity
@NamedQuery(name="Annonce.findAll", query="SELECT a FROM Annonce a")
public class Annonce implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_annonce")
	private int idAnnonce;

	private String adresse;

	private int codePostal;

	private int codeRegion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDeMiseEnLigne;

	private String description;

	private int prix;

	private String type;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-one association to Annoncefavori
	@OneToMany(mappedBy="annonce")
	private List<Annoncefavori> annoncefavoris;

	//bi-directional many-to-one association to Photo
	@OneToMany(mappedBy="annonce")
	private List<Photo> photos;

	public Annonce() {
	}

	public int getIdAnnonce() {
		return this.idAnnonce;
	}

	public void setIdAnnonce(int idAnnonce) {
		this.idAnnonce = idAnnonce;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public int getCodeRegion() {
		return this.codeRegion;
	}

	public void setCodeRegion(int codeRegion) {
		this.codeRegion = codeRegion;
	}

	public Date getDateDeMiseEnLigne() {
		return this.dateDeMiseEnLigne;
	}

	public void setDateDeMiseEnLigne(Date dateDeMiseEnLigne) {
		this.dateDeMiseEnLigne = dateDeMiseEnLigne;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrix() {
		return this.prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Annoncefavori> getAnnoncefavoris() {
		return this.annoncefavoris;
	}

	public void setAnnoncefavoris(List<Annoncefavori> annoncefavoris) {
		this.annoncefavoris = annoncefavoris;
	}

	public Annoncefavori addAnnoncefavori(Annoncefavori annoncefavori) {
		getAnnoncefavoris().add(annoncefavori);
		annoncefavori.setAnnonce(this);

		return annoncefavori;
	}

	public Annoncefavori removeAnnoncefavori(Annoncefavori annoncefavori) {
		getAnnoncefavoris().remove(annoncefavori);
		annoncefavori.setAnnonce(null);

		return annoncefavori;
	}

	public List<Photo> getPhotos() {
		return this.photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Photo addPhoto(Photo photo) {
		getPhotos().add(photo);
		photo.setAnnonce(this);

		return photo;
	}

	public Photo removePhoto(Photo photo) {
		getPhotos().remove(photo);
		photo.setAnnonce(null);

		return photo;
	}

}