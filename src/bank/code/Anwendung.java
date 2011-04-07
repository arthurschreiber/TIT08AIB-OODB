package bank.code;

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
		EmbeddedObjectContainer db = Db4oEmbedded.openFile(
				Db4oEmbedded.newConfiguration(), "../banken.db4o");

		// Bank bank = new Bank("BA-Bank", "53827298");
		//
		// try
		// {
		// Konto k1 = bank.newGiroKonto("Klinsmann", "3000");
		// k1.einzahlen("5000,56");
		// }
		// catch (EuroFormatFehler e)
		// {
		// }
		//
		// try
		// {
		// bank.newSparKonto("Pele", "5,5");
		// }
		// catch (EuroFormatFehler e)
		// {
		// }
		//
		// try
		// {
		// bank.newSuperSparKonto("Beckenbauer", "6,5", "10,0");
		// }
		// catch (EuroFormatFehler e)
		// {
		// }
		//
		// for (Konto k : bank.getKonto())
		// {
		// try
		// {
		// k.einzahlen("10000,00");
		// }
		// catch (EuroFormatFehler e)
		// {
		// }
		// }
		//
		// for (Konto k : bank.getKonto())
		// {
		// try
		// {
		// k.auszahlen("5000,00");
		// }
		// catch (KontoFehler e)
		// {
		// }
		// catch (EuroFormatFehler e)
		// {
		// }
		// }
		//
		// for (Konto k : bank.getKonto())
		// {
		// try
		// {
		// k.auszahlen("15000,00");
		// }
		// catch (KontoFehler e)
		// {
		// }
		// catch (EuroFormatFehler e)
		// {
		// }
		// }
		//
		// db.store(bank);

		new BankGUI(db);
	}

} // end Anwendung
