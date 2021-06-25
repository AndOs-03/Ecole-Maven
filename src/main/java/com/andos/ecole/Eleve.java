package com.andos.ecole;

import java.util.*;

public class Eleve {

    private final String matricule;
    private final String nomComplet;
    private int age;
    private Classe classe;
    private double sommeResteApayer;
    private Hashtable<Integer, Double> listePaiement;

    public Eleve(String matricule, String nomComplet, int age, Classe classe) {
        this.matricule = matricule;
        this.nomComplet = nomComplet;
        this.age = age;
        this.classe = classe;
        this.sommeResteApayer = classe.getEcole().getMontantScolarite();
        this.listePaiement = new Hashtable<>();
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public int getAge() {
        return age;
    }

    public Classe getClasse() {
        return classe;
    }

    public double getSommeResteApayer() {
        return sommeResteApayer;
    }

    // Obtenir la liste des versement d'un élève
    public Hashtable<Integer, Double> getListePaiement() {
        return listePaiement;
    }

    public void setClasse(Classe classe) {
        if (classe == null) {
            System.out.println("Valeur incorrect pour la classe");
        }
        else {
            this.classe = classe;
        }
    }

    public void setAge(int age) {
        if (age <= 0) {
            System.out.println("Valeur incorrecte pour l'age de l'élève");
        }
        else {
            this.age = age;
        }
    }

    // Ajouter un versement à la liste des versements de l'eleve
    public void ajouterVersement(int numeroTranche, double somme) throws NullPointerException {
        this.listePaiement.put(numeroTranche, somme);
    }

    public void mettreAJourSommeResteAPayer(double sommeVerse) {
        this.sommeResteApayer -= sommeVerse;
    }

    // Cette methode retourne True si l'élève à soldé (somme reste <= 0)
    public boolean aSolder() {
        return this.sommeResteApayer <= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eleve eleve = (Eleve) o;
        return matricule.equals(eleve.matricule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule);
    }
}
