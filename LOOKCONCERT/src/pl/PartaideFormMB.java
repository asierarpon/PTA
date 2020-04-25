package pl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class PartaideFormMB 
{
	private String rola;
	private String herrialdea;
	private String deskribapena;
	
	
	public PartaideFormMB() {
		super();
	}
	public PartaideFormMB(String rola, String herrialdea, String deskribapena) {
		super();
		this.rola = rola;
		this.herrialdea = herrialdea;
		this.deskribapena = deskribapena;
	}
	public String getRola() {
		return rola;
	}
	public void setRola(String rola) {
		this.rola = rola;
	}
	public String getHerrialdea() {
		return herrialdea;
	}
	public void setHerrialdea(String herrialdea) {
		this.herrialdea = herrialdea;
	}
	public String getDeskribapena() {
		return deskribapena;
	}
	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}
	
	public void clearForm() 
	{
		rola="";
		deskribapena="";
		herrialdea="";
	}
	
}
