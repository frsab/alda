package fr.aldaimmobilier.EntityTable;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the photo database table.
 * 
 */
@Entity
@NamedQuery(name="Photo.findAll", query="SELECT p FROM Photo p")
public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id_photo")
	private Long idPhoto;

	private String url;

	//bi-directional many-to-one association to Annonce
	@ManyToOne
	@JoinColumn(name="id_annonce")
	private Annonce annonce;

	public Photo() {
	}

	public Long getIdPhoto() {
		return this.idPhoto;
	}

	public void setIdPhoto(Long idPhoto) {
		this.idPhoto = idPhoto;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Annonce getAnnonce() {
		return this.annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

}