package bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.jboss.ejb3.annotation.SecurityDomain;

import dl.*;

/**
 * Session Bean implementation class ErabiltzaileaEJB
 */
@SecurityDomain("PTA")
@RolesAllowed("erabiltzailea")
@Stateful
@LocalBean
public class ErabiltzaileaEJB {

	@PersistenceContext
	private EntityManager em;
	@Resource
	EJBContext ejbContext;
	private ErabiltzaileakE erabiltzaileaE;
	
    public ErabiltzaileaEJB() {
        // TODO Auto-generated constructor stub
    }

    @PostConstruct
    private void login() {
    	String username=ejbContext.getCallerPrincipal().getName();
    	erabiltzaileaE=em.find(ErabiltzaileakE.class,username);
    }
    public List<TaldeakE> taldeGustokoenakLortuDB(){
    	@SuppressWarnings("unchecked")
		List<GustokoenakE> gustokoenakE = (List<GustokoenakE>)em.createNamedQuery("GustokoenakE.findErabiltzailkeak").setParameter("username",erabiltzaileaE.getUsername()).getResultList();
    	List<TaldeakE> taldeakE = new ArrayList<TaldeakE>();
    	for(int i=0;i<gustokoenakE.size();i++) {
    		taldeakE.add(gustokoenakE.get(i).getTaldeakE());
    	}
    	return taldeakE;
    }
    @SuppressWarnings("unchecked")
	public List<KontzertuakE> kontzertuakLortuDB(){
    	return (List<KontzertuakE>)em.createNamedQuery("KontzertuakE.findByPartaide").setParameter("username", erabiltzaileaE.getUsername()).getResultList();
    }
    public int kontzertuaEzabatuDB(int id) {
		int kodea=0; //Ondo ezabatu da
		KontzertuakE kontzertuakE=em.find(KontzertuakE.class, id);
		if(kontzertuakE!=null) em.remove(kontzertuakE);
		else kodea=1; //Kontzertu hori ez da existitzen DB-an
		return kodea;
	}
    public int kontzertuaSartuDB(Date data, String lekua, float sarreraPrezioa, String sarreraEsteka, int sarreraKop) {
    	int kodea=0;
    	erabiltzaileaE.getTaldePartaideakE().setTaldeakE(em.find(TaldeakE.class,erabiltzaileaE.getTaldePartaideakE().getTaldeakE().getIzena()));
    	if(erabiltzaileaE.getTaldePartaideakE().getTaldeakE()==null) kodea=1;//taldea ez da existitzen
    	else {
    	KontzertuakE kontzertuaE = new KontzertuakE(0,data,lekua,sarreraPrezioa,sarreraEsteka,sarreraKop,erabiltzaileaE.getTaldePartaideakE().getTaldeakE());
    	em.persist(kontzertuaE);
    	}
    	return kodea;
    }
    public boolean gustokoenaKonprobatu(String taldeIzena) {
    	try {
	    	taldeIzena = (String) em.createNamedQuery("GustokoenakE.taldeaExist")
					.setParameter("taldeIzena", taldeIzena)
					.setParameter("username", erabiltzaileaE.getUsername())
					.getSingleResult();
	    	return true;
    	}
    	catch(NoResultException e) {
    		return false;
    	}
    }
    public int gustokoenetanSartuDB(String taldeIzena){
    	int kodea=0;
    	//mirar problemas por cambios en la información del erabiltzaile desde otro sitio
    	TaldeakE taldeaE = em.find(TaldeakE.class,taldeIzena);
    	GustokoenakE gustokoenakE = new GustokoenakE(0,erabiltzaileaE,taldeaE);
    	if(taldeaE==null)kodea=1;//Ez da talderik existitzen izen horrekin
    	else em.persist(gustokoenakE);
    	return kodea;
    }
    public int gostokoenetatikEzabatuDB(String taldeIzena) {
    	int kodea=0;
    	try {
	    	GustokoenakE gustokoenakE = (GustokoenakE) em.createNamedQuery("GustokoenakE.findGustokoenakByErabiltzailea&talde")
	    			.setParameter("username", erabiltzaileaE.getUsername())
	    			.setParameter("taldeIzena", taldeIzena)
	    			.getSingleResult();
	    	em.remove(gustokoenakE);
    	}
    	catch(NoResultException e) {
    		kodea=1; //Ez dago talde hori gustokoenetan
    	}
    	return kodea;
    }
    public int taldeaEditatuDB(String izena, String deskribapena, String herrialdea, String musikaMota, 
    		boolean bakarkakoa, String webOrria, String pasahitza) {
    	int kodea=0; //Ez da arazorik egon
    	TaldeakE taldeaE = em.find(TaldeakE.class,izena);
    	if(taldeaE==null) kodea=1; // Taldea ez da existitzen
    	else {
    		
    		taldeaE.setDeskribapena(deskribapena);
    		taldeaE.setHerrialdea(herrialdea);
    		taldeaE.setMusikaMota(musikaMota);
    		taldeaE.setBakarkakoa(bakarkakoa);
    		taldeaE.setWebOrria(webOrria);
    		taldeaE.setPasahitza(pasahitza);
    		em.persist(taldeaE);
    	}
    	return kodea;
    }
    public int taldePartaideaEditatu(String herrialdea, String taldeRola, String deskribapena) {
    	int kodea=0; // taldea ondo sartu da
    	TaldePartaideakE taldePartaideaE = em.find(TaldePartaideakE.class,erabiltzaileaE.getUsername());
    	if(taldePartaideaE==null)kodea=1; //Ez da talde partaiderik existitzen izen horrekin
    	else {
    		taldePartaideaE.setHerrialdea(herrialdea);
    		taldePartaideaE.setTaldeRola(taldeRola);
    		taldePartaideaE.setDeskribapena(deskribapena);
    		em.persist(taldePartaideaE);
    	}
    	return kodea;
    }
}
