package pl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import bl.OrokorrakEJB;
import dl.ErabiltzaileakE;
import dl.KontzertuakE;
import dl.TaldePartaideakE;
import dl.TaldeakE;


@Named
@ViewScoped
public class TaldeaViewMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private OrokorrakEJB zEJB;
	
	private TaldeakE taldea;
	
	private List<KontzertuakE> kontzertuak;
	
	private List<ErabiltzaileakE> partaideak;
	
	private TaldePartaideakE partaidearenInfo;
	
	private String taldeIzena;
	private String bakarra;
	private String taldekidea;
	
	
	public String getBakarra() {
		return bakarra;
	}



	public void setBakarra(String bakarra) {
		this.bakarra = bakarra;
	}


	
	
	
	
	public String getTaldeIzena() {
		return taldeIzena;
	}



	public void setTaldeIzena(String taldeIzena) {
		this.taldeIzena = taldeIzena;
	}
	
	



	public String getTaldekidea() {
		return taldekidea;
	}



	public void setTaldekidea(String taldekidea) {
		this.taldekidea = taldekidea;
	}



	public void taldearenIzenaLortu(String izena) {
		
		taldeIzena=izena;
		
	}

	public TaldeakE informazioaLortuDB(String izena){
		
		taldea=zEJB.taldeaLortuDB(izena);
		
		
		if(taldea.getBakarkakoa()==true) {
			bakarra="BAI";
		}else {
			bakarra="EZ";
		}
		
		return taldea;
	}
	
	public List<KontzertuakE> kontzertuakLortu(String izena){
		
		kontzertuak=zEJB.taldeKontzertuakLortuDB(izena);
	
		return kontzertuak;
	}
	
	public List<ErabiltzaileakE> taldePartaideakLortu(String izena) {
		
		partaideak=zEJB.taldeErabiltzaileakLortuDB(izena);
		
		return partaideak;
	}
	
	public TaldePartaideakE partaidearenInfoaLortu(String partaidea) {
		
		partaidearenInfo=zEJB.taldePartaideaLortuDB(partaidea);
		
		return partaidearenInfo;
	}
	
	public String klikatutakoTaldekideaGorde(String partaideIzena) {
		
		taldekidea=partaideIzena;
		return taldekidea;
	}
	
	

}
