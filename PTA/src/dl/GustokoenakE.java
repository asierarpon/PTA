package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Gustokoenak database table.
 * 
 */
@Entity
@Table(name="Gustokoenak")
@NamedQueries({
@NamedQuery(name="GustokoenakE.findAll", query="SELECT g FROM GustokoenakE g"),
@NamedQuery(name="GustokoenakE.findErabiltzailkeak", query="SELECT g FROM GustokoenakE g WHERE g.erabiltzaileakE.username=:username"),
@NamedQuery(name="GustokoenakE.findModa", query="SELECT g.taldeakE FROM GustokoenakE g"),
})
public class GustokoenakE implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGustokoenak;

	//uni-directional many-to-one association to ErabiltzaileakE
	@ManyToOne
	@JoinColumn(name="fk_Erabiltzaileak_username")
	private ErabiltzaileakE erabiltzaileakE;

	//uni-directional many-to-one association to TaldeakE
	@ManyToOne
	@JoinColumn(name="fk_Taldeak_izena")
	private TaldeakE taldeakE;

	public GustokoenakE() {
	}

	public GustokoenakE(int idGustokoenak, ErabiltzaileakE erabiltzaileakE, TaldeakE taldeakE) {
		this.idGustokoenak = idGustokoenak;
		this.erabiltzaileakE = erabiltzaileakE;
		this.taldeakE = taldeakE;
	}

	public int getIdGustokoenak() {
		return this.idGustokoenak;
	}

	public void setIdGustokoenak(int idGustokoenak) {
		this.idGustokoenak = idGustokoenak;
	}

	public ErabiltzaileakE getErabiltzaileakE() {
		return this.erabiltzaileakE;
	}

	public void setErabiltzaileakE(ErabiltzaileakE erabiltzaileakE) {
		this.erabiltzaileakE = erabiltzaileakE;
	}

	public TaldeakE getTaldeakE() {
		return this.taldeakE;
	}

	public void setTaldeakE(TaldeakE taldeakE) {
		this.taldeakE = taldeakE;
	}

}