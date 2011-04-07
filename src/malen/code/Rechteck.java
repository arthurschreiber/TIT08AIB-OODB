package malen.code;

import java.awt.*;

public class Rechteck extends Strich {

	// Constructors and Operations:
	public Rechteck(int xa, int ya, int xe, int ye, Color aColor)
	/**
	 * working constructor
	 **/
	{
		super(xa, ya, xe, ye, aColor);
	}

	public void zeichne(Graphics aGraphics) {
		aGraphics.setColor(getFarbe());
		aGraphics.drawRect(Math.min(getXa(), getXe()),
				Math.min(getYa(), getYe()), Math.abs(getXa() - getXe()),
				Math.abs(getYa() - getYe()));
	}

	public String toString() {
		return "Rechteck";
	}

	public Grafle newGrafle(int xa, int ya, int xe, int ye, Color aColor) {
		return new Rechteck(xa, ya, xe, ye, aColor);
	}

} // end Rechteck
