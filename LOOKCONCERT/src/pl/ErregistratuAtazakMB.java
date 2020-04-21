package pl;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;


import bl.OrokorrakEJB;

@Named
@SessionScoped
public class ErregistratuAtazakMB implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EJB
	private OrokorrakEJB aEJB;
	
	private String buelta;
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

	public String erabiltzaileaSartu(ErabiltzaileFormMB e)
	{
		if(e.getErabiltzailemota()==1)
		{
			partaide=false;
			kodea=aEJB.erabiltzaileaSartuDB(e.getErabiltzailea(),e.getPasahitza(),e.getIzena(),e.getAbizena(),partaide);

			if(kodea==2)
			{
			mezua="Aldatu erabiltzaile izena, erabiltzaile hori jadanik hartuta dago";

			}
			else
			{
				buelta="sarreraorria.xhtml";
				e.clearForm();
			}
		}
		else
		{
			kodea=10;
			mezua="KONTUZZZZ!!Izan nahi duzun erabiltzaile mota txarto aukeratuta daukaz";
			buelta="erregistro.xhtml";
		}
		return buelta;
	}
	
	public void erabiltzaileaFormMantendu(ErabiltzaileFormMB e)
	{
		erabiltzailea= e;
	}
	
	public String partaideaSartuTaldeaSortu(TalderikGabeFormMB t)
	{
		boolean bakarkakoa=false;
		if(t.getBakarkakoa().equals("Bai"))
		{
			bakarkakoa=true;
		}
		System.out.println("Kodea lehen: "+kodea);
		kodea=aEJB.taldeaSartuDB(t.getTaldea(),t.getTaldedeskribapena(),t.getTaldeherrialdea(),t.getMusikamota(),bakarkakoa,t.getLink(),t.getPasahitzataldea());
		System.out.println("Kodea ondoren: "+kodea);		
		if(kodea==0)
		{
			buelta="sarreraorria.xhtml";
			
			aEJB.taldePartaideaSartuDB(erabiltzailea.getErabiltzailea(),t.getJaiotzedata(),t.getHerrialdea(),t.getRola(), t.getDeskribapena(),t.getTaldea());
			aEJB.erabiltzaileaSartuDB(erabiltzailea.getErabiltzailea(),erabiltzailea.getPasahitza(),erabiltzailea.getIzena(),erabiltzailea.getAbizena(),partaide);		
		}
		else
		{
			buelta="erregistro.xhtml";
			mezua="KONTUZ!!Badago talde bat izen horrekin,sartu berriz taldearen datuak";
		}
		return buelta;
	}
	public void partaideaSartuTaldeanSartu(TaldearekinFormMB t)
	{
		boolean partaidea1=true;
		//FALTA COMPROBAR SI EL TALDE ESTA BIEN
		aEJB.taldePartaideaSartuDB(erabiltzailea.getErabiltzailea(),t.getJaiotzedata(),t.getHerrialdea(),t.getRola(),t.getDeskribapenaerab(),t.getTaldeizena(),t.getTaldepasahitza());
		aEJB.erabiltzaileaSartuDB(erabiltzailea.getErabiltzailea(),erabiltzailea.getPasahitza(),erabiltzailea.getIzena(),erabiltzailea.getAbizena(),partaidea1);
	}
	
	
}
