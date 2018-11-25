/*
 * ANMERKUNG BITTE LESEN
 *
 * Diese Klausurloesungen wurden nicht von mir (oppahansi) erstellt,
 * sondern von einem Kommilitonen - Khoa Trinh -
 *
 * Falls ich hier einige Sachen im nachhinein veraendere, werde ich es
 * auch kommentieren!
 *
 * Ein Dankeschoen an Khoa Trinh.
 */

package com.oppahansi.ss14.klausurss14Aufg2;

public class Tree {

  private Node root;

  public static void main(String[] args) {
    Tree tree = new Tree();

    tree.add(10);
    tree.add(6);
    tree.add(33);
    tree.add(7);
    tree.add(45);
    tree.add(1);
  }

  /*
   * Teilaufgabe a)
   */
  // Parameter von Node node zu int number geaendert (oppahansi)
  public void add(int number) {
    /*
     * Diese Methode hab ich auch nicht im kopf, aber ich weiss genau,
     * dass sie vorzugsweise den Node immer in den linken teilbaum
     * eingefuegt hat, wenn beide teilbaeume dann wieder die selbe minHeight
     * haben wurde wieder vorzugsweise links eingefuegt, und die selbe
     * Geschichte wiederholt.
     */

    // hier Loesung implementieren

  }

  /*
      * Teilaufgabe b)
      *
      * Zeichne den baum nach Ausfuehrung der main Methode. ( 6 punkte )
      *
      * so wuerde unser beispielbaum nach ausfuehrung dieser methode aussehen:
  // so wuerde dieser baum aussehen
     //                            10
     //                         /     \
     //                        6      33
     //                       / \    /  \
     //                     7   45  1
      */

  public int getMinHeight() {
    /*
     * Diese methode war auch vorgegeben, ich hab sie zwar nicht mehr im kopf,
     * aber sie hat die mindesthoehe vom Knoten bis zur Wurzel zurueckgegeben
     */
    int minHeight = 0;
    return minHeight;
  }

  /*
   * Teilaufgabe c)
   *
   * Zeichne den baum nach ausfuehrung der main methode ( 6 punkte )
   */
  public void print() {
    print(root);
  }

  private void print(Node node) { // Fixed by Marc E.
    // hier den baum aus der postorder zur�ckgeben,
    // also erst den linken teilbaum, dann den rechten, dann die wurzel
    if (node != null) {
      print(node.getNextLeft()); //Links
      print(node.getNextRight()); //Rechts
      System.out.println(node.getNumber()); //Wurzel

      // fuer unseren beispielbaum waeren es die werte :
      //  Postorder (L-R-W): 7, 45, 6, 1, 33, 10
    }
  }

  /*
   * Teilaufgabe d)
   *
   * Implementiere die Methode countNodesLargerThan10 so,
   * dass sie  die Anzahl an Knoten groesser als 10 rausgibt ( 12 punkte )
   */
  public void countNodesLargerThan10() {
    countNodesLargerThan10(root);
  }

  public int countNodesLargerThan10(Node node) {
    if (node == null) {
      return 0;
    }
    int counter = 0;
    if (node.getNumber() > 10) {
      counter++;
    }

    counter = counter + countNodesLargerThan10(node.getNextLeft());
    counter = counter + countNodesLargerThan10(node.getNextRight());
    return counter;
  }

  /*
   * Teilaufgabe e)
   *
   * Implementiere die methode makeParentsProducts so,
   * dass sie den node umaendert in das produkt seiner beiden kindknoten.
   */
  public void makeParentsProducts() {
    makeParentsProducts(root);
  }

  public int makeParentsProducts(Node node) {
    if (node == null) {
      return 1;
    }
    node.setNumber(
        makeParentsProducts(node.getNextRight()) * makeParentsProducts(node.getNextLeft()));
    return node.getNumber();
  }
}
