package dl;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Kontzertuak database table.
 * 
 */
@Entity
@Table(name="Kontzertuak")
@NamedQuery(name="KontzertuakE.findAll", query="SELECT k FROM KontzertuakE k")
public class KontzertuakE implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKontzertuak;

	@Temporal(TemporalType.DATE)
	private Date data;

	private String lekua;
	
	private float sarreraPrezioa;

	private String sarreraEsteka;

	private int sarreraKop;

	//uni-directional many-to-one association to TaldeakE
	@ManyToOne
	@JoinColumn(name="fk_Taldeak_izena")
	private TaldeakE taldeakE;

	public KontzertuakE() {
	}

	public KontzertuakE(int idKontzertuak, Date data, String lekua, float sarreraPrezioa, String sarreraEsteka,
			int sarreraKop, TaldeakE taldeakE) {
		this.idKontzertuak = idKontzertuak;
		this.data = data;
		this.lekua = lekua;
		this.sarreraPrezioa = sarreraPrezioa;
		this.sarreraEsteka = sarreraEsteka;
		this.sarreraKop = sarreraKop;
		this.taldeakE = taldeakE;
	}

	public int getIdKontzertuak() {
		return this.idKontzertuak;
	}

	public void setIdKontzertuak(int idKontzertuak) {
		this.idKontzertuak = idKontzertuak;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getLekua() {
		return this.lekua;
	}

	public void setLekua(String lekua) {
		this.lekua = lekua;
	}

	public String getSarreraEsteka() {
		return this.sarreraEsteka;
	}

	public void setSarreraEsteka(String sarreraEsteka) {
		this.sarreraEsteka = sarreraEsteka;
	}

	public int getSarreraKop() {
		return this.sarreraKop;
	}

	public void setSarreraKop(int sarreraKop) {
		this.sarreraKop = sarreraKop;
	}

	public float getSarreraPrezioa() {
		return this.sarreraPrezioa;
	}

	public void setSarreraPrezioa(float sarreraPrezioa) {
		this.sarreraPrezioa = sarreraPrezioa;
	}

	public TaldeakE getTaldeakE() {
		return this.taldeakE;
	}

	public void setTaldeakE(TaldeakE taldeakE) {
		this.taldeakE = taldeakE;
	}

}