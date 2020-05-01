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
	private OrokorrakEJB oEJB;
	@EJB
	private ErabiltzaileaEJB eEJB;

	private TaldeakE taldea;

	private List<KontzertuakE> kontzertuak;

	private List<ErabiltzaileakE> partaideak;

	private TaldePartaideakE partaidearenInfo;

	private String partaideIzena;
	private String taldeIzena;
	private String bakarra;
	private String taldekidea;
	private String mezua = "";
	private int kodemezua;

	public String getPartaideIzena() {
		return partaideIzena;
	}

	public void setPartaideIzena(String partaideIzena) {
		this.partaideIzena = partaideIzena;
	}

	public String getMezua() {
		return mezua;
	}

	public void setMezua(String mezua) {
		this.mezua = mezua;
	}

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
		taldeIzena = izena;
	}

	public TaldeakE informazioaLortuDB() {

		taldea = oEJB.taldeaLortuDB(taldeIzena);

		if (taldea.getBakarkakoa() == true) {
			bakarra = "Bai";
		} else {
			bakarra = "Ez";
		}

		return taldea;
	}

	public List<KontzertuakE> kontzertuakLortu() {

		kontzertuak = oEJB.taldeKontzertuakLortuDB(taldeIzena);

		return kontzertuak;
	}

	public List<ErabiltzaileakE> taldePartaideakLortu() {

		partaideak = oEJB.taldeErabiltzaileakLortuDB(taldeIzena);

		return partaideak;
	}

	public TaldePartaideakE partaidearenInfoaLortu() {

		ErabiltzaileakE erabiltzaileaE = oEJB.erabiltzaileaLortuDB(taldekidea);
		partaidearenInfo = oEJB.taldePartaideaLortuDB(taldekidea);
		partaideIzena = erabiltzaileaE.getIzena();

		return partaidearenInfo;
	}

	public void klikatutakoTaldekideaGorde(String partaideIzena) {

		taldekidea = partaideIzena;
	}

	public boolean gustokoaEzGustokoa() {

		boolean emaitza = eEJB.gustokoenaKonprobatu(taldeIzena);
		return emaitza;
	}

	public void gustokoetanSartu() {
		int kodea = eEJB.gustokoenetanSartuDB(taldeIzena);

		if (kodea == 0) {
			mezua = "TALDEA GUSTOKOETAN SARTU DA.";
		} else {
			mezua = "ERRORE BAT GERTATATU DA.";
		}

	}

	public void gustokotikKendu() {
		int kodea = eEJB.gostokoenetatikEzabatuDB(taldeIzena);
		if (kodea == 0) {
			mezua = "TALDEA GUSTOKOETAN SARTU DA.";
		} else {
			mezua = "ERRORE BAT GERTATATU DA.";
		}
	}

	public int mezuaKonprobatu() {
		kodemezua = 1;
		if (mezua.equals("")) {
			kodemezua = 2;
		}

		return kodemezua;
	}

}
