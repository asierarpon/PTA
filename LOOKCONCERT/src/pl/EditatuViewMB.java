package pl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import bl.ErabiltzaileaEJB;
import dl.KontzertuakE;

@Named
@ViewScoped
public class EditatuViewMB implements Serializable 
{
	
	@EJB
	private ErabiltzaileaEJB aEJB;
	
	private List<KontzertuakE> kontzertuak;
	private static final long serialVersionUID = 1L;

	
	public List<KontzertuakE> kontzertuakBistaratu()
	{
		return aEJB.kontzertuakLortuDB();
	}
	

	
	public void resetView()
	{
		kontzertuak=null;
	}

}
