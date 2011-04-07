package bank.code;

import java.io.*;

public class SuperSparKonto extends SparKonto {

	private long bonus;

	private static long einzahlumsatz;
	static {
		// setEinzahlumsatz (euroToLong ("1000,00"));
		setEinzahlumsatz(100000);
	}

	// Constructors and Operations:
	public final long getBonus() {
		return bonus;
	}

	private final void setBonus(long bonus) {
		this.bonus = bonus;
	}

	public static final long getEinzahlumsatz() {
		return einzahlumsatz;
	}

	private static final void setEinzahlumsatz(long einzahlumsatz) {
		SuperSparKonto.einzahlumsatz = einzahlumsatz;
	}

	public SuperSparKonto(String inhaber, String zinssatz, String bonus)
			throws EuroFormatFehler {
		super(inhaber, zinssatz);
		setBonus(euroToLong(bonus));
	}

	public void einzahlen(String betrag) throws EuroFormatFehler {
		long b = euroToLong(betrag);
		if (b > getEinzahlumsatz())
			b = b + getBonus();
		super.einzahlen(longToEuro(b));
	}

	public void kontostand(PrintWriter w) {
		w.print("Super");
		super.kontostand(w);
	}

} // end SuperSparKonto
