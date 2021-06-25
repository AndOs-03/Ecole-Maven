package com.andos.ecole;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class Ecole {

    private String nom;
    private final int nombreSalleClasse;
    private int nombreMaxEleveClasse;
    private int nombreTotalEleve;
    private double montantScolarite;
    private Collection<Classe> listeClasse;

    public Ecole(String nom, int nombreSalleClasse, int nombreMaxEleveClasse, double montantScolarite) {
        this.nom = nom;
        this.nombreSalleClasse = nombreSalleClasse;
        this.nombreMaxEleveClasse = nombreMaxEleveClasse;
        this.nombreTotalEleve = 0;
        this.montantScolarite = montantScolarite;
        this.listeClasse = new HashSet<>();
    }

    public String getNom() {
        return nom;
    }

    public int getNombreSalleClasse() {
        return nombreSalleClasse;
    }

    public int getNombreMaxEleveClasse() {
        return nombreMaxEleveClasse;
    }

    public int getNombreTotalEleve() {
        return nombreTotalEleve;
    }

    public double getMontantScolarite() {
        return montantScolarite;
    }

    public int getNombreDeClasseActuelle() {
        return this.listeClasse.size();
    }

    public void setNom(String nom) {
        if (nom == null || nom.length() <= 3) {
            System.out.println("Valeur incorrecte pour le nom de l'école");
        }
        else {
            this.nom = nom;
        }
    }

    public void setNombreMaxEleveClasse(int nombreMaxEleveClasse) {
        if (nombreMaxEleveClasse <= 0) {
            System.out.println("Valeur incorrecte, saisir un nombre positif");
        }
        else {
            this.nombreMaxEleveClasse = nombreMaxEleveClasse;
        }
    }

    public void setMontantScolarite(double montantScolarite) {
        if (montantScolarite <= 0) {
            System.out.println("Valeur incorrecte pour le montant");
        }
        else {
            this.montantScolarite = montantScolarite;
        }
    }

    public void ajouterClasse(Classe classe) {
        this.listeClasse.add(classe);
    }

    public void incrementerNombreEleve() {
        this.nombreTotalEleve++;
    }
}
