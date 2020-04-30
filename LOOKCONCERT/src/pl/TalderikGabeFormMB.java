package pl;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class TalderikGabeFormMB {
	private Date jaiotzedata;
	private String herrialdea;
	private String taldea;
	private String pasahitzataldea;
	private String taldedeskribapena;
	private String taldeherrialdea;
	private String musikamota;
	private String link;
	private String bakarkakoa;
	private String rola;
	private String deskribapena;

	public TalderikGabeFormMB(Date jaiotzedata, String herrialdea, String taldea, String pasahitzataldea,
			String taldedeskribapena, String taldeherrialdea, String musikamota, String link, String bakarkakoa,
			String rola, String deskribapena) {
		super();
		this.jaiotzedata = jaiotzedata;
		this.herrialdea = herrialdea;
		this.taldea = taldea;
		this.pasahitzataldea = pasahitzataldea;
		this.taldedeskribapena = taldedeskribapena;
		this.taldeherrialdea = taldeherrialdea;
		this.musikamota = musikamota;
		this.link = link;
		this.bakarkakoa = bakarkakoa;
		this.rola = rola;
		this.deskribapena = deskribapena;
	}

	public TalderikGabeFormMB() {
		super();
	}

	public String getDeskribapena() {
		return deskribapena;
	}

	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}

	public String getRola() {
		return rola;
	}

	public void setRola(String rola) {
		this.rola = rola;
	}

	public Date getJaiotzedata() {
		return jaiotzedata;
	}

	public void setJaiotzedata(Date jaiotzedata) {
		this.jaiotzedata = jaiotzedata;
	}

	public String getHerrialdea() {
		return herrialdea;
	}

	public void setHerrialdea(String herrialdea) {
		this.herrialdea = herrialdea;
	}

	public String getTaldea() {
		return taldea;
	}

	public void setTaldea(String taldea) {
		this.taldea = taldea;
	}

	public String getPasahitzataldea() {
		return pasahitzataldea;
	}

	public void setPasahitzataldea(String pasahitzataldea) {
		this.pasahitzataldea = pasahitzataldea;
	}

	public String getTaldedeskribapena() {
		return taldedeskribapena;
	}

	public void setTaldedeskribapena(String taldedeskribapena) {
		this.taldedeskribapena = taldedeskribapena;
	}

	public String getTaldeherrialdea() {
		return taldeherrialdea;
	}

	public void setTaldeherrialdea(String taldeherrialdea) {
		this.taldeherrialdea = taldeherrialdea;
	}

	public String getMusikamota() {
		return musikamota;
	}

	public void setMusikamota(String musikamota) {
		this.musikamota = musikamota;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getBakarkakoa() {
		return bakarkakoa;
	}

	public void setBakarkakoa(String bakarkakoa) {
		this.bakarkakoa = bakarkakoa;
	}

	public void ClearFormMB() {

		this.jaiotzedata = null;
		this.herrialdea = "";
		this.taldea = "";
		this.pasahitzataldea = "";
		this.taldedeskribapena = "";
		this.taldeherrialdea = "";
		this.musikamota = "";
		this.link = "";
		this.bakarkakoa = "";
		this.rola = "";
		this.deskribapena = "";
	}

}
