package malen.code;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.db4o.EmbeddedObjectContainer;

public class Malen implements MouseListener, MouseMotionListener {

	private Container behaelter;

	private int altesX;

	private int altesY;

	private Color aktuelleFarbe;
	{
		setAktuelleFarbe(Color.black);
	}

	private JTextField nameZeichnung;

	private JComboBox zeichnungWahl;

	private JPanel menue;

	private JPanel manag;

	private MalPanel aMalPanel = new MalPanel();

	private static final String RETRIEVE = "Retrieve";

	private static final String KOPIE = "Kopie";

	private static final String FLACH = "flach";

	private static final String TIEF = "tief";

	private static final String TIEFER = "tiefer";

	private static final String SCHWARZ = "Schwarz";

	private static final String ROT = "Rot";

	private static final String GELB = "Gelb";

	private static final String GRUEN = "Grün";

	private static final String BLAU = "Blau";

	private static final String ZYAN = "Zyan";

	private static final String MAGENTA = "Magenta";

	private Grafle[] aGrafle;
	{
		setGrafle(new Grafle[] { new Strich(0, 0, 0, 0, null),
				new DoppelStrich(0, 0, 0, 0, null, 5),
				new Rechteck(0, 0, 0, 0, null) });
	}

	private Grafle aktuellesGrafle = getGrafle(0);

	private Zeichnung[] aZeichnung;

	private EmbeddedObjectContainer db;
	{
		setZeichnung(new Zeichnung[0]);
	}

	// Constructors and Operations:
	public final Container getBehaelter() {
		return behaelter;
	}

	public final void setBehaelter(Container behaelter) {
		this.behaelter = behaelter;
	}

	public final int getAltesX() {
		return altesX;
	}

	private final void setAltesX(int altesX) {
		this.altesX = altesX;
	}

	public final int getAltesY() {
		return altesY;
	}

	private final void setAltesY(int altesY) {
		this.altesY = altesY;
	}

	public final Color getAktuelleFarbe() {
		return aktuelleFarbe;
	}

	private final void setAktuelleFarbe(Color aktuelleFarbe) {
		this.aktuelleFarbe = aktuelleFarbe;
	}

	public final JTextField getNameZeichnung() {
		return nameZeichnung;
	}

	private final void setNameZeichnung(JTextField nameZeichnung) {
		this.nameZeichnung = nameZeichnung;
	}

	public final JComboBox getZeichnungWahl() {
		return zeichnungWahl;
	}

	private final void setZeichnungWahl(JComboBox zeichnungWahl) {
		this.zeichnungWahl = zeichnungWahl;
	}

	public final JPanel getMenue() {
		return menue;
	}

	private final void setMenue(JPanel menue) {
		this.menue = menue;
	}

	public final JPanel getManag() {
		return manag;
	}

	private final void setManag(JPanel manag) {
		this.manag = manag;
	}

	public final MalPanel getMalPanel() {
		return aMalPanel;
	}

	private final void setMalPanel(MalPanel aMalPanel) {
		this.aMalPanel = aMalPanel;
	}

	public final Grafle[] getGrafle() {
		return aGrafle;
	}

	private final void setGrafle(Grafle[] aGrafle) {
		this.aGrafle = aGrafle;
	}

	public final int numGrafle() {
		return getGrafle().length;
	}

	private final void addGrafle(Grafle aGrafle) {
		Grafle[] x = getGrafle();
		Grafle[] y = new Grafle[x.length + 1];
		System.arraycopy(x, 0, y, 0, x.length);
		y[x.length] = aGrafle;
		setGrafle(y);
	}

	private final void addGrafle(Grafle[] aGrafle) {
		Grafle[] x = getGrafle();
		Grafle[] y = new Grafle[x.length + aGrafle.length];
		System.arraycopy(x, 0, y, 0, x.length);
		System.arraycopy(x, 0, y, x.length, aGrafle.length);
		setGrafle(y);
	}

	private final void rmvGrafle(Grafle aGrafle) {
		int ii = -1;
		boolean suchen = true;
		while (suchen) {
			int n = numGrafle();
			for (int i = 0; i < n; i++) {
				if (aGrafle == getGrafle(i)) {
					ii = i;
					break;
				}
			}
			if (ii >= 0) {
				rmvGrafle(ii);
				ii = -1;
			} else {
				suchen = false;
			}
		}
	}

	private final void rmvGrafle(int i) {
		Grafle[] x = getGrafle();
		Grafle[] y = new Grafle[x.length - 1];
		System.arraycopy(x, 0, y, 0, i);
		System.arraycopy(x, i + 1, y, i, y.length - i);
		setGrafle(y);
	}

	public final Grafle getGrafle(int i) {
		return getGrafle()[i];
	}

	private final void setGrafle(int i, Grafle aGrafle) {
		Grafle[] x = getGrafle();
		x[i] = aGrafle;
		setGrafle(x);
	}

	public final Grafle getAktuellesGrafle() {
		return aktuellesGrafle;
	}

	private final void setAktuellesGrafle(Grafle aktuellesGrafle) {
		this.aktuellesGrafle = aktuellesGrafle;
	}

	public final Zeichnung[] getZeichnung() {
		return aZeichnung;
	}

	private final void setZeichnung(Zeichnung[] aZeichnung) {
		this.aZeichnung = aZeichnung;
	}

	public final int numZeichnung() {
		return getZeichnung().length;
	}

	private final void addZeichnung(Zeichnung aZeichnung) {
		Zeichnung[] x = getZeichnung();
		Zeichnung[] y = new Zeichnung[x.length + 1];
		System.arraycopy(x, 0, y, 0, x.length);
		y[x.length] = aZeichnung;
		setZeichnung(y);
	}

	private final void addZeichnung(Zeichnung[] aZeichnung) {
		Zeichnung[] x = getZeichnung();
		Zeichnung[] y = new Zeichnung[x.length + aZeichnung.length];
		System.arraycopy(x, 0, y, 0, x.length);
		System.arraycopy(x, 0, y, x.length, aZeichnung.length);
		setZeichnung(y);
	}

	private final void rmvZeichnung(Zeichnung aZeichnung) {
		int ii = -1;
		boolean suchen = true;
		while (suchen) {
			int n = numZeichnung();
			for (int i = 0; i < n; i++) {
				if (aZeichnung == getZeichnung(i)) {
					ii = i;
					break;
				}
			}
			if (ii >= 0) {
				rmvZeichnung(ii);
				ii = -1;
			} else {
				suchen = false;
			}
		}
	}

	private final void rmvZeichnung(int i) {
		Zeichnung[] x = getZeichnung();
		Zeichnung[] y = new Zeichnung[x.length - 1];
		System.arraycopy(x, 0, y, 0, i);
		System.arraycopy(x, i + 1, y, i, y.length - i);
		setZeichnung(y);
	}

	public final Zeichnung getZeichnung(int i) {
		return getZeichnung()[i];
	}

	private final void setZeichnung(int i, Zeichnung aZeichnung) {
		Zeichnung[] x = getZeichnung();
		x[i] = aZeichnung;
		setZeichnung(x);
	}

	public Malen(EmbeddedObjectContainer db) {
		setDB(db);
	}

	private void setDB(EmbeddedObjectContainer db) {
		this.db = db;
	}
	
	private EmbeddedObjectContainer getDB() {
		return this.db;
	}

	public void init() {
		getBehaelter().setLayout(new BorderLayout());
		getBehaelter().setBackground(Color.gray);
		getMalPanel().setBackground(Color.gray);
		getBehaelter().add(getMalPanel(), BorderLayout.CENTER);

		setMenue(new JPanel());
		getMenue().setLayout(new FlowLayout());
		getBehaelter().add(getMenue(), BorderLayout.NORTH);

		setManag(new JPanel());
		getManag().setLayout(new FlowLayout());
		getBehaelter().add(getManag(), BorderLayout.SOUTH);

		machNameZeichnung();
		machAllesFrischKnopf();
		machFarbWahl();
		machGrafleWahl();
		machEndeKnopf();

		machUserKey();
		machNeueZeichnung();
		machKopie();
		machCreate();
		machRetrieve();
		machUpdate();
		machDelete();

		getMalPanel().addMouseMotionListener(this);
		getMalPanel().addMouseListener(this);
	}

	public void mouseDragged(MouseEvent e) {
		Graphics gr = getMalPanel().getGraphics();
		Grafle g = getAktuellesGrafle().newGrafle(getAltesX(), getAltesY(),
				e.getX(), e.getY(), getAktuelleFarbe());
		g.zeichne(gr);
		getMalPanel().addiere(g);
		setAltesX(e.getX());
		setAltesY(e.getY());
	}

	public void mouseMoved(MouseEvent e) {
		setAltesX(e.getX());
		setAltesY(e.getY());
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	private Zeichnung getAktuelleZeichnung() {
		return getMalPanel().getZeichnung();
	}

	private void setAktuelleZeichnung(Zeichnung aZeichnung) {
		getMalPanel().setZeichnung(aZeichnung);
		getNameZeichnung().setText(getAktuelleZeichnung().getName());
	}

	private void machAllesFrischKnopf() {
		JButton lk = new JButton("alles frisch");
		lk.setForeground(Color.black);
		lk.setBackground(Color.lightGray);
		getMenue().add(lk);
		lk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMalPanel().allesFrisch();
			}
		});
	}

	private void machEndeKnopf() {
		JButton ek = new JButton("Ende");
		ek.setForeground(Color.black);
		ek.setBackground(Color.lightGray);
		getMenue().add(ek);
		ek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDB().close();
				System.exit(0);
			}
		});
	}

	private void machFarbWahl() {
		final JComboBox fw = new JComboBox();
		fw.addItem(SCHWARZ);
		fw.addItem(ROT);
		fw.addItem(GELB);
		fw.addItem(GRUEN);
		fw.addItem(BLAU);
		fw.addItem(ZYAN);
		fw.addItem(MAGENTA);
		fw.setForeground(Color.black);
		fw.setBackground(Color.lightGray);
		getMenue().add(new JLabel("Farbe: "));
		getMenue().add(fw);
		fw.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getItem() == SCHWARZ)
					setAktuelleFarbe(Color.black);
				else if (e.getItem() == ROT)
					setAktuelleFarbe(Color.red);
				else if (e.getItem() == GELB)
					setAktuelleFarbe(Color.yellow);
				else if (e.getItem() == GRUEN)
					setAktuelleFarbe(Color.green);
				else if (e.getItem() == BLAU)
					setAktuelleFarbe(Color.blue);
				else if (e.getItem() == ZYAN)
					setAktuelleFarbe(Color.cyan);
				else if (e.getItem() == MAGENTA)
					setAktuelleFarbe(Color.magenta);
				fw.setForeground(getAktuelleFarbe());
			}
		});
	}

	private void machGrafleWahl() {
		JComboBox vw = new JComboBox();
		for (Grafle g : getGrafle()) {
			vw.addItem(g);
		}
		vw.setForeground(Color.black);
		vw.setBackground(Color.lightGray);
		getMenue().add(new JLabel("Grafletyp: "));
		getMenue().add(vw);
		vw.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setAktuellesGrafle((Grafle) e.getItem());
			}
		});
	}

	private void machNeueZeichnung() {
		JButton nz = new JButton("Neu");
		nz.setForeground(Color.black);
		nz.setBackground(Color.lightGray);
		getManag().add(nz);
		nz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAktuelleZeichnung(new Zeichnung());
				getBehaelter().repaint();
			}
		});
	}

	private void machNameZeichnung() {
		getMenue().add(new JLabel("Name:"));
		JTextField tf = new JTextField("ohne Namen");
		tf.setPreferredSize(new Dimension(100, 20));
		getMenue().add(tf);
		setNameZeichnung(tf);
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAktuelleZeichnung().setName(getNameZeichnung().getText());
			}
		});
	}

	private void machUserKey() {
		getManag().add(new JLabel("Userkey:"));
		JTextField tf = new JTextField("Userkey");
		tf.setPreferredSize(new Dimension(100, 20));
		getManag().add(tf);
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ???
			}
		});
	}

	private void machKopie() {
		final JComboBox kp = new JComboBox();
		kp.setForeground(Color.black);
		kp.setBackground(Color.lightGray);
		getManag().add(kp);
		kp.addItem(KOPIE);
		kp.addItem(FLACH);
		kp.addItem(TIEF);
		kp.addItem(TIEFER);
		kp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = kp.getSelectedItem();
				if (o != null && o != KOPIE) {
					Zeichnung z = getAktuelleZeichnung();
					Zeichnung zk = null;
					if (o == FLACH) {
						zk = z.flacheKopie();
					} else if (o == TIEF) {
						zk = z.tiefeKopie();
					} else if (o == TIEFER) {
						zk = z.tiefereKopie();
					}
					kp.setSelectedItem(KOPIE);
					setAktuelleZeichnung(zk);
					getBehaelter().repaint();
				}
			}
		});
	}

	private void machCreate() {
		final JButton cb = new JButton("Create (Speichern)");
		cb.setForeground(Color.black);
		cb.setBackground(Color.lightGray);
		getManag().add(cb);
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Zeichnung z = getAktuelleZeichnung();
				rmvZeichnung(z); // falls sie schon existiert
				addZeichnung(z);
				JComboBox zw = getZeichnungWahl();
				zw.removeAllItems();
				Zeichnung[] zz = getZeichnung();
				zw.addItem(RETRIEVE);
				for (Zeichnung z2 : zz)
					zw.addItem(z2);
				getBehaelter().repaint();
			}
		});
	}

	private void machRetrieve() {
		JComboBox zw = new JComboBox();
		setZeichnungWahl(zw);
		zw.addItem(RETRIEVE);
		for (Zeichnung z : getZeichnung()) {
			zw.addItem(z);
		}
		zw.setForeground(Color.black);
		zw.setBackground(Color.lightGray);
		getManag().add(zw);
		zw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = getZeichnungWahl().getSelectedItem();
				if (o != null && o != RETRIEVE) {
					setAktuelleZeichnung((Zeichnung) o);
				}
				getZeichnungWahl().setSelectedItem(RETRIEVE);
				getBehaelter().repaint();
			}
		});
	}

	private void machUpdate() {
		JButton up = new JButton("Update");
		up.setForeground(Color.black);
		up.setBackground(Color.lightGray);
		getManag().add(up);
		up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ???
			}
		});
	}

	private void machDelete() {
		JButton dz = new JButton("Delete");
		dz.setForeground(Color.black);
		dz.setBackground(Color.lightGray);
		getManag().add(dz);
		dz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rmvZeichnung(getAktuelleZeichnung());
				getZeichnungWahl().removeAllItems();
				Zeichnung[] zz = getZeichnung();
				JComboBox zw = getZeichnungWahl();
				zw.addItem(RETRIEVE);
				for (Zeichnung z : zz)
					zw.addItem(z);
				setAktuelleZeichnung(new Zeichnung());
				getBehaelter().repaint();
			}
		});
	}

} // end Malen
