package fr.aldaimmobilier.EntityTable;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the annonce database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Annonce.findAll", query="SELECT a FROM Annonce a"),
	@NamedQuery(name="Annonce.findByDate",query="SELECT a FROM Annonce a WHERE a.idAnnonce =:Id")
})
public class Annonce implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id_annonce")
	private Long idAnnonce;

	private String adresse;

	private Long codePostal;

	private Long codeRegion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDeMiseEnLigne;

	private String description;

	private Long prix;

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

	public Long getIdAnnonce() {
		return this.idAnnonce;
	}

	public void setIdAnnonce(Long idAnnonce) {
		this.idAnnonce = idAnnonce;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Long getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(Long codePostal) {
		this.codePostal = codePostal;
	}

	public Long getCodeRegion() {
		return this.codeRegion;
	}

	public void setCodeRegion(Long codeRegion) {
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

	public Long getPrix() {
		return this.prix;
	}

	public void setPrix(Long prix) {
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