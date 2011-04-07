package bank.code;

import java.io.*;

public abstract class Konto {

	private String inhaber;

	private int kontoNr;

	private long kontostand;

	// Constructors and Operations:
	public final String getInhaber() {
		return inhaber;
	}

	private final void setInhaber(String inhaber) {
		this.inhaber = inhaber;
	}

	public final int getKontoNr() {
		return kontoNr;
	}

	public final void setKontoNr(int kontoNr) {
		this.kontoNr = kontoNr;
	}

	public long getKontostand() {
		return kontostand;
	}

	protected final void setKontostand(long kontostand) {
		this.kontostand = kontostand;
	}

	protected static long euroToLong(String betrag) throws EuroFormatFehler {
		betrag = betrag.trim();
		int n = betrag.length();
		int p = betrag.indexOf(',');
		long k;
		try {
			if (p < 0 && n > 0) {
				k = Long.parseLong(betrag) * 100;
				return k;
			} else if (p == 0 && n == 2) {
				k = Long.parseLong(betrag.substring(1)) * 10;
				return k;
			} else if (p == 0 && n == 3) {
				k = Long.parseLong(betrag.substring(1));
				return k;
			} else if (p == n - 1 && n > 1) {
				k = Long.parseLong(betrag.substring(0, p)) * 100;
				return k;
			} else if (p > 0) {
				String vor = betrag.substring(0, p);
				String nach = betrag.substring(p + 1);
				if (nach.length() == 1)
					nach = nach + "0";
				if (nach.length() > 2)
					throw new EuroFormatFehler(betrag);
				k = Long.parseLong(vor) * 100;
				k = k + Long.parseLong(nach);
				return k;
			} else {
				throw new EuroFormatFehler(betrag);
			}
		} catch (NumberFormatException e) {
			throw new EuroFormatFehler(betrag);
		}
	}

	protected static String longToEuro(long betrag) {
		String s = "" + betrag % 100;
		if (s.length() < 2)
			s = "0" + s;
		return betrag / 100 + "," + s;
	}

	public void setEuro(String betrag) throws EuroFormatFehler {
		setKontostand(euroToLong(betrag));
	}

	public String getEuro() {
		return longToEuro(getKontostand());
	}

	public Konto(String inhaber) {
		setInhaber(inhaber);
		try {
			setEuro("0,00");
		} catch (EuroFormatFehler e) {
			e.printStackTrace();
		}
	}

	public void einzahlen(String betrag) throws EuroFormatFehler {
		setKontostand(getKontostand() + euroToLong(betrag));
	}

	public abstract void auszahlen(String betrag) throws KontoFehler,
			EuroFormatFehler;

	public void kontostand(PrintWriter w) {
		w.print("Konto: Der Kontostand von ");
		w.print("Konto " + getKontoNr() + " (");
		w.print(getInhaber());
		w.print(") ist ");
		w.println(getEuro() + " Euro");
	}

	public String toString() {
		return getInhaber() + " (" + getClass().getName() + " " + getKontoNr()
				+ ")";
	}

} // end Konto
