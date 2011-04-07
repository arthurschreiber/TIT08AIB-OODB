package malen.code;
import	java.awt.*;
import	javax.swing.*;

public class	MalPanel
	extends		JPanel
	{

	private Zeichnung	aZeichnung;
		{
		setZeichnung (new Zeichnung ());
		}

	//	Constructors and Operations:
	public final Zeichnung	getZeichnung ()
		{
		return aZeichnung;
		}

	public final void	setZeichnung (Zeichnung aZeichnung)
		{
		this.aZeichnung = aZeichnung;
		}

	public 	MalPanel ()
		{
		}

	public void	addiere (Grafle aGrafle)
		{
		getZeichnung ().addiere (aGrafle);
		}

	public void	allesFrisch ()
		{
		setZeichnung (new Zeichnung ());
		repaint ();
		}

	public void	paintComponent (Graphics aGraphics)
		{
		super.paintComponent (aGraphics);
		for (Grafle g : getZeichnung ().getKurve ())
			{
			g.zeichne (aGraphics);
			}
		}

	}	//	end MalPanel
