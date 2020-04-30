package pl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import bl.OrokorrakEJB;
import dl.ErabiltzaileakE;

@Named
@SessionScoped
public class ErabiltzaileAtazakMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private int kodea = 5;
	private String mezua;
	private String autentikatutakoa;

	@EJB
	private OrokorrakEJB aEJB;

	private ErabiltzaileakE erab;

	@PostConstruct
	public void autentikatutakoaLortu() {
		autentikatutakoa = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
		erab = aEJB.erabiltzaileaLortuDB(autentikatutakoa);

	}

	public String getAutentikatutakoa() {
		return autentikatutakoa;
	}

	public int getKodea() {
		return kodea;
	}

	public void setKodea(int kodea) {
		this.kodea = kodea;
	}

	public String getMezua() {
		return mezua;
	}

	public void setMezua(String mezua) {
		this.mezua = mezua;
	}

	public void clearForm() {
		kodea = 0;
		mezua = "";
		autentikatutakoa = "";
		erab = null;
	}

	public ErabiltzaileakE getErab() {
		return erab;
	}

	public void setErab(ErabiltzaileakE erab) {
		this.erab = erab;
	}

}
