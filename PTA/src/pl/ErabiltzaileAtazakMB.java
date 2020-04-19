package pl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import bl.ErabiltzaileaEJB;



@Named
@RequestScoped
public class ErabiltzaileAtazakMB {
	
	private String pasahitza;
	private String logina;
	private int kodea=5;
	private String mezua;
	
	
	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public String getLogina() {
		return logina;
	}

	public void setLogina(String logina) {
		this.logina = logina;
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
	
	public boolean loginaKonprobatu()
	{
		System.out.println("Sartu da");
		kodea=aEJB.login(logina,pasahitza);
		boolean a=false;
		switch(kodea)
		{
		case 0:
			a=true;
			mezua="ONDO LOGEATU DA";
			break;
		case 1:
			a=false;
			mezua="LOGINA EZ DA EXITITZEN";
			break;
		case 2:
			a=false;
			mezua="PASAHITZA EZ DA ZUZENA";
			break;
		}
		return a;
	}
	public void clearForm() 
	{
		kodea=0;
		mezua="";
		logina="";
		pasahitza="";
		
	}
	
	

}
