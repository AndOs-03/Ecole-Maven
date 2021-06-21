package com.andos.ecole;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class Classe {

    private String codeClasse;
    private int nombreEleve;
    private final Ecole ecole;
    Collection<Eleve> listeEleve;

    public Classe(String codeClasse, Ecole ecole) {
        this.codeClasse = codeClasse;
        this.nombreEleve = 0;
        this.ecole = ecole;
        this.listeEleve = new HashSet<>();

        ecole.ajouterClasse(this);
    }

    public String getCodeClasse() {
        return codeClasse;
    }

    public int getNombreEleve() {
        return nombreEleve;
    }

    public Ecole getEcole() {
        return ecole;
    }

    public void modifierCodeClasse(String code) {
        if (code == null || code.length() <= 3)
            System.out.println("Valeur incorrecte ou trop courte");
        else
            this.codeClasse = code;
    }

    /* Incrementer le nombre total d'élève d'une école
    (cette methode est appelé lors de la creation d'un élève) */
    public void incrementNombreEleve() {
        this.nombreEleve++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classe classe = (Classe) o;
        return codeClasse.equals(classe.codeClasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeClasse);
    }
}
