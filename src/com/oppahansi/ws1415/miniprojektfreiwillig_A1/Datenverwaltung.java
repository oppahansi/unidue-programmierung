/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ws1415.miniprojektfreiwillig_A1;

public abstract class Datenverwaltung {

  public abstract void einfuegen(Beschreibung eintrag);

  public abstract void loeschen(int id);

  public abstract DatenListe getAll(int id);

  public abstract int anzahlEintraege();

  public abstract void allesLoeschen();
}
