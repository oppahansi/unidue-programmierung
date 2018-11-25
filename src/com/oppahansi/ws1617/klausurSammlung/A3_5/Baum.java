/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_5;

public class Baum {
  Knoten wurzel;

  void einfuege(Knoten k) {
    wurzel = einfuege(wurzel, k);
  }

  Knoten einfuege(Knoten w, Knoten k) {
    if (w == null) {
      return k;
    } else {
      if (w.zahl > k.zahl) {
        einfuege(w.links, k);
      } else if (w.zahl < k.zahl) {
        einfuege(w.rechts, k);
      }
    }
    return w;
  }
}
