package pl;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import bl.ErabiltzaileaEJB;
import dl.KontzertuakE;
import dl.TaldePartaideakE;
import dl.TaldeakE;

@Named
@SessionScoped
public class EditatuAtazakMB  implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private int kodea=2;
	private String mezua;

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


	@EJB
	private ErabiltzaileaEJB aEJB;
	
	public void kontzertuaKenduMB(KontzertuakE a, EditatuViewMB b)
	{
		kodea=aEJB.kontzertuaEzabatuDB(a.getIdKontzertuak());
		if(kodea==0)
		{
			mezua="Ondo borratu da kontzertua";
		}
		else if(kodea==1)
		{
			mezua="Ez da ondo borratu";
		}
		b.resetView();
	}
	
	public void kontzertuaSartu(KontzertuaFormMB a, EditatuViewMB b)
	{
		kodea=aEJB.kontzertuaSartuDB(a.getData(), a.getLekua(), a.getPrezioa(), a.getEsteka(), a.getKopurua());
		System.out.println("Kodearen balioa: "+kodea);
	if(kodea==1)
	{
		mezua="Kontzertua ez da ondo sartu";
	}
	else
	{
		mezua="Kontzertua ond sartu da";
	}
		a.clearForm();
		b.resetView();
	}
	
	public void reset()
	{
		kodea=2;
		mezua="";
	}
	
	public void taldeInformazioAldatu(TaldeaFormMB d, EditatuViewMB a)
	{
		String deskribapena;
		String herrialdea;
		 String mota;
		boolean bakarkakoa;
		String link;

		if(d.getTaldedeskribapena().equals(""))
		{
			deskribapena=a.getTaldeak().getDeskribapena();
		}
		else
		{
			deskribapena=d.getTaldedeskribapena();
		}
		if(d.getLink().equals(""))
		{
			link=a.getTaldeak().getWebOrria();
		}
		else
		{
			link=d.getLink();
		}
		if(d.getTaldeherrialdea().equals(""))
		{
			herrialdea=a.getTaldeak().getHerrialdea();
		}
		else
		{
			herrialdea=d.getTaldeherrialdea();
		}
		if(d.getBakarkakoa().equals("none"))
		{
			bakarkakoa=a.getTaldeak().getBakarkakoa();
		}
		else
		{
			if(d.getBakarkakoa().equals("Bai"))
			{
				bakarkakoa=true;
			}
			else
			{
				bakarkakoa=false;
			}
		}
		if(d.getMusikamota().equals("None"))
		{
			mota=a.getTaldeak().getMusikaMota();
		}
		else
		{
			mota=d.getMusikamota();
		}
		
		aEJB.taldeaEditatuDB(a.getTaldeak().getIzena(),deskribapena,herrialdea,mota,bakarkakoa,link,a.getTaldeak().getPasahitza());
		d.reset();
		a.resetView();
	}
	public void partaideInformazioAldatu(PartaideFormMB d, EditatuViewMB a)
	{
		String rola;
		String deskribapena;
		String herrialdea;
		if(d.getDeskribapena().equals(""))
		{
			deskribapena=(a.getPartaide().getDeskribapena());
		}
		else
		{
			deskribapena=(d.getDeskribapena());
		}
		
		if(d.getHerrialdea().equals(""))
		{
			herrialdea=(a.getPartaide().getHerrialdea());
		}
		else
		{
			herrialdea=(d.getHerrialdea());
		}
		
		if(d.getRola().equals(""))
		{
			rola=(a.getPartaide().getTaldeRola());
		}
		else
		{
			rola=(d.getRola());
		}
		
		aEJB.taldePartaideaEditatu(herrialdea,rola,deskribapena);
		d.clearForm();;
		a.resetView();
	}
}
