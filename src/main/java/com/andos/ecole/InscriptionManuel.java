package com.andos.ecole;

public class InscriptionManuel implements Inscription {

    @Override
    public boolean faireInscription(String matricule, String nomComplet, int age, Classe classe) {
        int nombreMaxEleveParClasse = classe.getEcole().getNombreMaxEleveClasse();
        int nombreEleveActuelle = classe.getNombreEleve();

        if (nombreEleveActuelle >= nombreMaxEleveParClasse) {
            System.out.println("Cette classe a atteint le nombre maximun d'élève.");
            return false;
        }
        if (matricule.length() < 6) {
            System.out.println("Matricule incompatible");
            return false;
        }
        if (nomComplet.length() < 3) {
            System.out.println("Nom incorrect");
            return false;
        }
        if (age <= 3) {
            System.out.println("Age incorrect (>= 4");
            return false;
        }

        Eleve eleve = new Eleve(matricule, nomComplet, age, classe);
        classe.incrementNombreEleve();
        classe.getEcole().incrementerNombreEleve();

        return true;
    }
}
