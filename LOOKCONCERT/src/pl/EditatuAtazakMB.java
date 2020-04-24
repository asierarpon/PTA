package pl;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import bl.ErabiltzaileaEJB;
import dl.KontzertuakE;

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
}
