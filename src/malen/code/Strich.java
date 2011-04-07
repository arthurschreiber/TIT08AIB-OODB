package malen.code;
import	java.awt.*;

public class	Strich
	implements	Grafle
	{

	private int	xa;

	private int	ya;

	private int	xe;

	private int	ye;

	private Color	farbe;

	//	Constructors and Operations:
	public final int	getXa ()
		{
		return xa;
		}

	private final void	setXa (int xa)
		{
		this.xa = xa;
		}

	public final int	getYa ()
		{
		return ya;
		}

	private final void	setYa (int ya)
		{
		this.ya = ya;
		}

	public final int	getXe ()
		{
		return xe;
		}

	private final void	setXe (int xe)
		{
		this.xe = xe;
		}

	public final int	getYe ()
		{
		return ye;
		}

	private final void	setYe (int ye)
		{
		this.ye = ye;
		}

	public final Color	getFarbe ()
		{
		return farbe;
		}

	private final void	setFarbe (Color farbe)
		{
		this.farbe = farbe;
		}

	public 	Strich
		(
		int	xa,
		int	ya,
		int	xe,
		int	ye,
		Color	farbe
		)
		/**
		*	working constructor
		**/
		{
		setXa (xa);
		setYa (ya);
		setXe (xe);
		setYe (ye);
		setFarbe (farbe);
		}

	public void	zeichne (Graphics aGraphics)
		{
		aGraphics.setColor (getFarbe ());
		aGraphics.drawLine (getXa (), getYa (), getXe (), getYe ());
		}

	public String	toString ()
		{
		return "Strich";
		}

	public Grafle	newGrafle
		(
		int	xa,
		int	ya,
		int	xe,
		int	ye,
		Color	aColor
		)
		{
		return new Strich (xa, ya, xe, ye, aColor);
		}

	public Grafle	kopie ()
		{
		return newGrafle (getXa (), getYa (), getXe (), getYe (), 
			getFarbe ());
		}

	}	//	end Strich
