package com.andos.ecole;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Scanner;

public class EcoleTest {

//    static Ecole ecole;
//    static Classe classe;
//    static Comptabilite comptabilite;

//    @BeforeAll
//    static void setUp() {
//        ecole = new Ecole("Epp 1", 12, 35, 7500);
//        classe = new Classe("cp1", ecole);
//        comptabilite = new Comptabilite();
//    }

    @Test
    void testerAjouterClasse() {
        // Etant donné que j'ai une nouvelle école 
        Ecole ecole = new Ecole("Epp 1", 12, 35, 7000);

        // Quand j'ajoute une nouvelle classe à cette école
        Classe classe = new Classe("CP 1", ecole);

        // Alors le nombre de classe devrait etre égale à 1
        Assertions.assertEquals(2, ecole.getNombreDeClasseActuelle());
    }

    @Test
    void testerInscription() {
        // Etant donné que j'ai une nouvelle école
        Ecole ecole = new Ecole("Epp 1", 12, 35, 7000);

        // Et une classe
        Classe classe = new Classe("CP 1", ecole);

        // Quand je crée une nouvelle instance de comptabilté
        Comptabilite comptabilite = new Comptabilite();

        // Et que j'essai d'inscrire un nouvel élève
        Optional<Eleve> eleveOptional = comptabilite.inscription("001", "Ouattara Kouakou", 23, classe);

        if (eleveOptional.isPresent()) {
            // Alors le nombre d'élève de la classe devrait etre egale à 1
            Assertions.assertEquals(1, classe.getNombreEleve());

            // Et le nombre d'élèves de l'école devrait etre egale à 1
            Assertions.assertEquals(1, ecole.getNombreTotalEleve());
        }
        else
            System.out.println("La classe n'a pas été créee");
    }
}
