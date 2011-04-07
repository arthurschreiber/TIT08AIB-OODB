package bank.code;
public class	EuroFormatFehler
	extends		Exception
	{

	private String	nachricht;

	//	Constructors and Operations:
	public final String	getNachricht ()
		{
		return nachricht;
		}

	private final void	setNachricht (String nachricht)
		{
		this.nachricht = nachricht;
		}

	public 	EuroFormatFehler (String nachricht)
		/**
		*	working constructor
		**/
		{
		setNachricht (nachricht);
		}

	public String	toString ()
		{
		String	s = "Fehler: Das Format für Euro-Cent ist falsch.\n";
		s = s + "   Eingabe: \"" + getNachricht () + "\"\n";
		s = s + "   Das Format ist \"eeeeeeee,cc\".\n";
		return s;
		}

	}	//	end EuroFormatFehler
