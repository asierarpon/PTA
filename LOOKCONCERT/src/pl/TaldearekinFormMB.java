package pl;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class TaldearekinFormMB 
{
	private String deskribapena;
	private Date jaiotzedata;
	private String herrialdea;
	private String taldeizena;
	private String taldepasahitza;
	private String rola;
	private String deskribapenaerab;
	
	public TaldearekinFormMB(String deskribapena, Date jaiotzedata, String herrialdea, String taldeizena,
			String taldepasahitza, String rola, String deskribapenaerab) {
		super();
		this.deskribapena = deskribapena;
		this.jaiotzedata = jaiotzedata;
		this.herrialdea = herrialdea;
		this.taldeizena = taldeizena;
		this.taldepasahitza = taldepasahitza;
		this.rola=rola;
		this.deskribapena=deskribapenaerab;
	}

	public String getDeskribapenaerab() {
		return deskribapenaerab;
	}

	public void setDeskribapenaerab(String deskribapenaerab) {
		this.deskribapenaerab = deskribapenaerab;
	}

	public TaldearekinFormMB() {
		super();
	}

	public String getRola() {
		return rola;
	}

	public void setRola(String rola) {
		this.rola = rola;
	}

	public String getDeskribapena() {
		return deskribapena;
	}

	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
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

	public String getTaldeizena() {
		return taldeizena;
	}

	public void setTaldeizena(String taldeizena) {
		this.taldeizena = taldeizena;
	}

	public String getTaldepasahitza() {
		return taldepasahitza;
	}

	public void setTaldepasahitza(String taldepasahitza) {
		this.taldepasahitza = taldepasahitza;
	}
	
	public void clearFormMB() {

		this.deskribapena = "";
		this.jaiotzedata = null;
		this.herrialdea = "";
		this.taldeizena = "";
		this.taldepasahitza = "";
		this.rola="";
		this.deskribapenaerab="";
	}
	
	
	
}
