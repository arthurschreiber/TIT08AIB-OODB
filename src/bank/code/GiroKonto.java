package bank.code;

import java.io.*;

public class GiroKonto extends Konto {

	private long kredit;

	// Constructors and Operations:
	public final long getKredit() {
		return kredit;
	}

	private final void setKredit(long kredit) {
		this.kredit = kredit;
	}

	public GiroKonto(String inhaber, String kredit) throws EuroFormatFehler {
		super(inhaber);
		setKredit(euroToLong(kredit));
	}

	public void auszahlen(String betrag) throws KontoFehler, EuroFormatFehler {
		long aktuell = getKontostand();
		long kredit = getKredit();
		long b = euroToLong(betrag);
		if (aktuell - b < -kredit) {
			throw new KontoFehler("Das Girokonto wird überzogen: " + "Betrag "
					+ betrag + " größer als " + getEuro() + " + "
					+ longToEuro(getKredit()));
		} else {
			setKontostand(aktuell - b);
		}
	}

	public void kontostand(PrintWriter w) {
		w.print("Giro");
		super.kontostand(w);
	}

} // end GiroKonto
