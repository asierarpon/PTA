package bl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
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
		else kodea=1; //Irakasgai hori ez da existitzen DB-an
		return kodea;
	}
}
