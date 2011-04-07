package bank.code;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankGUI {

	private java.util.List<Bank> banken;

	private Bank aBank;

	private Konto aKonto;

	private JFrame aJFrame;

	private JPanel karten;

	private JPanel auswahl;

	private ActionListener kontenListener;

	private JComboBox bankAuswahl = new JComboBox();;

	private JComboBox kontoAuswahl = new JComboBox();;

	private JLabel fehlerMeldung;

	private Bank vonBank;

	private Konto vonKonto;

	private Bank nachBank;

	private Konto nachKonto;

	private JComboBox bankVonAuswahl = new JComboBox();;

	private JComboBox kontoVonAuswahl = new JComboBox();;

	private JComboBox bankNachAuswahl = new JComboBox();;

	private JComboBox kontoNachAuswahl = new JComboBox();;

	private JTextField ueberweisungBetrag = new JTextField("");;

	private JLabel ueberweisungMeldung = new JLabel(" ");;

	private String kontoArt;

	// Constructors and Operations:
	public final java.util.List<Bank> getBanken() {
		return banken;
	}

	private final void setBanken(java.util.List<Bank> banken) {
		this.banken = banken;
	}

	public final Bank getBank() {
		return aBank;
	}

	private final void setBank(Bank aBank) {
		this.aBank = aBank;
	}

	public final Konto getKonto() {
		return aKonto;
	}

	private final void setKonto(Konto aKonto) {
		this.aKonto = aKonto;
	}

	public final JFrame getJFrame() {
		return aJFrame;
	}

	private final void setJFrame(JFrame aJFrame) {
		this.aJFrame = aJFrame;
	}

	public final JPanel getKarten() {
		return karten;
	}

	private final void setKarten(JPanel karten) {
		this.karten = karten;
	}

	public final JPanel getAuswahl() {
		return auswahl;
	}

	private final void setAuswahl(JPanel auswahl) {
		this.auswahl = auswahl;
	}

	public final ActionListener getKontenListener() {
		return kontenListener;
	}

	private final void setKontenListener(ActionListener kontenListener) {
		this.kontenListener = kontenListener;
	}

	public final JComboBox getBankAuswahl() {
		return bankAuswahl;
	}

	private final void setBankAuswahl(JComboBox bankAuswahl) {
		this.bankAuswahl = bankAuswahl;
	}

	public final JComboBox getKontoAuswahl() {
		return kontoAuswahl;
	}

	private final void setKontoAuswahl(JComboBox kontoAuswahl) {
		this.kontoAuswahl = kontoAuswahl;
	}

	public final JLabel getFehlerMeldung() {
		return fehlerMeldung;
	}

	private final void setFehlerMeldung(JLabel fehlerMeldung) {
		this.fehlerMeldung = fehlerMeldung;
	}

	public final Bank getVonBank() {
		return vonBank;
	}

	private final void setVonBank(Bank vonBank) {
		this.vonBank = vonBank;
	}

	public final Konto getVonKonto() {
		return vonKonto;
	}

	private final void setVonKonto(Konto vonKonto) {
		this.vonKonto = vonKonto;
	}

	public final Bank getNachBank() {
		return nachBank;
	}

	private final void setNachBank(Bank nachBank) {
		this.nachBank = nachBank;
	}

	public final Konto getNachKonto() {
		return nachKonto;
	}

	private final void setNachKonto(Konto nachKonto) {
		this.nachKonto = nachKonto;
	}

	public final JComboBox getBankVonAuswahl() {
		return bankVonAuswahl;
	}

	private final void setBankVonAuswahl(JComboBox bankVonAuswahl) {
		this.bankVonAuswahl = bankVonAuswahl;
	}

	public final JComboBox getKontoVonAuswahl() {
		return kontoVonAuswahl;
	}

	private final void setKontoVonAuswahl(JComboBox kontoVonAuswahl) {
		this.kontoVonAuswahl = kontoVonAuswahl;
	}

	public final JComboBox getBankNachAuswahl() {
		return bankNachAuswahl;
	}

	private final void setBankNachAuswahl(JComboBox bankNachAuswahl) {
		this.bankNachAuswahl = bankNachAuswahl;
	}

	public final JComboBox getKontoNachAuswahl() {
		return kontoNachAuswahl;
	}

	private final void setKontoNachAuswahl(JComboBox kontoNachAuswahl) {
		this.kontoNachAuswahl = kontoNachAuswahl;
	}

	public final JTextField getUeberweisungBetrag() {
		return ueberweisungBetrag;
	}

	private final void setUeberweisungBetrag(JTextField ueberweisungBetrag) {
		this.ueberweisungBetrag = ueberweisungBetrag;
	}

	public final JLabel getUeberweisungMeldung() {
		return ueberweisungMeldung;
	}

	private final void setUeberweisungMeldung(JLabel ueberweisungMeldung) {
		this.ueberweisungMeldung = ueberweisungMeldung;
	}

	public final String getKontoArt() {
		return kontoArt;
	}

	private final void setKontoArt(String kontoArt) {
		this.kontoArt = kontoArt;
	}

	public BankGUI(java.util.List<Bank> banken) {
		setBanken(banken);
		if (getBanken().size() > 0) {
			setBank(getBanken().get(0));
			if (getBank().numKonto() > 0)
				setKonto(getBank().getKonto(0));
		}

		setJFrame(new JFrame("Bankanwendung"));
		getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container jp = getJFrame().getContentPane();
		jp.setLayout(new BorderLayout());

		setAuswahl(new JPanel());
		getAuswahl().setLayout(new GridLayout(0, 1));
		getAuswahl().setBackground(Color.gray);
		jp.add(getAuswahl(), BorderLayout.WEST);

		JLabel fehler = new JLabel("");
		fehler.setForeground(Color.red);
		setFehlerMeldung(fehler);
		jp.add(getFehlerMeldung(), BorderLayout.SOUTH);

		setKarten(new JPanel());
		getKarten().setLayout(new CardLayout());
		getKarten().setBackground(new Color(63, 63, 63));
		jp.add(getKarten(), BorderLayout.CENTER);

		getKarten().add(new JPanel(), "LeereKarte");

		machBankAuswahl();

		machKontoAuswahl();

		machKarteKontenStaende();

		machKarteEinAuszahlung();

		machKarteUeberweisung();

		machKarteKontoAnlegen();

		machKarteBankAnlegen();

		machKontoLoeschknopf();

		machBankLoeschknopf();

		machEndeknopf();

		getJFrame().pack();
		getJFrame().setSize(700, 400);
		getJFrame().setVisible(true);
	}

	public void machEndeknopf() {
		JButton knopf = new JButton("Exit");
		getAuswahl().add(knopf);
		knopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				System.exit(0);
			}
		});
	}

	public void machKontoLoeschknopf() {
		JButton knopf = new JButton("aktuelles Konto löschen");
		getAuswahl().add(knopf);
		knopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				getBank().rmvKonto(getKonto());
				getKontoAuswahl().removeItem(getKonto());
			}
		});
	}

	public void machBankLoeschknopf() {
		JButton knopf = new JButton("aktuelle Bank löschen");
		getAuswahl().add(knopf);
		knopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				int k;
				while ((k = getBank().numKonto() - 1) >= 0) {
					Konto ko = getBank().getKonto(k);
					getBank().rmvKonto(k);
					getKontoAuswahl().removeItem(ko);
				}
				getBanken().remove(getBank());
				getBankAuswahl().removeItem(getBank());
				if (getBanken().size() == 0)
					setBank(null);
			}
		});
	}

	public void machBankAuswahl() {
		JComboBox c = getBankAuswahl();
		for (Bank b : getBanken()) {
			c.addItem(b);
		}
		getAuswahl().add(c);
		c.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				setBank((Bank) ev.getItem());
				getKontoAuswahl().removeAllItems();
				if (getBank() != null)
					for (Konto k : getBank().getKonto()) {
						getKontoAuswahl().addItem(k);
					}
				((CardLayout) getKarten().getLayout()).show(getKarten(),
						"LeereKarte");
			}
		});
	}

	public void machKontoAuswahl() {
		JComboBox c = getKontoAuswahl();
		if (getBank() != null)
			for (Konto k : getBank().getKonto()) {
				c.addItem(k);
			}
		getAuswahl().add(c);
		c.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				setKonto((Konto) ev.getItem());
				((CardLayout) getKarten().getLayout()).show(getKarten(),
						"LeereKarte");
			}
		});
	}

	public void machKarteKontenStaende() {
		final JPanel karte = new JPanel();
		karte.setLayout(new GridBagLayout());
		getKarten().add(karte, "KontenStände");

		JButton knopf = new JButton("Kontenstände");
		getAuswahl().add(knopf);
		setKontenListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				zeigKonten(karte);
				((CardLayout) getKarten().getLayout()).show(getKarten(),
						"KontenStände");
				karte.validate();
				karte.repaint();
			}
		});
		knopf.addActionListener(getKontenListener());
	}

	private void zeigKonten(JPanel p) {
		GridBagConstraints c = new GridBagConstraints();
		p.removeAll();
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 2;
		if (getBank() != null) {
			p.add(new JLabel("Bank: " + getBank().toString()), c);
			c.gridx = 1;
			c.gridy = 2;
			c.gridwidth = 2;
			p.add(new JLabel("Konto:"), c);
			c.gridx = 3;
			c.gridy = 2;
			c.gridwidth = 1;
			p.add(new JLabel("Kontostand:"), c);
			c.gridx = 3;
			c.gridy = 3;
			c.gridwidth = 1;
			p.add(new JLabel("------------------"), c);
			for (Konto k : getBank().getKonto()) {
				c.gridx = 1;
				++c.gridy;
				c.anchor = GridBagConstraints.WEST;
				c.gridwidth = 2;
				p.add(new JLabel(k.toString() + "  "), c);
				c.gridx = 3;
				c.anchor = GridBagConstraints.EAST;
				c.gridwidth = 1;
				p.add(new JLabel(k.getEuro()), c);
			}
		}
		p.invalidate();
	}

	public void machKarteEinAuszahlung() {
		final JPanel karte = new JPanel();
		karte.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		getKarten().add(karte, "EinAuszahlung");

		JButton knopf = new JButton("Ein-/Auszahlung");
		getAuswahl().add(knopf);
		knopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				((CardLayout) getKarten().getLayout()).show(getKarten(),
						"EinAuszahlung");
			}
		});
		c.gridx = 2;
		c.gridy = 1;
		karte.add(new JLabel("----------------------------------"), c);
		c.gridx = 1;
		c.gridy = 2;
		karte.add(new JLabel("Einzuzahlender Betrag :"), c);
		final JTextField t = new JTextField();
		c.gridx = 2;
		c.gridy = 2;
		c.fill = GridBagConstraints.BOTH;
		karte.add(t, c);
		c.gridx = 1;
		c.gridy = 3;
		karte.add(new JLabel("Auszuzahlender Betrag :"), c);
		final JTextField t2 = new JTextField();
		c.gridx = 2;
		c.gridy = 3;
		c.fill = GridBagConstraints.BOTH;
		karte.add(t2, c);
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (getKonto() == null) {
					t.setText("");
					t2.setText("");
					getKontenListener().actionPerformed(null);
					return;
				}
				String s;
				boolean falsch = false;
				getFehlerMeldung().setText("");
				if ((s = t.getText().trim()).length() != 0) {
					try {
						// System.err.println (getKonto ().getEuro ());
						getKonto().einzahlen(s);
						// System.err.println ("Eingezahlt (" + s + ") " +
						// getKonto ().getEuro ());
					} catch (EuroFormatFehler e) {
						t.setText(s + " ist falsch!");
						getFehlerMeldung().setText(e.toString());
						falsch = true;
					}
				}
				if ((s = t2.getText().trim()).length() != 0) {
					try {
						// System.err.println (getKonto ().getEuro ());
						getKonto().auszahlen(s);
						// System.err.println ("Ausgezahlt (" + s + ") " +
						// getKonto ().getEuro ());
					} catch (KontoFehler e) {
						t2.setText(s + " ist falsch!");
						getFehlerMeldung().setText(e.toString());
						falsch = true;
					} catch (EuroFormatFehler e) {
						t2.setText(s + " ist falsch!");
						getFehlerMeldung().setText(e.toString());
						falsch = true;
					}
				}
				if (!falsch) {
					t.setText("");
					t2.setText("");
					getKontenListener().actionPerformed(null);
				}
			}
		};
		t.addActionListener(al);
		t2.addActionListener(al);
	}

	public void machKarteBankAnlegen() {
		JButton knopf = new JButton("neue Bank");
		getAuswahl().add(knopf);
		knopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				((CardLayout) getKarten().getLayout()).show(getKarten(),
						"BankAnlegen");
			}
		});

		final JPanel karte = new JPanel();
		getKarten().add(karte, "BankAnlegen");
		karte.setLayout(new GridBagLayout());
		final GridBagConstraints c = new GridBagConstraints();

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3, 2));
		p.add(new JLabel("Name der neuen Bank: "));
		final JTextField t = new JTextField();
		p.add(t);
		p.add(new JLabel("BLZ  der neuen Bank: "));
		final JTextField t2 = new JTextField();
		p.add(t2);
		p.add(new JLabel("Userkey  der neuen Bank: "));
		final JTextField t3 = new JTextField();
		p.add(t3);
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (t.getText().trim().length() != 0
						&& t2.getText().trim().length() != 0) {
					Bank b;
					getBanken().add(
							b = new Bank(t.getText().trim(), t2.getText()
									.trim()));
					// b.setUserKey (t3.getText().trim ());
					++c.gridy;
					karte.add(new JLabel(b.toString()), c);
					getBankAuswahl().addItem(b);
					t.setText("");
					t2.setText("");
					t3.setText("");
				}
				karte.invalidate();
				getKarten().validate();
				getKarten().repaint();
			}
		};
		t.addActionListener(al);
		t2.addActionListener(al);
		t3.addActionListener(al);
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight = 3;
		karte.add(p, c);

		c.gridx = 1;
		c.gridy = 4;
		c.gridheight = 1;
		karte.add(new JLabel("---"), c);
		++c.gridy;
		karte.add(new JLabel("Angelegte Banken:"), c);
		++c.gridy;
		karte.add(new JLabel("-----------------"), c);
		for (Bank b : getBanken()) {
			++c.gridy;
			karte.add(new JLabel(b.toString()), c);
		}
	}

	public void machKarteKontoAnlegen() {
		JButton knopf = new JButton("neues Konto");
		getAuswahl().add(knopf);
		knopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				((CardLayout) getKarten().getLayout()).show(getKarten(),
						"KontoArt");
			}
		});

		final JPanel karte = new JPanel();
		getKarten().add(karte, "KontoArt");
		karte.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		karte.add(new JLabel("Auswahl Art des Kontos: "), c);
		final JComboBox art = new JComboBox();
		final String giro = "Girokonto";
		final String spar = "Sparkonto";
		final String susp = "Supersparkonto";
		art.addItem(giro);
		setKontoArt(giro);
		art.addItem(spar);
		art.addItem(susp);
		c.gridx = 1;
		c.gridy = 2;
		karte.add(art, c);
		final JButton newKonto = new JButton("Neues " + getKontoArt());
		art.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				setKontoArt((String) ev.getItem());
				newKonto.setText("Neues " + getKontoArt());
			}
		});
		c.gridx = 1;
		c.gridy = 3;
		karte.add(newKonto, c);
		newKonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				((CardLayout) getKarten().getLayout()).show(getKarten(),
						getKontoArt());
			}
		});

		// Giro-Karte
		String platz = "----------------------------------------";
		final JPanel karte2 = new JPanel();
		getKarten().add(karte2, giro);
		karte2.setLayout(new GridBagLayout());
		c.gridx = 1;
		c.gridy = 1;
		karte2.add(new JLabel(platz), c);
		c.gridx = 2;
		c.gridy = 1;
		karte2.add(new JLabel(platz), c);
		c.gridx = 1;
		c.gridy = 2;
		karte2.add(new JLabel("Name des Kontoinhabers: "), c);
		final JTextField t = new JTextField();
		c.gridx = 2;
		c.gridy = 2;
		c.fill = GridBagConstraints.BOTH;
		karte2.add(t, c);
		c.gridx = 1;
		c.gridy = 3;
		karte2.add(new JLabel("Überziehungskredit: "), c);
		final JTextField t2 = new JTextField();
		c.gridx = 2;
		c.gridy = 3;
		c.fill = GridBagConstraints.BOTH;
		karte2.add(t2, c);

		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				String s = t.getText().trim();
				String s2 = t2.getText().trim();
				getFehlerMeldung().setText("");
				if (s.length() != 0 && s2.length() != 0) {
					try {
						if (getBank() != null) {
							Konto k = getBank().newGiroKonto(s, s2);
							t.setText("");
							t2.setText("");
							getKontoAuswahl().addItem(k);
							getKontenListener().actionPerformed(null);
						}
					} catch (EuroFormatFehler e) {
						t2.setText(s + " ist falsch!");
						getFehlerMeldung().setText(e.toString());
					}
				} else if (s.length() == 0 && s2.length() == 0) {
					getKontenListener().actionPerformed(null);
				}
				karte.invalidate();
				getKarten().validate();
				getKarten().repaint();
			}
		};
		t.addActionListener(al);
		t2.addActionListener(al);

		// Sparkonto-Karte
		final JPanel karte3 = new JPanel();
		getKarten().add(karte3, spar);
		karte3.setLayout(new GridBagLayout());
		c.gridx = 1;
		c.gridy = 1;
		karte3.add(new JLabel(platz), c);
		c.gridx = 2;
		c.gridy = 1;
		karte3.add(new JLabel(platz), c);
		c.gridx = 1;
		c.gridy = 2;
		karte3.add(new JLabel("Name des Kontoinhabers: "), c);
		final JTextField t31 = new JTextField();
		c.gridx = 2;
		c.gridy = 2;
		c.fill = GridBagConstraints.BOTH;
		karte3.add(t31, c);
		c.gridx = 1;
		c.gridy = 3;
		karte3.add(new JLabel("Zinssatz: "), c);
		final JTextField t32 = new JTextField();
		c.gridx = 2;
		c.gridy = 3;
		c.fill = GridBagConstraints.BOTH;
		karte3.add(t32, c);

		al = new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				String s = t31.getText().trim();
				String s2 = t32.getText().trim();
				getFehlerMeldung().setText("");
				if (s.length() != 0 && s2.length() != 0) {
					try {
						if (getBank() != null) {
							Konto k = getBank().newSparKonto(s, s2);
							t31.setText("");
							t32.setText("");
							getKontoAuswahl().addItem(k);
							getKontenListener().actionPerformed(null);
						}
					} catch (EuroFormatFehler e) {
						t32.setText(s + " ist falsch!");
						getFehlerMeldung().setText(e.toString());
					}
				} else if (s.length() == 0 && s2.length() == 0) {
					getKontenListener().actionPerformed(null);
				}
				karte.invalidate();
				getKarten().validate();
				getKarten().repaint();
			}
		};
		t31.addActionListener(al);
		t32.addActionListener(al);

		// Supersparkonto-Karte
		final JPanel karte4 = new JPanel();
		getKarten().add(karte4, susp);
		karte4.setLayout(new GridBagLayout());
		c.gridx = 1;
		c.gridy = 1;
		karte4.add(new JLabel(platz), c);
		c.gridx = 2;
		c.gridy = 1;
		karte4.add(new JLabel(platz), c);
		c.gridx = 1;
		c.gridy = 2;
		karte4.add(new JLabel("Name des Kontoinhabers: "), c);
		final JTextField t41 = new JTextField();
		c.gridx = 2;
		c.gridy = 2;
		c.fill = GridBagConstraints.BOTH;
		karte4.add(t41, c);
		c.gridx = 1;
		c.gridy = 3;
		karte4.add(new JLabel("Zinssatz: "), c);
		final JTextField t42 = new JTextField();
		c.gridx = 2;
		c.gridy = 3;
		c.fill = GridBagConstraints.BOTH;
		karte4.add(t42, c);
		c.gridx = 1;
		c.gridy = 4;
		karte4.add(new JLabel("Bonus: "), c);
		final JTextField t43 = new JTextField();
		c.gridx = 2;
		c.gridy = 4;
		c.fill = GridBagConstraints.BOTH;
		karte4.add(t43, c);

		al = new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				String s = t41.getText().trim();
				String s2 = t42.getText().trim();
				String s3 = t43.getText().trim();
				getFehlerMeldung().setText("");
				if (s.length() != 0 && s2.length() != 0 && s3.length() != 0) {
					try {
						if (getBank() != null) {
							Konto k = getBank().newSuperSparKonto(s, s2, s3);
							t41.setText("");
							t42.setText("");
							t43.setText("");
							getKontoAuswahl().addItem(k);
							getKontenListener().actionPerformed(null);
						}
					} catch (EuroFormatFehler e) {
						t42.setText(s + " ist falsch!");
						t43.setText(s + " ist falsch!");
						getFehlerMeldung().setText(e.toString());
					}
				} else if (s.length() == 0 && s2.length() == 0
						&& s2.length() == 0) {
					getKontenListener().actionPerformed(null);
				}
				karte.invalidate();
				getKarten().validate();
				getKarten().repaint();
			}
		};
		t41.addActionListener(al);
		t42.addActionListener(al);
		t43.addActionListener(al);
	}

	public void machKarteUeberweisung() {
		final JPanel karte = new JPanel();
		karte.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		getKarten().add(karte, "Überweisung");

		JButton knopf = new JButton("Überweisung");
		getAuswahl().add(knopf);
		knopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				getBankVonAuswahl().removeAllItems();
				getBankNachAuswahl().removeAllItems();
				getKontoVonAuswahl().removeAllItems();
				getKontoNachAuswahl().removeAllItems();
				getBankVonAuswahl().addItem("Bank ?");
				getBankNachAuswahl().addItem("Bank ?");
				getKontoVonAuswahl().addItem("Konto ?");
				getKontoNachAuswahl().addItem("Konto ?");
				setVonKonto(null);
				setNachKonto(null);
				for (Bank b : getBanken()) {
					getBankVonAuswahl().addItem(b);
					getBankNachAuswahl().addItem(b);
				}
				getUeberweisungBetrag().setText("");
				getUeberweisungMeldung().setText(" ");
				((CardLayout) getKarten().getLayout()).show(getKarten(),
						"Überweisung");
			}
		});

		getBankVonAuswahl().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Object sel = getBankVonAuswahl().getSelectedItem();
				getKontoVonAuswahl().removeAllItems();
				getKontoVonAuswahl().addItem("Konto ?");
				if (sel instanceof Bank) {
					setVonBank((Bank) sel);
					if (getVonBank() != null)
						for (Konto k : getVonBank().getKonto()) {
							getKontoVonAuswahl().addItem(k);
						}
				} else {
					setVonBank(null);
				}
				((CardLayout) getKarten().getLayout()).show(getKarten(),
						"Überweisung");
			}
		});

		getKontoVonAuswahl().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Object sel = getKontoVonAuswahl().getSelectedItem();
				if (sel instanceof Konto) {
					setVonKonto((Konto) sel);
				} else {
					setVonKonto(null);
				}
				((CardLayout) getKarten().getLayout()).show(getKarten(),
						"Überweisung");
			}
		});

		getBankNachAuswahl().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Object sel = getBankNachAuswahl().getSelectedItem();
				getKontoNachAuswahl().removeAllItems();
				getKontoNachAuswahl().addItem("Konto ?");
				if (sel instanceof Bank) {
					setNachBank((Bank) sel);
					if (getNachBank() != null)
						for (Konto k : getNachBank().getKonto()) {
							getKontoNachAuswahl().addItem(k);
						}
				} else {
					setNachBank(null);
				}
				((CardLayout) getKarten().getLayout()).show(getKarten(),
						"Überweisung");
			}
		});

		getKontoNachAuswahl().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Object sel = getKontoNachAuswahl().getSelectedItem();
				if (sel instanceof Konto) {
					setNachKonto((Konto) sel);
				} else {
					setNachKonto(null);
				}
				((CardLayout) getKarten().getLayout()).show(getKarten(),
						"Überweisung");
			}
		});

		JButton jb = new JButton("Überweisung tätigen!");
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				String s;
				String falsch = "";
				if (getVonKonto() == null || getNachKonto() == null) {
					falsch = "Konten sind noch nicht ausgewählt!";
				} else if ((s = getUeberweisungBetrag().getText().trim())
						.length() != 0) {
					try {
						getVonKonto().auszahlen(s);
						getNachKonto().einzahlen(s);
						// System.err.println ("Ausgezahlt (" + s + ") " +
						// getVonKonto ().getEuro ());
						// System.err.println ("Eingezahlt (" + s + ") " +
						// getNachKonto ().getEuro ());
					} catch (Exception e) {
						getUeberweisungBetrag().setText(s + " ist falsch!");
						falsch = e.toString();
					}
				} else {
					falsch = "Überweisung wurde nicht getätigt!";
				}
				if (falsch.length() > 0) {
					getUeberweisungMeldung().setForeground(Color.red);
					getUeberweisungMeldung().setText(falsch);
				} else {
					getUeberweisungMeldung().setForeground(Color.black);
					getUeberweisungMeldung().setText(
							"Überweisung wurde getätigt.");
				}
				((CardLayout) getKarten().getLayout()).show(getKarten(),
						"Überweisung");
			}
		});

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 1;
		karte.add(new JLabel("Überweisung"), c);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		karte.add(new JLabel("von"), c);
		c.gridx = 1;
		c.gridy = 3;
		karte.add(new JLabel("Bank"), c);
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 2;
		karte.add(getBankVonAuswahl(), c);
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		karte.add(new JLabel("Konto"), c);
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 2;
		karte.add(getKontoVonAuswahl(), c);

		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 1;
		karte.add(new JLabel(" "), c);

		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 1;
		karte.add(new JLabel("Betrag"), c);
		c.gridx = 2;
		c.gridy = 6;
		c.gridwidth = 2;
		karte.add(getUeberweisungBetrag(), c);

		c.gridx = 1;
		c.gridy = 7;
		c.gridwidth = 1;
		karte.add(new JLabel("nach"), c);
		c.gridx = 1;
		c.gridy = 8;
		karte.add(new JLabel("Bank"), c);
		c.gridx = 2;
		c.gridy = 8;
		c.gridwidth = 2;
		karte.add(getBankNachAuswahl(), c);
		c.gridx = 1;
		c.gridy = 9;
		c.gridwidth = 1;
		karte.add(new JLabel("Konto"), c);
		c.gridx = 2;
		c.gridy = 9;
		c.gridwidth = 2;
		karte.add(getKontoNachAuswahl(), c);

		c.gridx = 1;
		c.gridy = 10;
		c.gridwidth = 1;
		karte.add(new JLabel(" "), c);
		c.gridx = 1;
		c.gridy = 11;
		c.gridwidth = 3;
		karte.add(jb, c);
		c.gridx = 1;
		c.gridy = 12;
		c.gridwidth = 3;
		karte.add(getUeberweisungMeldung(), c);
	}

} // end BankGUI
