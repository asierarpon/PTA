package bl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dl.*;

/**
 * Session Bean implementation class ErabiltzaileaEJB
 */
@Stateful
@LocalBean
public class ErabiltzaileaEJB {

	@PersistenceContext
	private EntityManager em;
	private ErabiltzaileakE erabiltzaileaE;
	
    public ErabiltzaileaEJB() {
        // TODO Auto-generated constructor stub
    }

    public int login(String username,String password) {
    	int kodea=0; // username==password
    	erabiltzaileaE=em.find(ErabiltzaileakE.class,username);
    	if(erabiltzaileaE==null) kodea=1; // username ez da existitzen
    	else if(erabiltzaileaE.getPassword().compareTo(password)!=0) kodea=2; //username!=password
    	return kodea;
    }
    public List<TaldeakE> taldeGustokoenakLortuDB(String username){
    	@SuppressWarnings("unchecked")
		List<GustokoenakE> gustokoenakE = (List<GustokoenakE>)em.createNamedQuery("GustokoenakE.findErabiltzailkeak").setParameter("username",username).getResultList();
    	List<TaldeakE> taldeakE = new ArrayList<TaldeakE>();
    	for(int i=0;i<gustokoenakE.size();i++) {
    		taldeakE.add(gustokoenakE.get(i).getTaldeakE());
    	}
    	return taldeakE;
    }
   
}
