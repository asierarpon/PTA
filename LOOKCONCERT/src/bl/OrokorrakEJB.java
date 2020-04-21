package bl;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dl.*;

/**
 * Session Bean implementation class OrokorrakEJB
 */
@Singleton
@LocalBean
public class OrokorrakEJB {

	@PersistenceContext
    private EntityManager em;
	private static final String mota= "erabiltzailea";
    
    public OrokorrakEJB() {
    }

    public int taldeaSartuDB(String izena, String deskribapena, String herrialdea, String musikaMota, 
    		boolean bakarkakoa, String webOrria, String pasahitza) {
    	int kodea=0; //Ez da arazorik egon
    	if(taldeaLortuDB(izena)!=null) kodea=1; // Badago talde bat izen horrekin
    	else {
    		TaldeakE taldeaE = new TaldeakE (izena,deskribapena,herrialdea,musikaMota,bakarkakoa,webOrria,pasahitza);
    		em.persist(taldeaE);
    	}
    	return kodea;
    }
    public TaldeakE taldeaLortuDB(String izena) {
    	return em.find(TaldeakE.class,izena);
    }
    public TaldeakE taldeaLortuPartaidetikDB(String username) {
    	return (TaldeakE)em.createNamedQuery("TaldePartaideakE.findTaldea").setParameter("username", username).getSingleResult();
    }
    public int taldeaEzabatuDB(String izena) {
		int kodea=0; //Ondo ezabatu da
		TaldeakE taldeaE=em.find(TaldeakE.class, izena);
		if(taldeaE!=null) em.remove(taldeaE);
		else kodea=1; //Irakasgai hori ez da existitzen DB-an
		return kodea;
	}
    public int taldePartaideaSartuDB(String username, Date jaiotzeData, String herrialdea, 
    		String taldeRola, String deskribapena, String taldeIzena) {
    	int kodea=0; //Ez da arazorik egon
    	TaldeakE taldeaE = taldeaLortuDB(taldeIzena);
    	TaldePartaideakE taldePartaideaE = new TaldePartaideakE(username,jaiotzeData,herrialdea, taldeRola,
				deskribapena, taldeaE);
    	if(taldeaE==null) kodea=1; //Ez dago talderik izen horrekin
    	else if(taldePartaideaLortuDB(username)!=null) kodea=2; //Izen horrekin jadanik partaide bat existitzen da
    	else em.persist(taldePartaideaE);
    	return kodea;
    }
    public int taldePartaideaSartuDB(String username, Date jaiotzeData, String herrialdea, 
    		String taldeRola, String deskribapena, String taldeIzena, String pasahitza) {
    	int kodea=0; //Ez da arazorik egon
    	TaldeakE taldeaE = taldeaLortuDB(taldeIzena);
    	TaldePartaideakE taldePartaideaE = new TaldePartaideakE(username, jaiotzeData, herrialdea, taldeRola,
				deskribapena, taldeaE);
    	if(taldeaE==null) kodea=1; //Ez dago talderik izen horrekin
    	else if(taldePartaideaLortuDB(username)!=null) kodea=2; //Izen horrekin jadanik partaide bat existitzen da
    	else if(taldeaE.getPasahitza().compareTo(pasahitza)!=0)kodea=3;//pasahitza ez dago ondo
    	else em.persist(taldePartaideaE);
    	return kodea;
    }
    public TaldePartaideakE taldePartaideaLortuDB(String username) {
    	return em.find(TaldePartaideakE.class,username);
    }
    public int taldeaPartaideaEzabatuDB(String username) {
		int kodea=0; //Ondo ezabatu da
		TaldePartaideakE taldeaPartaideaE=em.find(TaldePartaideakE.class, username);
		if(taldeaPartaideaE!=null) em.remove(taldeaPartaideaE);
		else kodea=1; //Irakasgai hori ez da existitzen DB-an
		return kodea;
	}
    public int erabiltzaileaSartuDB(String username, String password, String izena, String abizena, 
    		boolean taldePartaide) {
    	int kodea=0; //Ez da arazorik egon
    	if(taldePartaide) {
	    	TaldePartaideakE taldePartaideaE = taldePartaideaLortuDB(username);
	    	ErabiltzaileakE erabiltzaileaE = new ErabiltzaileakE(username, password, izena, abizena,
	    			taldePartaide, mota, taldePartaideaE);
	    	if(taldePartaideaE==null) kodea=1; // Ez dago partaiderik izen horrekin
	    	else if(erabiltzaileaLortuDB(username)!=null) kodea=2; //Erabiltzaile hori jadanik existitzen da
	    	else em.persist(erabiltzaileaE);
    	}
    	else {
    		ErabiltzaileakE erabiltzaileaE = new ErabiltzaileakE(username, password, izena, abizena, 
    				taldePartaide, mota, null);
    		if(erabiltzaileaLortuDB(username)!=null) kodea=2; //Erabiltzaile hori jadanik existitzen da
	    	else em.persist(erabiltzaileaE);
    	}
    	return kodea;
    }
    public ErabiltzaileakE erabiltzaileaLortuDB(String username) {
    	return em.find(ErabiltzaileakE.class, username);
    }
    @SuppressWarnings("unchecked")
	public List<ErabiltzaileakE> taldeErabiltzaileakLortuDB(String taldeIzena){
    	return (List<ErabiltzaileakE>)em.createNamedQuery("ErabiltzaileakE.findTaldeErabiltzaileak").setParameter("taldeIzena", taldeIzena).getResultList();
    }
    public int erabiltzaileaEzabatuDB(String username) {
		int kodea=0; //Ondo ezabatu da
		ErabiltzaileakE erabiltzaileaE=em.find(ErabiltzaileakE.class, username);
		if(erabiltzaileaE!=null) em.remove(erabiltzaileaE);
		else kodea=1; //Irakasgai hori ez da existitzen DB-an
		return kodea;
	}
    @SuppressWarnings("unchecked")
	public List<TaldeakE> taldeakBilatuDB(String izena,String herrialdea,String musikaMota, boolean bakarkakoa){
    	String query="SELECT t FROM TaldeakE t";
    	if(!izena.isEmpty()) query+=" WHERE t.izena LIKE '%"+izena+"%'";
    	if(!herrialdea.isEmpty()) {
    		if(!izena.isEmpty()) query+=" AND";
    		else query+=" WHERE";
    		query+=" t.herrialdea = '"+herrialdea+"'";
    	}
    	if(!musikaMota.isEmpty()) {
    		if(!izena.isEmpty()||!herrialdea.isEmpty()) query+=" AND";
    		else query+=" WHERE";
    		query+=" t.musikaMota = '"+musikaMota+"'";
    	}
    	if(!izena.isEmpty()||!herrialdea.isEmpty()||!musikaMota.isEmpty()) query+=" AND";
    	else query+=" WHERE";
    	query +=" t.bakarkakoa =: bakarkakoa";
    	return (List<TaldeakE>) em.createQuery(query).setParameter("bakarkakoa",bakarkakoa).getResultList();
    }
    @SuppressWarnings("unchecked")
	public List<TaldeakE> taldeakBilatuDB(String izena,String herrialdea,String musikaMota){
    	String query="SELECT t FROM TaldeakE t";
    	if(!izena.isEmpty()) query+=" WHERE t.izena LIKE '%"+izena+"%'";
    	if(!herrialdea.isEmpty()) {
    		if(!izena.isEmpty()) query+=" AND";
    		else query+=" WHERE";
    		query+=" t.herrialdea = '"+herrialdea+"'";
    	}
    	if(!musikaMota.isEmpty()) {
    		if(!izena.isEmpty()||!herrialdea.isEmpty()) query+=" AND";
    		else query+=" WHERE";
    		query+=" t.musikaMota = '"+musikaMota+"'";
    	}
    	return (List<TaldeakE>) em.createQuery(query).getResultList();
    }
    @SuppressWarnings("unchecked")
	public List<KontzertuakE> taldeKontzertuakLortuDB(String taldeIzena){
    	return (List<KontzertuakE>) em.createNamedQuery("KontzertuakE.findByTalde").setParameter("taldeIzena", taldeIzena).getResultList();
    }
    @SuppressWarnings("unchecked")
	public List<TaldeakE> modaLortuDB(){
    	return (List<TaldeakE>)em.createNamedQuery("GustokoenakE.findModa").setMaxResults(5).getResultList();
    }
}

