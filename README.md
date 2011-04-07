# OODB Assignment

## Bank

In der `Anwendung`-Klasse wird die `banken.db4o` Datei geöffnet und der
`EmbeddedObjectContainer` an den Konstruktor der `BankGUI` übergeben. Dieser
Parameter wird im Konstruktor der `BankGUI` an `BankGUI.setDB` weitergegeben
und ist dadurch über `BankGUI.getDB` zugänglich.

Um sicherzustellen, dass die Datenbank beim Beenden der Anwendung korrekt
geschlossen wird, wurden ein `WindowAdapter` als `WindowListener` zum
Haupt-`JFrame` der `BankGUI` hinzugefügt. Dieser `WindowAdapter` schließt
die Datenbank in seiner `windowClosing` Methode. Auch wurde die
`BankGUI.machEndeKnopf` Methode so verändert, dass die Datenbank korrekt
geschlossen wird.

Die `BankGUI.getBanken` Methode wurde so verändert, dass sie bei jedem
Aufruf eine die Banken direkt aus dem `EmbeddedObjectContainer` heraussucht
und diese als `List<Bank>` zurückgibt.

Die `BankGUI.machKontoLoeschknopf`, `BankGUI.machBankLoeschknopf`,
`BankGUI.machKarteKontoAnlegen` wurden so abgeändert, dass in ihnen nach
jeder Modifikation eines `Bank` oder `Konto`-Objektes die jeweiligen Objekte
in der Datenbank angelegt/aktualisiert/entfernt wurden.

## Malen

Ähnlich wie in der Bank-Aufgabe wurde auch hier in der `Anwendung`-Klasse die
`malen.db4o` geöffnet und der `EmbeddedObjectContainer` an den Konstruktor 
der `Malen`-Klasse übergeben.

Auch wurden wieder Änderungen analog zu denen in der Bank-Aufgabe gemacht, um
sicherzustellen dass die Datenbank beim Beenden der Anwendung korrekt
geschlossen wird.

`Malen.getZeichnung` gibt nun bei jedem Aufruf alle Zeichnungen direkt aus
der Datenbank zurück.

`Malen.addZeichnung` und `Malen.rmvZeichnung` arbeiten nun auch direkt auf
der Datenbank und der `ActionListener`, der in `Malen.machUpdate` definiert
wird, aktualisiert die aktuelle Zeichnung in der Datenbank.

Da Db4o jedoch standardmäßig Updates und Deletes nicht kaskadiert, wurde
die Konfiguration so angepasst, das Updates und Deletes der
`Zeichnung`-Klasse kaskadiert werden:

    EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
	config.common().objectClass(Zeichnung.class).cascadeOnUpdate(true);
	config.common().objectClass(Zeichnung.class).cascadeOnDelete(true);