package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Erabiltzaileak database table.
 * 
 */
@Entity
@Table(name="Erabiltzaileak")
@NamedQueries({
@NamedQuery(name="ErabiltzaileakE.findAll", query="SELECT e FROM ErabiltzaileakE e"),
@NamedQuery(name="ErabiltzaileakE.findTaldeErabiltzaileak", query="SELECT e FROM ErabiltzaileakE e WHERE e.taldePartaideakE.taldeakE.izena =:taldeIzena")
})
public class ErabiltzaileakE implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;
	
	private String password;
	 
	private String izena;

	private String abizena;

	private boolean taldePartaide;
	
	private String mota;

	//uni-directional many-to-one association to TaldePartaideakE
	@ManyToOne
	@JoinColumn(name="fk_TaldePartaideak_username")
	private TaldePartaideakE taldePartaideakE;

	public ErabiltzaileakE() {
	}

	public ErabiltzaileakE(String username, String password, String izena, String abizena,
			boolean taldePartaide, String mota, TaldePartaideakE taldePartaideakE) {
		this.username = username;
		this.password = password;
		this.izena = izena;
		this.abizena = abizena;
		this.taldePartaide = taldePartaide;
		this.mota = mota;
		this.taldePartaideakE = taldePartaideakE;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAbizena() {
		return this.abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public String getIzena() {
		return this.izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getTaldePartaide() {
		return this.taldePartaide;
	}

	public void setTaldePartaide(boolean taldePartaide) {
		this.taldePartaide = taldePartaide;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public TaldePartaideakE getTaldePartaideakE() {
		return this.taldePartaideakE;
	}

	public void setTaldePartaideakE(TaldePartaideakE taldePartaideakE) {
		this.taldePartaideakE = taldePartaideakE;
	}

}