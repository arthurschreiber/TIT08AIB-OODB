# OODB Assignment

## Bank

In der `Anwendung`-Klasse wird die `banken.db4o` Datei geöffnet und der
`EmbeddedObjectContainer` an den Konstruktor der `BankGUI` übergeben. Dieser
Parameter wird im Konstruktor der `BankGUI` an `BankGUI.setDB` weitergegeben
und ist dadurch über `BankGUI.getDB` zugänglich.

Um sicherzustellen, dass die Datenbank beim Beenden der Anwendung korrekt
geschlossen wird, wurden ein `WindowAdapter` als `WindowListener` zum
Haupt-`JFrame` der `BankGUI` hinzugefügt. Dieser `WindowAdapter` schliesst
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
