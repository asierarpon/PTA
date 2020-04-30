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
	boolean partaide = true;

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

	public String erabiltzaileaSartu(ErabiltzaileFormMB e) {
		if (e.getErabiltzailemota() == 1) {
			partaide = false;
			kodea = aEJB.erabiltzaileaSartuDB(e.getErabiltzailea(), e.getPasahitza(), e.getIzena(), e.getAbizena(),
					partaide);
			if (kodea == 2) {
				mezua = "Aldatu erabiltzaile izena, erabiltzaile hori jadanik hartuta dago";
				buelta = "erregistro.xhtml";
			} else {
				buelta = "index.xhtml";
				e.clearForm();
			}
		} else {
			mezua = "KONTUZZZZ!!Izan nahi duzun erabiltzaile mota txarto aukeratuta daukaz";
			buelta = "erregistro.xhtml";
		}
		return buelta;
	}

	public void erabiltzaileaFormMantendu(ErabiltzaileFormMB e) {
		erabiltzailea = e;
	}

	public String partaideaSartuTaldeaSortu(TalderikGabeFormMB t) {
		boolean bakarkakoa = false;
		if (t.getBakarkakoa().equals("Bai")) {
			bakarkakoa = true;
		}

		kodea = aEJB.taldeaSartuDB(t.getTaldea(), t.getTaldedeskribapena(), t.getTaldeherrialdea(), t.getMusikamota(),
				bakarkakoa, t.getLink(), t.getPasahitzataldea());
		if (kodea == 0) {
			kodea = aEJB.taldePartaideaSartuDB(erabiltzailea.getErabiltzailea(), t.getJaiotzedata(), t.getHerrialdea(),
					t.getRola(), t.getDeskribapena(), t.getTaldea());
			if (kodea != 0) {
				mezua = "Badago paratide bat izen horrekin";
				aEJB.taldeaEzabatuDB(t.getTaldea());
				buelta = "erregistro.xhtml";
			} else {
				kodea = aEJB.erabiltzaileaSartuDB(erabiltzailea.getErabiltzailea(), erabiltzailea.getPasahitza(),
						erabiltzailea.getIzena(), erabiltzailea.getAbizena(), bakarkakoa);
				if (kodea == 2) {
					mezua = "Badago erabiltzaile bat izen horrekin";
					buelta = "erregistro.xhtml";
					aEJB.taldeaPartaideaEzabatuDB(erabiltzailea.getErabiltzailea());
				} else {
					buelta = "index.xhtml";
				}
			}
		} else {
			buelta = "erregistro.xhtml";
			mezua = "KONTUZ!!Badago talde bat izen horrekin,sartu berriz taldearen datuak";
		}
		return buelta;
	}

	public String partaideaSartuTaldeanSartu(TaldearekinFormMB t) {
		boolean partaidea1 = true;
		kodea = aEJB.taldePartaideaSartuDB(erabiltzailea.getErabiltzailea(), t.getJaiotzedata(), t.getHerrialdea(),
				t.getRola(), t.getDeskribapenaerab(), t.getTaldeizena(), t.getTaldepasahitza());
		if (kodea != 0) {
			switch (kodea) {
			case 1:
				mezua = "Ez dago talderik izen horrekin";
				break;
			case 2:
				mezua = "Jadanik existitzen da partaide bat izen horrekin";
			case 3:
				mezua = "Pasahitza ez da zuzena";
			}
			buelta = "erregistro.xhtml";
		} else {
			kodea = aEJB.erabiltzaileaSartuDB(erabiltzailea.getErabiltzailea(), erabiltzailea.getPasahitza(),
					erabiltzailea.getIzena(), erabiltzailea.getAbizena(), partaidea1);
			if (kodea != 0) {
				buelta = "erregistro.xhtml";
				aEJB.taldeaPartaideaEzabatuDB(erabiltzailea.getErabiltzailea());
				mezua = "Jadanik erabiltzaile da partaide bat izen horrekin";
			} else {
				buelta = "index.xhtml";
			}
		}
		return buelta;
	}
}
