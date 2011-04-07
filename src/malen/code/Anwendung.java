package malen.code;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import com.db4o.Db4oEmbedded;
import com.db4o.EmbeddedObjectContainer;

public class Anwendung {

	// Constructors and Operations:
	public Anwendung()
	/**
	 * working constructor
	 **/
	{
	}

	public static void main(String[] aString) {
		final EmbeddedObjectContainer db = Db4oEmbedded.openFile(
				Db4oEmbedded.newConfiguration(), "malen.db40");

		JFrame f = new JFrame("Malen");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				db.close();
				super.windowClosing(e);
			}
		});
		
		Malen m = new Malen(db);
		m.setBehaelter(f.getContentPane());
		m.init();

		f.pack(); // Trick: Erzeugt Peer-Frame
		f.setSize(750, 500);
		f.setVisible(true);
	}

} // end Anwendung
