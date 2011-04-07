package bank.code;

import java.io.*;

public class SparKonto extends Konto {

	private double zinssatz;

	private long zeit;

	// Constructors and Operations:
	public final double getZinssatz() {
		return zinssatz;
	}

	private final void setZinssatz(double zinssatz) {
		this.zinssatz = zinssatz;
	}

	public final long getZeit() {
		return zeit;
	}

	private final void setZeit(long zeit) {
		this.zeit = zeit;
	}

	public SparKonto(String inhaber, String zinssatz) throws EuroFormatFehler {
		super(inhaber);
		try {
			setZinssatz(Double.parseDouble(zinssatz.replace(',', '.')));
		} catch (NumberFormatException e) {
			setZinssatz(0.0);
			throw new EuroFormatFehler(zinssatz);
		}
		setZeit(System.currentTimeMillis());
	}

	public long getKontostand() {
		long altZeit = getZeit();
		setZeit(System.currentTimeMillis());
		super.setKontostand((long) (super.getKontostand() + super
				.getKontostand()
				* getZinssatz()
				/ 100.0
				* (getZeit() - altZeit) / 6000));
		return super.getKontostand();
	}

	public void auszahlen(String betrag) throws KontoFehler, EuroFormatFehler {
		long aktuell = getKontostand();
		long b = euroToLong(betrag);
		if (aktuell - b < 0.0) {
			throw new KontoFehler("Abheben vom SparKonto: " + "Betrag "
					+ betrag + " größer als " + longToEuro(aktuell));
		} else {
			setKontostand(aktuell - b);
		}
	}

	public void kontostand(PrintWriter w) {
		w.print("Spar");
		super.kontostand(w);
	}

} // end SparKonto
