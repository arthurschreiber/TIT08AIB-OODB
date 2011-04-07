package malen.code;
import	java.awt.*;

public interface	Grafle
	{

	void	zeichne (Graphics aGraphics);

	Grafle	newGrafle
		(
		int	xa,
		int	ya,
		int	xe,
		int	ye,
		Color	aColor
		);

	String	toString ();

	Grafle	kopie ();

	}	//	end Grafle
