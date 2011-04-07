package bank.code;

public class Bank {

	private String name;

	private String bLZ;

	private Konto[] aKonto;
	{
		aKonto = new Konto[0];
	}

	// Constructors and Operations:
	public final String getName() {
		return name;
	}

	private final void setName(String name) {
		this.name = name;
	}

	public final String getBLZ() {
		return bLZ;
	}

	private final void setBLZ(String bLZ) {
		this.bLZ = bLZ;
	}

	public final Konto[] getKonto() {
		return aKonto;
	}

	public final void setKonto(Konto[] aKonto) {
		this.aKonto = aKonto;
	}

	public final int numKonto() {
		return getKonto().length;
	}

	public final void addKonto(Konto aKonto) {
		Konto[] x = getKonto();
		Konto[] y = new Konto[x.length + 1];
		System.arraycopy(x, 0, y, 0, x.length);
		y[x.length] = aKonto;
		setKonto(y);
	}

	public final void addKonto(Konto[] aKonto) {
		Konto[] x = getKonto();
		Konto[] y = new Konto[x.length + aKonto.length];
		System.arraycopy(x, 0, y, 0, x.length);
		System.arraycopy(x, 0, y, x.length, aKonto.length);
		setKonto(y);
	}

	public final void rmvKonto(Konto aKonto) {
		int ii = -1;
		boolean suchen = true;
		while (suchen) {
			int n = numKonto();
			for (int i = 0; i < n; i++) {
				if (aKonto == getKonto(i)) {
					ii = i;
					break;
				}
			}
			if (ii >= 0) {
				rmvKonto(ii);
				ii = -1;
			} else {
				suchen = false;
			}
		}
	}

	public final void rmvKonto(int i) {
		Konto[] x = getKonto();
		Konto[] y = new Konto[x.length - 1];
		System.arraycopy(x, 0, y, 0, i);
		System.arraycopy(x, i + 1, y, i, y.length - i);
		setKonto(y);
	}

	public final Konto getKonto(int i) {
		return getKonto()[i];
	}

	public final void setKonto(int i, Konto aKonto) {
		Konto[] x = getKonto();
		x[i] = aKonto;
		setKonto(x);
	}

	public Bank(String name, String bLZ) {
		setName(name);
		setBLZ(bLZ);
	}

	private void newKontoNr(Konto aKonto) {
		// Finde neue Kontonummer knr:
		int knr = 0;
		Konto[] ks = getKonto();
		boolean weiter = false;
		while (!weiter) {
			knr = (int) (Math.random() * 64000 + 12000);
			weiter = true;
			for (Konto k : ks) {
				if (k.getKontoNr() == knr) {
					weiter = false;
					break;
				}
			}
		}
		aKonto.setKontoNr(knr);
		addKonto(aKonto);
	}

	public String toString() {
		return getName() + " (BLZ: " + getBLZ() + ")";
	}

	public GiroKonto newGiroKonto(String inhaber, String kredit)
			throws EuroFormatFehler {
		GiroKonto gk = new GiroKonto(inhaber, kredit);
		newKontoNr(gk);
		return gk;
	}

	public SparKonto newSparKonto(String inhaber, String zinssatz)
			throws EuroFormatFehler {
		SparKonto sk = new SparKonto(inhaber, zinssatz);
		newKontoNr(sk);
		return sk;
	}

	public SuperSparKonto newSuperSparKonto(String inhaber, String zinssatz,
			String bonus) throws EuroFormatFehler {
		SuperSparKonto ssk = new SuperSparKonto(inhaber, zinssatz, bonus);
		newKontoNr(ssk);
		return ssk;
	}

} // end Bank
