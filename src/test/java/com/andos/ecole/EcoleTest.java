package com.andos.ecole;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class EcoleTest {

    static Ecole ecole1;
    static Classe classe1;

    @BeforeAll
    static void setUp() {
        ecole1 = new Ecole("epp1", 12, 25, 25000);
        classe1 = new Classe("cp1", ecole1);
    }

    @Test
    void testerInscription() {
        // Given
        Classe classe = new Classe("cp1", ecole1);
        Inscription inscription = new InscriptionManuel();

        // When
        boolean inscriptionReussie = inscription.faireInscription("000001", "AndOs Ouatt", 25, classe);

        // Then
        Assertions.assertTrue(inscriptionReussie);
    }

    @Test
    void testerVersement() {
        // Given
        Eleve eleve = new Eleve("00001", "Ouattara Kouakou", 06, classe1);
        Versement versement = new VersementManuel();

        // When
        boolean versementOk = versement.faireVersement(eleve, 2000, 1);

        // Then
        Assertions.assertTrue(versementOk);
        Assertions.assertEquals(
            eleve.getSommeResteApayer(),
            eleve.getClasse().getEcole().getMontantScolarite() - 2000
        );
    }
}
