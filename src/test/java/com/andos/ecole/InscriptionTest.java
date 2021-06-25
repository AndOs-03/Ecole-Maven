package com.andos.ecole;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class InscriptionTest {

    static Ecole ecole1;

    @BeforeAll
    static void setUp() {
        ecole1 = new Ecole("epp1", 12, 25, 25000);
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
        Eleve eleve = mock(Eleve.class);
        Versement versement = new VersementManuel();

        // When
        versement.faireVersement(eleve, 2000, 1);
    }
}
