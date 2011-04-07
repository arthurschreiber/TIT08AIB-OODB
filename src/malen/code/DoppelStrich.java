package malen.code;

import java.awt.*;

public class DoppelStrich extends Strich {

	private int delta;

	// Constructors and Operations:
	public final int getDelta() {
		return delta;
	}

	private final void setDelta(int delta) {
		this.delta = delta;
	}

	public DoppelStrich(int xa, int ya, int xe, int ye, Color aColor, int delta)
	/**
	 * working constructor
	 **/
	{
		super(xa, ya, xe, ye, aColor);
		setDelta(delta);
	}

	public void zeichne(Graphics aGraphics) {
		super.zeichne(aGraphics);
		aGraphics.drawLine(getXa() + getDelta(), getYa() + getDelta(), getXe()
				+ getDelta(), getYe() + getDelta());
	}

	public String toString() {
		return "DoppelStrich";
	}

	public Grafle newGrafle(int xa, int ya, int xe, int ye, Color aColor) {
		return new DoppelStrich(xa, ya, xe, ye, aColor, 5);
	}

} // end DoppelStrich
