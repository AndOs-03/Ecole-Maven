package com.andos.ecole;

import java.util.Enumeration;
import java.util.Hashtable;

public class VersementManuel implements Versement {

    @Override
    public boolean faireVersement(final Eleve eleve, double sommeDuVersement, int numeroTranche) {
        // (-1) Pour ne pas avoir de probleme avec les index du tableau
        numeroTranche -= 1;
        double sommeResteAPayer = eleve.getSommeResteApayer();

        if (sommeDuVersement <= 0) {
            System.out.println("Montant incorrect pour le versement");
            return false;
        }

        if (numeroTranche > 2) {
            System.out.println("Le nombre maximal de tranche est de 3");
            return false;
        }

        if (numeroTranche == 2) {
            if (sommeDuVersement < sommeResteAPayer) {
                System.out.println("Vous êtes à votre dernier versement. \nVous devez payer la totalité : " +
                        "il vous reste '" + sommeResteAPayer + "' à payer.");
                return false;
            }
        }

        if (sommeDuVersement > sommeResteAPayer) {
            System.out.println("Le montant à payé est de " + sommeResteAPayer);
            return false;
        }

        String suffixTexte = numeroTranche == 1 ? "ere" : "eme";
        Hashtable<Integer, Double> listePaiement = eleve.getListePaiement();
        Enumeration<Integer> paiementEnum = listePaiement.keys();

        while (paiementEnum.hasMoreElements()) {
            int key = paiementEnum.nextElement();
            if (listePaiement.containsKey(key)) {
                System.out.println("Vous avez déjà fait le paiement pour la " + key + suffixTexte + " tranche");
                return false;
            }
        }

        eleve.ajouterVersement(numeroTranche, sommeDuVersement);
        eleve.mettreAJourSommeResteAPayer(sommeDuVersement);
        System.out.println("Versement de : " + sommeDuVersement + " enregistré avec succès");
        return true;
    }
}
