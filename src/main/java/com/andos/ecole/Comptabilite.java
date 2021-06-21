package com.andos.ecole;

import java.util.Optional;

public class Comptabilite {

    private double versement;
    private int numTranche;
    private Eleve eleve;

    public Comptabilite() {
    }

    public Comptabilite(double versement, int numTranche, Eleve eleve) {
        this.versement = versement;
        this.numTranche = numTranche;
        this.eleve = eleve;
    }

    public double getVersement() {
        return versement;
    }

    public int getNumTranche() {
        return numTranche;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setVersement(double versement) {
        this.versement = versement;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public void setNumTranche(int numTranche) {
        this.numTranche = numTranche;
    }

    // Faire le versement d'un élève (Retourne True si le versement s'est éffectué)
    public boolean faireUnPaiement() {
        numTranche -= 1; // Pour ne pas avoir de probleme avec les index du tableau
        if (eleve != null) {
            if (this.versement <= 0) {
                System.out.println("Montant incorrect pour le versement");
                return false;
            }

            if (numTranche > 2) {
                System.out.println("Le nombre maximal de tranche est de 3");
                return false;
            }

            if (numTranche == 2) {
                if (this.versement < eleve.getSommeResteApayer()) {
                    System.out.println("Vous êtes à votre dernier versement. \nVous devez payer la totalité : " +
                            "il vous reste '" + eleve.getSommeResteApayer() + "' à payer.");
                    return false;
                }
            }

            if (this.versement > eleve.getSommeResteApayer()) {
                System.out.println("Le montant à payé est de " + eleve.getSommeResteApayer());
                return false;
            }

            boolean versementAjouter = this.eleve.ajouterVersement(numTranche, versement);
            this.eleve.mettreAJourSommeResteAPayer(versement);
            System.out.println("Versement de : " + versement + " enregistré avec succès");
            return true;
        }

        System.out.println("Choisir un élève pour le versement");
        return false;
    }

    // Faire l'inscription d'un élève : cette methode crée un nouveau élève
    public Optional<Eleve> inscription(String matricule, String nomComplet, int age, Classe classe) {
        if (classe != null) {
            int nombreMaxEleve = classe.getEcole().getNombreMaxEleveClasse();

            if (classe.getNombreEleve() == nombreMaxEleve) {
                System.out.println("Cette classe a atteint le nombre maximun d'élève.");
                return Optional.empty();
            }

            Eleve eleve = new Eleve(matricule, nomComplet, age, classe);

            // On increment le nombre d'éléve de la classe
            classe.incrementNombreEleve();

            // On increment le nombre d'élève de l'école
            classe.getEcole().incrementerNombreEleve();
            return Optional.of(eleve);
        } else {
            System.out.println("Veillez choisir une classe pour l'élève");
            return Optional.empty();
        }
    }
}
