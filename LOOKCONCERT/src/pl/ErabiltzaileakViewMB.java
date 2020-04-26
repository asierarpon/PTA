package pl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import bl.ErabiltzaileaEJB;
import bl.OrokorrakEJB;
import dl.TaldeakE;

@Named
@ViewScoped
public class ErabiltzaileakViewMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private OrokorrakEJB zEJB;
	
	@EJB
	private ErabiltzaileaEJB aEJB;
	
	private List <TaldeakE> modakoakDB;
	private List <TaldeakE> gustokoenakDB;
	private List <TaldeakE> filtroakDB;
	
	public List <TaldeakE> modakoakLortuDB()
	{
		

			modakoakDB=zEJB.modaLortuDB();	

		return modakoakDB;
	}
	
	public List <TaldeakE> gustokoenakLortuDB()
	{

			gustokoenakDB=aEJB.taldeGustokoenakLortuDB();

		return gustokoenakDB;
	}
	public void filtroakDB(FiltroakFormMB a)
	{
		String mota;
		if(a.getMusikamota().equals("None"))
		{
			mota="";
		}
		else
		{
			mota=a.getMusikamota();
		}
		filtroakDB=null;
		boolean b=true;

		if(filtroakDB==null)
		{
			if(a.getBakarkoa().equals("none"))
			{
				filtroakDB=zEJB.taldeakBilatuDB(a.getIzena(), a.getHerrialdea(), mota);
			}
			else
			{
				if(a.getBakarkoa().equals("Ez"))
				{
					b=false;
				}
				filtroakDB=zEJB.taldeakBilatuDB(a.getIzena(), a.getHerrialdea(),mota,b);
			}
		}
	}
	
	public List <TaldeakE> filtratutakoakBilatuDB(FiltroakFormMB a)
	{
	//	a.clearForm();
		return filtroakDB;
	}
	
	
	public void resetView()
	{
		modakoakDB=null;
		gustokoenakDB=null;
		filtroakDB=null;
	}
	
}
