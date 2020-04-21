package dl;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TaldePartaideak database table.
 * 
 */
@Entity
@Table(name="TaldePartaideak")
@NamedQueries({
@NamedQuery(name="TaldePartaideakE.findAll", query="SELECT t FROM TaldePartaideakE t"),
@NamedQuery(name="TaldePartaideakE.findTaldea", query="SELECT t.taldeakE FROM TaldePartaideakE t WHERE t.username=:username")
})
public class TaldePartaideakE implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	@Temporal(TemporalType.DATE)
	@Column(name="`jaiotze data`")
	private Date jaiotzeData;
	
	private String herrialdea;

	private String taldeRola;
	
	private String deskribapena;

	//uni-directional many-to-one association to TaldeakE
	@ManyToOne
	@JoinColumn(name="fk_Taldeak_izena")
	private TaldeakE taldeakE;

	public TaldePartaideakE() {
	}

	public TaldePartaideakE(String username, Date jaiotzeData, String herrialdea, String taldeRola,
			String deskribapena, TaldeakE taldeakE) {
		this.username = username;
		this.jaiotzeData = jaiotzeData;
		this.herrialdea = herrialdea;
		this.taldeRola = taldeRola;
		this.deskribapena = deskribapena;
		this.taldeakE = taldeakE;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHerrialdea() {
		return this.herrialdea;
	}

	public void setHerrialdea(String herrialdea) {
		this.herrialdea = herrialdea;
	}

	public Date getJaiotzeData() {
		return this.jaiotzeData;
	}

	public void setJaiotzeData(Date jaiotzeData) {
		this.jaiotzeData = jaiotzeData;
	}

	public String getTaldeRola() {
		return this.taldeRola;
	}

	public void setTaldeRola(String taldeRola) {
		this.taldeRola = taldeRola;
	}

	public String getDeskribapena() {
		return deskribapena;
	}

	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}

	public TaldeakE getTaldeakE() {
		return this.taldeakE;
	}

	public void setTaldeakE(TaldeakE taldeakE) {
		this.taldeakE = taldeakE;
	}

}