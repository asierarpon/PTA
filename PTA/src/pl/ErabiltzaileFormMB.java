package pl;


import java.io.Serializable;


import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ErabiltzaileFormMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int erabiltzailemota;
	private String erabiltzailea;
	private String pasahitza;
	private String izena;
	private String abizena;
	private String deskribapena;
	
	
	
	public ErabiltzaileFormMB(int erabiltzailemota, String erabiltzailea, String pasahitza, String izena,
			String abizena, String deskribapena) {
		super();
		this.erabiltzailemota = erabiltzailemota;
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.izena = izena;
		this.abizena = abizena;
		this.deskribapena=deskribapena;
	}
	
	
	public String getDeskribapena() {
		return deskribapena;
	}


	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}


	public ErabiltzaileFormMB() {
		super();
	}

	public int getErabiltzailemota() {
		return erabiltzailemota;
	}
	public void setErabiltzailemota(int erabiltzailemota) {
		this.erabiltzailemota = erabiltzailemota;
	}
	public String getErabiltzailea() {
		return erabiltzailea;
	}
	public void setErabiltzailea(String erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}
	public String getPasahitza() {
		return pasahitza;
	}
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public String getAbizena() {
		return abizena;
	}
	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}
	
	public void clearForm() {

		erabiltzailemota=0;
		erabiltzailea = "";
		pasahitza = "";
		izena = "";
		abizena = "";
	}
	
	

}
