package pl;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class FiltroakFormMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private String musikamota;
	private String izena;
	private String herrialdea;
	private String bakarkoa;

	public FiltroakFormMB(String musikamota, String izena, String herrialdea, String bakarkoa) {
		super();
		this.musikamota = musikamota;
		this.izena = izena;
		this.herrialdea = herrialdea;
		this.bakarkoa = bakarkoa;
	}

	public FiltroakFormMB() {
		super();
	}

	public String getMusikamota() {
		return musikamota;
	}

	public void setMusikamota(String musikamota) {
		this.musikamota = musikamota;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getHerrialdea() {
		return herrialdea;
	}

	public void setHerrialdea(String herrialdea) {
		this.herrialdea = herrialdea;
	}

	public String getBakarkoa() {
		return bakarkoa;
	}

	public void setBakarkoa(String bakarkoa) {
		this.bakarkoa = bakarkoa;
	}

	public void clearForm() {
		this.musikamota = "";
		this.izena = "";
		this.herrialdea = "";
		this.bakarkoa = "";
	}
}
