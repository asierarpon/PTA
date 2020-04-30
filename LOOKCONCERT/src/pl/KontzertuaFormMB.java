package pl;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class KontzertuaFormMB {
	private Date data;
	private String lekua;
	private float prezioa;
	private String esteka;
	private int kopurua;

	public KontzertuaFormMB() {
		super();
	}

	public KontzertuaFormMB(Date data, String lekua, float prezioa, String esteka, int kopurua) {
		super();
		this.data = data;
		this.lekua = lekua;
		this.prezioa = prezioa;
		this.esteka = esteka;
		this.kopurua = kopurua;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getLekua() {
		return lekua;
	}

	public void setLekua(String lekua) {
		this.lekua = lekua;
	}

	public float getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(float prezioa) {
		this.prezioa = prezioa;
	}

	public String getEsteka() {
		return esteka;
	}

	public void setEsteka(String esteka) {
		this.esteka = esteka;
	}

	public int getKopurua() {
		return kopurua;
	}

	public void setKopurua(int kopurua) {
		this.kopurua = kopurua;
	}

	public void clearForm() {
		this.data = null;
		this.lekua = "";
		this.prezioa = 0.0f;
		this.esteka = "";
		this.kopurua = 0;
	}

}
