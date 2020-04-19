package pl;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


import bl.OrokorrakEJB;

@Named
@ViewScoped
public class ErregistratuAtazakMB implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EJB
	private OrokorrakEJB aEJB;
	
	private int kodea;
	private String mezua;
	private ErabiltzaileFormMB erabiltzailea;
	boolean partaide=true;
	
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



	public void erabiltzaileaSartu(ErabiltzaileFormMB e)
	{
		if(e.getErabiltzailemota()==1)
		{
			partaide=false;
		}
		
//		kodea=aEJB.erabiltzailearruntaSartuDB(e.getErabiltzailea(),e.getPasahitza(),e.getIzena(),e.getAbizena(),e.getDeskribapena(),partaide);
		e.clearForm();
	}
	
	public void erabiltzaileaFormMantendu(ErabiltzaileFormMB e)
	{
		System.out.println("000000000000000");
		erabiltzailea= e;
		System.out.println("KOPIA: "+e.getAbizena()+"KOPIA: "+erabiltzailea.getAbizena());
	}
	
	public void partaideaSartuTaldeaSortu(TalderikGabeFormMB t)
	{
		boolean bakarkakoa=false;
		if(t.getBakarkakoa().equals("Bai"))
		{
			bakarkakoa=true;
		}

		aEJB.taldeaSartuDB(t.getTaldea(),t.getTaldedeskribapena(),t.getTaldeherrialdea(),t.getMusikamota(),bakarkakoa,t.getLink(),t.getPasahitzataldea());
		aEJB.taldePartaideaSartuDB(erabiltzailea.getErabiltzailea(),t.getJaiotzedata(),t.getHerrialdea(),t.getRola(),t.getTaldea());
		aEJB.erabiltzaileaSartuDB(erabiltzailea.getErabiltzailea(),erabiltzailea.getPasahitza(),erabiltzailea.getIzena(),erabiltzailea.getAbizena(),erabiltzailea.getDeskribapena(),partaide);		
	}
	public void partaideaSartuTaldeanSartu(TaldearekinFormMB t)
	{
		//FALTA COMPROBAR SI EL TALDE ESTA BIEN
		aEJB.taldePartaideaSartuDB(erabiltzailea.getErabiltzailea(),t.getJaiotzedata(),t.getHerrialdea(),t.getRola(),t.getTaldeizena());
		aEJB.erabiltzaileaSartuDB(erabiltzailea.getErabiltzailea(),erabiltzailea.getPasahitza(),erabiltzailea.getIzena(),erabiltzailea.getAbizena(),erabiltzailea.getDeskribapena(),partaide);
	}
	
	
}
