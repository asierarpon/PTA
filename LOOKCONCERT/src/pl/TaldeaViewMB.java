package pl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import bl.ErabiltzaileaEJB;
import bl.OrokorrakEJB;
import dl.ErabiltzaileakE;
import dl.KontzertuakE;
import dl.TaldePartaideakE;
import dl.TaldeakE;


@Named
@SessionScoped
public class TaldeaViewMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private OrokorrakEJB zEJB;
	@EJB
	private ErabiltzaileaEJB eEJB;
	
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

	public TaldeakE informazioaLortuDB(){
		
		taldea=zEJB.taldeaLortuDB(taldeIzena);
		
		
		if(taldea.getBakarkakoa()==true) {
			bakarra="BAI";
		}else {
			bakarra="EZ";
		}
		
		return taldea;
	}
	
	public List<KontzertuakE> kontzertuakLortu(){
		
		kontzertuak=zEJB.taldeKontzertuakLortuDB(taldeIzena);
	
		return kontzertuak;
	}
	
	public List<ErabiltzaileakE> taldePartaideakLortu() {
		
		partaideak=zEJB.taldeErabiltzaileakLortuDB(taldeIzena);
		
		return partaideak;
	}
	
	public TaldePartaideakE partaidearenInfoaLortu() {
		
		System.out.println("El nombre 2222 es:"+taldekidea);
		partaidearenInfo=zEJB.taldePartaideaLortuDB(taldekidea);
		
		return partaidearenInfo;
	}
	
	public void klikatutakoTaldekideaGorde(String partaideIzena) {
		
		taldekidea=partaideIzena;
		System.out.println("El nombre 1111 es:"+taldekidea);
		
	}
	
	/*public boolean gustokoaEzGustokoa() {
		
		List<TaldeakE> gustokoak=eEJB.taldeGustokoenakLortuDB();
		boolean emaitza=true;
		
		if(gustokoak.){
			
		}
		
		return emaitza;
	}*/
	
	

}
