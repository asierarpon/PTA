package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Taldeak database table.
 * 
 */
@Entity
@Table(name="Taldeak")
@NamedQuery(name="TaldeakE.findAll", query="SELECT t FROM TaldeakE t")
public class TaldeakE implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String izena;
	
	private String deskribapena;	

	private String herrialdea;

	@Column(name="`musika mota`")
	private String musikaMota;
	
	private boolean bakarkakoa;

	private String webOrria;
	
	private String pasahitza;

	public TaldeakE() {
	}

	public TaldeakE(String izena, String deskribapena, String herrialdea, String musikaMota, boolean bakarkakoa,
			String webOrria, String pasahitza) {
		this.izena = izena;
		this.deskribapena = deskribapena;
		this.herrialdea = herrialdea;
		this.musikaMota = musikaMota;
		this.bakarkakoa = bakarkakoa;
		this.webOrria = webOrria;
		this.pasahitza = pasahitza;
	}

	public String getIzena() {
		return this.izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public boolean getBakarkakoa() {
		return this.bakarkakoa;
	}

	public void setBakarkakoa(boolean bakarkakoa) {
		this.bakarkakoa = bakarkakoa;
	}

	public String getDeskribapena() {
		return this.deskribapena;
	}

	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}

	public String getHerrialdea() {
		return this.herrialdea;
	}

	public void setHerrialdea(String herrialdea) {
		this.herrialdea = herrialdea;
	}

	public String getMusikaMota() {
		return this.musikaMota;
	}

	public void setMusikaMota(String musikaMota) {
		this.musikaMota = musikaMota;
	}

	public String getPasahitza() {
		return this.pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public String getWebOrria() {
		return this.webOrria;
	}

	public void setWebOrria(String webOrria) {
		this.webOrria = webOrria;
	}

}