package bank.code;

public class KontoFehler extends EuroFormatFehler {

	// Constructors and Operations:
	public KontoFehler(String nachricht)
	/**
	 * working constructor
	 **/
	{
		super(nachricht);
	}

	public String toString() {
		String s = "Kontofehler:\n";
		s = s + "   " + getNachricht() + "\n";
		return s;
	}

} // end KontoFehler
