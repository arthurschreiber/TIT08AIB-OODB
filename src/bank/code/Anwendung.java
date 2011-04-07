package bank.code;
import	java.io.*;
import	java.util.*;

public class	Anwendung
	{

	//	Constructors and Operations:
	public 	Anwendung ()
		/**
		*	working constructor
		**/
		{
		}

	public static void	main (String[] aString)
		{
		PrintWriter	w = new PrintWriter (System.out);
		
		ArrayList<Bank> banken = new ArrayList<Bank> ();
		
		Bank	bank = new Bank ("BA-Bank", "53827298");
		banken.add (bank);
		
		try
			{
			Konto	k1 = bank.newGiroKonto ("Klinsmann", "3000");
			k1.einzahlen ("5000,56");
			}
			catch (EuroFormatFehler e) { w.println (e); }
		
		try
			{
			bank.newSparKonto ("Pele", "5,5");
			}
			catch (EuroFormatFehler e) { w.println (e); }
		
		try
			{
			bank.newSuperSparKonto ("Beckenbauer", "6,5", "10,0");
			}
			catch (EuroFormatFehler e) { w.println (e); }
		
		for (Konto k : bank.getKonto ())
			{
			k.kontostand (w);
			try
				{
				k.einzahlen ("10000,00");
				}
				catch (EuroFormatFehler e) { w.println (e); }
			k.kontostand (w);
			w.println ();
			}
		
		for (Konto k : bank.getKonto ())
			{
			k.kontostand (w);
			try
				{
				k.auszahlen ("5000,00");
				}
				catch (KontoFehler e) { w.println (e); }
				catch (EuroFormatFehler e) { w.println (e); }
			k.kontostand (w);
			w.println ();
			}
		
		for (Konto k : bank.getKonto ())
			{
			k.kontostand (w);
			try
				{
				k.auszahlen ("15000,00");
				}
				catch (KontoFehler e) { w.println (e); }
				catch (EuroFormatFehler e) { w.println (e); }
			k.kontostand (w);
			w.println ();
			}
		w.close ();
		
		new BankGUI (banken);
		}

	}	//	end Anwendung
