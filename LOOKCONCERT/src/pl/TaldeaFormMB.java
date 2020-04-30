package pl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped

public class TaldeaFormMB {
	private String taldedeskribapena;
	private String taldeherrialdea;
	private String musikamota;
	private String link;
	private String bakarkakoa;

	public TaldeaFormMB() {
		super();
	}

	public TaldeaFormMB(String taldedeskribapena, String taldeherrialdea, String musikamota, String link,
			String bakarkakoa) {
		super();
		this.taldedeskribapena = taldedeskribapena;
		this.taldeherrialdea = taldeherrialdea;
		this.musikamota = musikamota;
		this.link = link;
		this.bakarkakoa = bakarkakoa;
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

	public void reset() {
		this.taldedeskribapena = "";
		this.taldeherrialdea = "";
		this.musikamota = "";
		this.link = "";
		this.bakarkakoa = "";
	}

}
