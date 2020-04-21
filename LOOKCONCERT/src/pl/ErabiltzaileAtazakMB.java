package pl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import bl.ErabiltzaileaEJB;



@Named
@SessionScoped
public class ErabiltzaileAtazakMB implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int kodea=5;
	private String mezua;
	private String autentikatutakoa;
	

	@PostConstruct
	public void autentikatutakoaLortu()
	{
		autentikatutakoa=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
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


	@EJB
	private ErabiltzaileaEJB aEJB;
	

	public void clearForm() 
	{
		kodea=0;
		mezua="";
		autentikatutakoa="";	
	}
	
	

}
