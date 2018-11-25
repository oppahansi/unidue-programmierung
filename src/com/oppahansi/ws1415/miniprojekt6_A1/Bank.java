/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Alternative 1
 */
package com.oppahansi.ws1415.miniprojekt6_A1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Bank {

  public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
  public static final String DATE_INIT = "2015-01-30";
  public static final DecimalFormat EURO_FORMAT = new DecimalFormat(",##0.00 'EUR'");
  public static final String LINE80 =
      "--------------------------------------------------------------------------------\n";
  public static final String BANK_NAME = "Bank";

  public static final String EUR_EXPR = "[0-9]+(,[0-9][0-9])?";
  public static final String KTONR_EXPR = "[0-9]+";
  public static final String DATE_EXPR = "[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]";

  public static final String CMD_T_EXPR = "[tT]" + "\\s+" + "[0-9]+";
  public static final String CMD_D_EXPR = "[dD]" + "\\s+" + DATE_EXPR;
  public static final String CMD_K_EXPR = "[kK]";
  public static final String CMD_N_EXPR = "[nN]" + "\\s+" + "\\w+" + "\\s+" + EUR_EXPR;
  public static final String CMD_U_EXPR =
      "[uU]" + "\\s+" + KTONR_EXPR + "\\s+" + KTONR_EXPR + "\\s+" + EUR_EXPR;
  public static final String CMD_E_EXPR = "[eE]" + "\\s+" + KTONR_EXPR + "\\s+" + EUR_EXPR;
  public static final String CMD_A_EXPR = "[aA]\\s+" + KTONR_EXPR + "\\s+" + EUR_EXPR;
  public static final String CMD_Q_EXPR = "[qQ]";

  public static final double BANK_KONTO_INIT = 10000000.0;

  public static final Class<?>[] KONTO_KLASSEN =
      new Class<?>[] {Sparbuch.class, GiroBusiness.class, GiroStudent.class};

  private int anzahl = 0;
  private int kontoNr = 0;
  private Calendar jetzt;
  private List<Konto> konten;
  private Konto bankKonto = null;

  public Bank()
      throws NoSuchMethodException, SecurityException, InstantiationException,
          IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    jetzt = Calendar.getInstance();
    try {
      jetzt.setTime(DATE_FORMAT.parse(DATE_INIT));
    } catch (Exception e) {
    }

    konten = new LinkedList<>();
    this.kontoAnlegen(Konto.class, BANK_KONTO_INIT);
    bankKonto = findeKonto(0);
  }

  public static void main(String[] args) throws Exception {

    Bank bank = new Bank();

    bank.kontoAnlegen(GiroStudent.class, 100);
    bank.kontoAnlegen(GiroBusiness.class, 200);
    bank.kontoAnlegen(Sparbuch.class, 5);

    while (bank.menu()) {;
    }
  }

  public void kontoAnlegen(Class<? extends Konto> kontoKlasse, double startGuthaben)
      throws NoSuchMethodException, SecurityException, InstantiationException,
          IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Constructor<? extends Konto> constructor =
        kontoKlasse.getConstructor(int.class, double.class, Konto.class);
    constructor.setAccessible(true);
    Konto k = constructor.newInstance(kontoNr++, startGuthaben, bankKonto);
    konten.add(k);
  }

  private boolean menu() {
    System.out.printf(LINE80);
    System.out.printf(
        "Willkommen in der %s!\nGeld der Bank: %s\t Datum: %s\n",
        BANK_NAME,
        EURO_FORMAT.format(konten.get(0).getKontoStand()),
        DATE_FORMAT.format(jetzt.getTime()));
    System.out.printf(LINE80);
    System.out.printf("  t <n>           : Zeit um <n> Tage voranschreiten lassen, z.B. 't 10'\n");
    System.out.printf(
        "  d <yyyy-MM-dd>  : Datum auf das angegebene Datum erh�hen, z.B. 'd 2015-01-30'\n");
    System.out.printf("  k               : Uebersicht der Konten anzeigen\n");
    System.out.printf(
        "  n <typ> <e>     : Neues Konto anlegen vom typ <typ> mit Kontostand <e> anlegen. Beispiel 'n girostudent 100,00'\n");
    System.out.printf(
        "  u <k1> <k2> <e> : Ueberweisung von Konto <k1> zu Konto <k2> �ber den Betrag <e> durchfuehren.\n");
    System.out.printf("  e <k> <e>       : Betrag <e> auf Konto <k> einzahlen.\n");
    System.out.printf("  a <k> <e>       : Betrag <e> von Konto <k> abheben.\n");
    System.out.printf("  q               : Beenden\n");
    System.out.printf("Eingabe: ");

    String eingabe = "q";
    try {
      eingabe = new BufferedReader(new InputStreamReader(System.in)).readLine();

      if (eingabe.trim().length() > 0) {
        String[] args = eingabe.substring(1).trim().split("\\s+");

        if (eingabe.matches(CMD_T_EXPR)) {
          menuTag(args);
        } else if (eingabe.matches(CMD_D_EXPR)) {
          menuDatum(args);
        } else if (eingabe.matches(CMD_K_EXPR)) {
          menuZeigeKonten(args);
        } else if (eingabe.matches(CMD_N_EXPR)) {
          menuNeuesKonto(args);
        } else if (eingabe.matches(CMD_U_EXPR)) {
          menuUeberweisen(args);
        } else if (eingabe.matches(CMD_E_EXPR)) {
          menuEinzahlen(args);
        } else if (eingabe.matches(CMD_A_EXPR)) {
          menuAuszahlen(args);
        } else if (eingabe.matches(CMD_Q_EXPR)) {
          return false;
        } else {
          System.out.printf("Ungueltige Eingabe: '%s' !\n", eingabe);
        }
      }
    } catch (Exception e) {
      System.out.printf("Exception waehrend der Eingabe!\n");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  private void zeitFortschritt(Calendar neuesDatum) {
    int timeout = 100;
    if (neuesDatum.compareTo(jetzt) < 0) {
      System.out.printf("Das aktuelle datum kann nur erhoeht werden!\n");
    } else {
      while (jetzt.compareTo(neuesDatum) != 0) {
        Calendar folgeTag = Calendar.getInstance();
        folgeTag.setTime(jetzt.getTime());
        folgeTag.add(Calendar.DATE, 1);

        System.out.printf("-> %s\n", DATE_FORMAT.format(folgeTag.getTime()));

        for (Konto k : konten) {
          k.tagesAbschluss();
          if (folgeTag.get(Calendar.MONTH) != jetzt.get(Calendar.MONTH)) {
            k.monatsAbschluss();
          }
          if (folgeTag.get(Calendar.YEAR) != jetzt.get(Calendar.YEAR)) {
            k.jahresAbschluss();
          }
        }
        jetzt = folgeTag;
      }
    }
  }

  private void menuTag(String[] args) throws Exception {
    int t = Integer.parseInt(args[0]);
    Calendar neuesDatum = Calendar.getInstance();
    neuesDatum.setTime(jetzt.getTime());
    neuesDatum.add(Calendar.DATE, t);
    System.out.printf("Zeitfortschritt bis %s\n", DATE_FORMAT.format(neuesDatum.getTime()));
    zeitFortschritt(neuesDatum);
  }

  private void menuDatum(String[] args) throws Exception {
    Calendar neuesDatum = Calendar.getInstance();
    neuesDatum.setTime(DATE_FORMAT.parse(args[0]));
    if (neuesDatum.compareTo(jetzt) < 0) {
      System.out.printf("Das aktuelle datum kann nur erhoeht werden!\n");
    } else {
      zeitFortschritt(neuesDatum);
    }
  }

  private void menuZeigeKonten(String[] args) throws Exception {
    System.out.printf("Nr. | Konto-Typ        | Kontostand \n");
    System.out.printf(LINE80);
    for (Konto k : this.konten) {
      System.out.printf(
          "%03d | %-16s | %22s\n",
          k.getKontoNr(), k.getClass().getSimpleName(), EURO_FORMAT.format(k.getKontoStand()));
    }
  }

  private double parseBetrag(String betragString) throws Exception {
    double rv;

    try {
      rv = EURO_FORMAT.parse(betragString).doubleValue();
    } catch (Exception e1) {
      try {
        rv = EURO_FORMAT.parse(betragString.trim() + " EUR").doubleValue();
      } catch (Exception e2) {
        rv = Double.parseDouble(betragString);
      }
    }
    return rv;
  }

  private void menuNeuesKonto(String[] args) throws Exception {

    for (Class<?> c : KONTO_KLASSEN) {
      if (c.getSimpleName().toLowerCase().equals(args[0].toLowerCase())) {
        double startGuthaben = this.parseBetrag(args[1]);
        this.kontoAnlegen(((Class<Konto>) c), startGuthaben);
      }
    }
  }

  private Konto findeKonto(int kontoNr) {
    for (Konto k : konten) {
      if (k != null && k.getKontoNr() == kontoNr) {
        return k;
      }
    }
    return null;
  }

  private void menuUeberweisen(String[] parameter) throws Exception {
    int ktNr1 = Integer.parseInt(parameter[0]);
    int ktNr2 = Integer.parseInt(parameter[1]);
    double betrag = parseBetrag(parameter[2]);

    Konto k1 = findeKonto(ktNr1);
    Konto k2 = findeKonto(ktNr2);

    if (k1 == null) {
      System.out.printf("Konto Nr. %d existiert nicht!\n", ktNr1);
      return;
    }
    if (k2 == null) {
      System.out.printf("Konto Nr. %d existiert nicht!\n", ktNr2);
      return;
    }
    if (k1 == k2) {
      System.out.printf("Ausgangskonto und Zielkonto muessen unterschiedlich sein!\n");
      return;
    }
    if (k1.ueberweisenAuf(k2, betrag)) {
      System.out.printf(
          "Uberweisung %d->%d (%s) erfolgreich!\n", ktNr1, ktNr2, EURO_FORMAT.format(betrag));
    } else {
      System.out.printf(
          "Uberweisung %d->%d (%s) fehlgeschlagen!\n", ktNr1, ktNr2, EURO_FORMAT.format(betrag));
    }
  }

  private void menuEinzahlen(String[] args) throws Exception {
    int ktNr = Integer.parseInt(args[0]);
    double betrag = parseBetrag(args[1]);

    Konto k = findeKonto(ktNr);

    if (k == null) {
      System.out.printf("Konto Nr. %d existiert nicht!\n", ktNr);
      return;
    }

    if (k.einzahlen(betrag)) {
      System.out.printf("Einzahlen auf %d (%s) erfolgreich!\n", ktNr, EURO_FORMAT.format(betrag));
    } else {
      System.out.printf(
          "Einzahlen auf %d (%s) fehlgeschlagen!\n", ktNr, EURO_FORMAT.format(betrag));
    }
  }

  private void menuAuszahlen(String[] args) throws Exception {
    int ktNr = Integer.parseInt(args[0]);
    double betrag = parseBetrag(args[1]);

    Konto k = findeKonto(ktNr);

    if (k == null) {
      System.out.printf("Konto Nr. %d existiert nicht!\n", ktNr);
      return;
    }

    if (k.abheben(betrag)) {
      System.out.printf("Abheben von %d (%s) erfolgreich!\n", ktNr, EURO_FORMAT.format(betrag));
    } else {
      System.out.printf("Abheben von %d (%s) fehlgeschlagen!\n", ktNr, EURO_FORMAT.format(betrag));
    }
  }
}
