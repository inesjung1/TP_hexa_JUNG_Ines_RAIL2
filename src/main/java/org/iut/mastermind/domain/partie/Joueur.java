package org.iut.mastermind.domain.partie;

public class Joueur {

    private final String nom;

    // constructeur
    public Joueur(String nom) {
        this.nom = nom;
    }

    // getter nom joueur
    public String getNom() {
        return this.nom;
    }

    // equals
    @Override
    public boolean equals(Object o) {
       if (this == o) {
           return true;
       }
       if (o == null || getClass() != o.getClass()) {
              return false;
       }
       Joueur joueur = (Joueur) o;
       return nom.equals(joueur.nom);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }



}
