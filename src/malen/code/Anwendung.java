package malen.code;

import javax.swing.*;

public class Anwendung {

	// Constructors and Operations:
	public Anwendung()
	/**
	 * working constructor
	 **/
	{
	}

	public static void main(String[] aString) {
		JFrame f = new JFrame("Malen");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Malen m = new Malen();
		m.setBehaelter(f.getContentPane());
		m.init();

		f.pack(); // Trick: Erzeugt Peer-Frame
		f.setSize(750, 500);
		f.setVisible(true);
	}

} // end Anwendung
