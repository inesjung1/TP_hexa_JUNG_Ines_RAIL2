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

    // on récupère la lettre à la position dans le résultat
    public Lettre lettre(int position) {
        return resultat.get(position);
    }

    // on construit le résultat en analysant chaque lettre
    // du mot proposé
    public void compare(String essai) {
        for (position = 0; position < essai.length(); position++) {
            resultat.add(evaluationCaractere(essai.charAt(position)));
        }
    }

    // si toutes les lettres sont placées
    public boolean lettresToutesPlacees() {
        if(resultat.contains(Lettre.INCORRECTE)){
            return false;
        }else{
            return true;
        }
    }

    public List<Lettre> lettresResultat() {
        return unmodifiableList(resultat);
    }

    // renvoie le statut du caractère
    private Lettre evaluationCaractere(char carCourant) {
        if (estPlace(carCourant)) {
            return Lettre.PLACEE;
        }else if (estPresent(carCourant)) {
            return Lettre.NON_PLACEE;
        }else{
            return Lettre.INCORRECTE;
        }
    }

    // le caractère est présent dans le mot secret
    private boolean estPresent(char carCourant) {
        if (motSecret.contains(String.valueOf(carCourant))) {
            return true;
        }else{
            return false;
        }
    }

    // le caractère est placé dans le mot secret
    private boolean estPlace(char carCourant) {
        if (motSecret.charAt(position) == carCourant) {
            return true;
        }else{
            return false;
        }
    }
}
