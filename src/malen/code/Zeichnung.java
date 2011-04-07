package malen.code;
import	java.util.*;

public class	Zeichnung
	{

	private String	name = "ohne Namen";

	private ArrayList<Grafle>	kurve;
		{
		setKurve (new ArrayList<Grafle> ());
		}

	//	Constructors and Operations:
	public final String	getName ()
		{
		return name;
		}

	public final void	setName (String name)
		{
		this.name = name;
		}

	public final ArrayList<Grafle>	getKurve ()
		{
		return kurve;
		}

	private final void	setKurve (ArrayList<Grafle> kurve)
		{
		this.kurve = kurve;
		}

	public 	Zeichnung ()
		{
		}

	public void	addiere (Grafle aGrafle)
		{
		getKurve ().add (aGrafle);
		}

	public String	toString ()
		{
		return getName ();
		}

	public Zeichnung	flacheKopie ()
		{
		Zeichnung	zk = new Zeichnung ();
		zk.setName (getName () + "(flache Kopie)");
		zk.setKurve (getKurve ());
		return zk;
		}

	public Zeichnung	tiefeKopie ()
		{
		Zeichnung	zk = new Zeichnung ();
		zk.setName (getName () + "(tiefe Kopie)");
		//zk.setKurve ((ArrayList<Grafle>) getKurve ().clone ());
		ArrayList<Grafle> neu = new ArrayList<Grafle> ();
		ArrayList<Grafle> old = getKurve ();
		for (Grafle g : old)
			{
			neu.add (g);
			} 
		zk.setKurve (neu);
		return zk;
		}

	public Zeichnung	tiefereKopie ()
		{
		Zeichnung	zk = new Zeichnung ();
		zk.setName (getName () + "(tiefere Kopie)");
		ArrayList<Grafle> neu = new ArrayList<Grafle> ();
		ArrayList<Grafle> old = getKurve ();
		for (Grafle g : old)
			{
			neu.add (g.kopie ());
			} 
		zk.setKurve (neu);
		return zk;
		}

	}	//	end Zeichnung
