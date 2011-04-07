package bank.code;

import java.util.List;
import com.db4o.Db4oEmbedded;
import com.db4o.EmbeddedObjectContainer;
import com.db4o.query.Predicate;

public class WeirdQueries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmbeddedObjectContainer db = Db4oEmbedded.openFile(
				Db4oEmbedded.newConfiguration(), "../banken.db4o");

		// Nur nach Banken mit mehr als 3 Konten suchen.
		List<Bank> banken = db.query(new Predicate<Bank>() {
			@Override
			public boolean match(Bank bank) {
				return bank.getKonto().length >= 3;
			}
		});

		System.out.println("Banken: " + banken.size());

		// Nach der Bank mit Klinsmann suchen
		banken = db.query(new Predicate<Bank>() {
			@Override
			public boolean match(Bank bank) {
				for (Konto konto : bank.getKonto()) {
					if (konto.getInhaber().equals("Klinsmann"))
						return true;
				}
				return false;
			}
		});

		System.out.println("Banken: " + banken.size());

		db.close();
	}

}
