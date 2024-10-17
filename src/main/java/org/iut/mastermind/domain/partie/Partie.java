package org.iut.mastermind.domain.partie;

import org.iut.mastermind.domain.proposition.MotSecret;
import org.iut.mastermind.domain.proposition.Reponse;

import java.util.Optional;

public class Partie {
    private static final int NB_ESSAIS_MAX = 5;
    private final Joueur joueur;
    private final String motADeviner;
    private int nbEssais;
    private boolean partieTerminee;

    public Partie(Joueur joueur, String motADeviner, int nbEssais, boolean partieTerminee) {
        this.joueur = joueur;
        this.motADeviner = motADeviner;
        this.nbEssais = nbEssais;
        this.partieTerminee = partieTerminee;
    }

    public static Partie create(Joueur joueur, String motADeviner) {
        return new Partie(joueur, motADeviner, 0, false);
    }

    public static Partie create(Joueur joueur, String motADeviner, int nbEssais) {
        return new Partie(joueur, motADeviner, nbEssais, false);
    }

    public Joueur getJoueur() {
        return this.joueur;
    }

    public int getNbEssais() {
        return this.nbEssais;
    }

    public String getMot() {
        return this.motADeviner;
    }

    public Reponse tourDeJeu(String motPropose) {
        if ((!partieTerminee) && (nbEssais <= NB_ESSAIS_MAX)){
            Reponse reponse = new Reponse(motADeviner);
            reponse.compare(motPropose);
            if ((reponse.lettresToutesPlacees()) || (nbEssais + 1 >= NB_ESSAIS_MAX)){
                this.done();
            }
            nbEssais++;
            return reponse;
        }else{
            return null;
        }
    }

    public boolean isTerminee() {
        return this.partieTerminee;
    }

    void done() {
        this.partieTerminee = true;
    }

}
