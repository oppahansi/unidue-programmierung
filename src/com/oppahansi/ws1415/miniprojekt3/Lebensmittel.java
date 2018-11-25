/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ws1415.miniprojekt3;

// Fassen Sie diese Klasse nicht an!
public class Lebensmittel {

  // Als Konstanten
  public static final Lebensmittel Seelachsfilet =
      new Lebensmittel("Seelachsfilet", 16.0, 3.6, 0.9);
  public static final Lebensmittel Rindfleisch = new Lebensmittel("Rindfleisch", 29.9, 0.0, 9.3);
  public static final Lebensmittel Haenchenfleisch =
      new Lebensmittel("Haenchenfleisch", 16.0, 0.0, 1.0);
  public static final Lebensmittel Haenchenbrustfilet =
      new Lebensmittel("Haenchenbrustfilet", 23.0, 0.0, 2.0);
  public static final Lebensmittel Schweinefleisch =
      new Lebensmittel("Schweinefleisch", 26.7, 0.0, 16.7);
  public static final Lebensmittel Tofu = new Lebensmittel("Tofu", 15.8, 0.6, 8.7);
  public static final Lebensmittel Nudeln = new Lebensmittel("Nudeln", 13.0, 70.0, 1.0);
  public static final Lebensmittel Reis = new Lebensmittel("Reis", 7.8, 74.1, 2.2);
  public static final Lebensmittel Kartoffeln = new Lebensmittel("Kartoffeln", 1.9, 15.6, 0.0);
  public static final Lebensmittel Tomaten = new Lebensmittel("Tomaten", 0.95, 2.6, 0.21);
  public static final Lebensmittel Broccoli = new Lebensmittel("Broccoli", 3.8, 2.7, 0.2);
  public static final Lebensmittel Blumenkohl = new Lebensmittel("Blumenkohl", 2.4, 2.7, 0.3);
  public static final Lebensmittel Erbsen = new Lebensmittel("Erbsen", 6.55, 12.3, 0.5);
  public static final Lebensmittel Karotten = new Lebensmittel("Karotten", 1.0, 4.8, 0.2);
  public static final Lebensmittel Bohnen = new Lebensmittel("Bohnen", 2.4, 5.1, 0.2);
  public static final Lebensmittel Paprika = new Lebensmittel("Paprika", 1.0, 6.0, 0.3);
  public static final Lebensmittel Mais = new Lebensmittel("Mais", 3.3, 15.7, 1.2);
  public static final Lebensmittel Auberginen = new Lebensmittel("Auberginen", 1.2, 2.5, 0.2);
  public static final Lebensmittel Champignons = new Lebensmittel("Champignons", 4.1, 0.6, 0.3);
  public static final Lebensmittel Waldpilzsauce = new Lebensmittel("Waldpilzsauce", 1.6, 7.2, 4.1);
  public static final Lebensmittel Bechamelsauce = new Lebensmittel("Bechamelsauce", 2.4, 6.2, 7.3);
  public static final Lebensmittel Currysauce = new Lebensmittel("Currysauce", 1.9, 8.0, 11.9);
  public static final Lebensmittel Tomatensauce = new Lebensmittel("Tomatensauce", 1.4, 7.1, 0.3);
  public static final Lebensmittel Gorgonzolasauce =
      new Lebensmittel("Gorgonzolasauce", 4.5, 6.4, 19.0);
  public static final Lebensmittel Analogkaese = new Lebensmittel("Analogkaese", 3.1, 22.0, 27.2);
  public static final Lebensmittel Kaese = new Lebensmittel("Kaese", 22.0, 0.0, 31.0);
  public static final Lebensmittel Joghurt = new Lebensmittel("Joghurt", 5.6, 6.4, 0.1);
  public static final Lebensmittel Paniermehl = new Lebensmittel("Paniermehl", 10.1, 73.5, 2.1);
  public static final Lebensmittel Ei = new Lebensmittel("Ei", 12.8, 0.7, 11.3);
  public static final Lebensmittel Oel = new Lebensmittel("Oel", 0.0, 0.0, 100.0);
  public static final Lebensmittel Margarine = new Lebensmittel("Margarine", 0.2, 0.7, 81.0);
  public static final Lebensmittel Butter = new Lebensmittel("Butter", 0.1, 0.0, 99.7);
  public static final Lebensmittel Sojagranulat = new Lebensmittel("Sojagranulat", 50.5, 16.8, 5.0);
  public static final Lebensmittel Broetchen = new Lebensmittel("Broetchen", 7.4, 50.7, 1.4);
  public static final Lebensmittel Senf = new Lebensmittel("Senf", 6.0, 6.0, 4.0);
  public static final Lebensmittel Essig = new Lebensmittel("Essig", 0.0, 3.0, 1.0);
  public static final Lebensmittel Sojaschnetzel =
      new Lebensmittel("Sojaschnetzel", 49.2, 16.3, 7.6);
  public static final Lebensmittel Zwiebel = new Lebensmittel("Zwiebel", 1.2, 4.9, 0.2);
  public static final Lebensmittel Sojamilch = new Lebensmittel("Sojamilch", 15.7, 0.2, 9.9);
  public static final Lebensmittel Hefeflocken = new Lebensmittel("Hefeflocken", 43.4, 34.2, 5.2);
  public static final Lebensmittel Blattspinat = new Lebensmittel("Blattspinat", 2.9, 3.6, 0.4);
  public static final Lebensmittel Sojamehl = new Lebensmittel("Sojamehl", 42.5, 3.1, 20.5);
  public static final Lebensmittel Mehl = new Lebensmittel("Mehl", 9.8, 70.9, 1.0);
  public static final Lebensmittel Gewuerze = new Lebensmittel("Gewuerze", 0.0, 0.0, 0.0);
  public static final Lebensmittel Milch = new Lebensmittel("Milch", 3.4, 4.8, 1.5);
  public static final Lebensmittel Zucchini = new Lebensmittel("Zucchini", 2.0, 2.3, 0.3);
  public static final Lebensmittel Oliven = new Lebensmittel("Oliven", 1.4, 3.0, 12.7);
  public static final Lebensmittel[] AlleLebensmittel =
      new Lebensmittel[] {
        Seelachsfilet, Rindfleisch, Haenchenfleisch, Haenchenbrustfilet,
        Schweinefleisch, Tofu, Nudeln, Reis,
        Kartoffeln, Tomaten, Broccoli, Blumenkohl,
        Erbsen, Karotten, Bohnen, Paprika,
        Mais, Auberginen, Champignons, Waldpilzsauce,
        Bechamelsauce, Currysauce, Tomatensauce, Gorgonzolasauce,
        Analogkaese, Kaese, Joghurt, Paniermehl,
        Ei, Oel, Margarine, Butter,
        Sojagranulat, Broetchen, Senf, Essig,
        Sojaschnetzel, Zwiebel, Sojamilch, Hefeflocken,
        Blattspinat, Sojamehl, Mehl, Gewuerze,
        Milch, Zucchini, Oliven
      };
  public String name;
  // Gewicht pro Makronaehrstoff auf 100g
  public double protein;
  public double kohlenhydrat;
  public double fett;

  public Lebensmittel(String name, double protein, double kohlenhydrat, double fett) {
    super();
    this.name = name;
    this.protein = protein;
    this.kohlenhydrat = kohlenhydrat;
    this.fett = fett;
  }

  public String toString() {
    return name;
  }
}
