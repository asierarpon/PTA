package pl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import bl.ErabiltzaileaEJB;
import bl.OrokorrakEJB;
import dl.KontzertuakE;
import dl.TaldePartaideakE;
import dl.TaldeakE;

@Named
@ViewScoped
public class EditatuViewMB implements Serializable {

	@EJB
	private ErabiltzaileaEJB aEJB;

	@EJB
	private OrokorrakEJB oEJB;

	private List<KontzertuakE> kontzertuak;
	private TaldeakE taldeak;
	private TaldePartaideakE partaide;
	private static final long serialVersionUID = 1L;
	private String bakarkakoa;
	private String partaideIzena;

	public List<KontzertuakE> kontzertuakBistaratu() {
		if (kontzertuak == null) {
			kontzertuak = aEJB.kontzertuakLortuDB();
		}
		return kontzertuak;
	}

	public TaldeakE taldeInformazioa(String username) {
		
		if (taldeak == null) {
			taldeak = oEJB.taldeaLortuPartaidetikDB(username);
			if(taldeak.getBakarkakoa())bakarkakoa="Bai";
			else bakarkakoa="Ez";
		}
		return taldeak;

	}

	public TaldePartaideakE partaideInformazioa(String username) {

		if (partaide == null) {
			partaide = oEJB.taldePartaideaLortuDB(username);
			partaideIzena=oEJB.erabiltzaileaLortuDB(username).getIzena();
		}
		return partaide;

	}

	public void resetView() {
		kontzertuak = null;
		taldeak = null;
		partaide = null;
	}

	public TaldeakE getTaldeak() {
		return taldeak;
	}

	public void setTaldeak(TaldeakE taldeak) {
		this.taldeak = taldeak;
	}

	public TaldePartaideakE getPartaide() {
		return partaide;
	}

	public void setPartaide(TaldePartaideakE partaide) {
		this.partaide = partaide;
	}

	public String getBakarkakoa() {
		return bakarkakoa;
	}

	public void setBakarkakoa(String bakarkakoa) {
		this.bakarkakoa = bakarkakoa;
	}

	public String getPartaideIzena() {
		return partaideIzena;
	}

	public void setPartaideIzena(String partaideIzena) {
		this.partaideIzena = partaideIzena;
	}

}
