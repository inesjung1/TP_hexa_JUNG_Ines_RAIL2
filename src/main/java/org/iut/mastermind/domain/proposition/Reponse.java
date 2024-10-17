package org.iut.mastermind.domain.proposition;

import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.unmodifiableList;

public class Reponse {
    private final String motSecret;
    private final List<Lettre> resultat = new ArrayList<>();
    private int position;

    public Reponse(String mot) {
        this.motSecret = mot;
    }

    public Lettre lettre(int position) {
        return resultat.get(position);
    }

    public void compare(String essai) {
        for (position = 0; position < essai.length(); position++) {
            resultat.add(evaluationCaractere(essai.charAt(position)));
        }
    }

    public boolean lettresToutesPlacees() {
        return !(resultat.contains(Lettre.INCORRECTE));
    }

    public List<Lettre> lettresResultat() {
        return unmodifiableList(resultat);
    }

    private Lettre evaluationCaractere(char carCourant) {
        return estPlace(carCourant) ? Lettre.PLACEE
                : estPresent(carCourant) ? Lettre.NON_PLACEE
                : Lettre.INCORRECTE;
    }

    private boolean estPresent(char carCourant) {
        return (motSecret.contains(String.valueOf(carCourant)));
    }

    private boolean estPlace(char carCourant) {
        return (motSecret.charAt(position) == carCourant);
    }

}
