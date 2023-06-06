import PackageArticoli.Articolo;
import PackageArticoli.Calcolo;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalcoloTest {



    @Test
    @DisplayName("TestConValoriValidi") //white
    void ValoriValidi() {
        List<Articolo> articoli = new ArrayList<>();
        Calcolo calcoloTest = new Calcolo();
        Assertions.assertEquals(6, calcoloTest.metodoDiCalcolo("alfa", 2, 3, articoli));
    }

    @Test   //white
    @DisplayName("ProvaCambioPrezzo")
    void ProvaCambioPrezzo() {
        List<Articolo> articoli = new ArrayList<>();
        Calcolo calcoloTest = new Calcolo();
        calcoloTest.metodoDiCalcolo("alfa", 4, 1, articoli);
        Assertions.assertEquals(12, calcoloTest.metodoDiCalcolo("alfa", 6, 3, articoli));
    }

    @Test   //white
    @DisplayName("ScontoOltreI100Spesi")
    void PercentualeDiScontoSuSpesaMaggioreOUgualeA100() {
        List<Articolo> articoli = new ArrayList<>();
        Calcolo calcoloTest = new Calcolo();
        Assertions.assertAll(   ()-> assertEquals(99, calcoloTest.metodoDiCalcolo("alfa", 49.5, 2, articoli)),
                ()-> assertEquals(80, calcoloTest.metodoDiCalcolo("bravo", 50, 2, articoli)),
                ()-> assertEquals(80.8, calcoloTest.metodoDiCalcolo("charlie", 50.5,2, articoli))
        );

    }

    @Test //black
    @DisplayName("TestConNomeArticoloNullo")
    void NomeArticoloNullo() {
        List<Articolo> articoli = new ArrayList<>();
        Calcolo calcoloTest = new Calcolo();
        assertThrows(RuntimeException.class,
                () -> calcoloTest.metodoDiCalcolo("", 2,4, articoli));
    }


    @Test   //black
    @DisplayName("PrezzoArticoloNonValido")
    void PrezzoArticoloMinoreOUgualeAZero() {
        List<Articolo> articoli = new ArrayList<>();
        Calcolo calcoloTest = new Calcolo();
        assertThrows(RuntimeException.class,
                () -> calcoloTest.metodoDiCalcolo("Articolo di prova", -7,4, articoli));
    }

    @Test //black
    @DisplayName("Quantità non valida")
    void QuantitaMinoreOUgualeAZero() {
        List<Articolo> articoli = new ArrayList<>();
        Calcolo calcoloTest = new Calcolo();
        assertThrows(RuntimeException.class,
                () -> calcoloTest.metodoDiCalcolo("Articolo di prova", 4,-5, articoli));
    }

    @Test       //black
    @DisplayName("Lista nulla")
    void ListaNulla() {
        Calcolo calcoloTest = new Calcolo();
        assertThrows(RuntimeException.class,
                () -> calcoloTest.metodoDiCalcolo("Articolo di prova", 4,9, null));
    }

    @Test
    public void VerificaDati() {
        Calcolo calcolo = new Calcolo();
        List<Articolo> articoli = new ArrayList<>();

        double costoArticolo = calcolo.metodoDiCalcolo("Sedia", 20, 2, articoli);

        Assertions.assertAll(   ()-> assertEquals(1, articoli.size()),
                ()-> assertEquals("Sedia", articoli.get(0).getNome()),
                ()-> assertEquals(20, articoli.get(0).getPrezzo()),
                ()-> assertEquals(2, articoli.get(0).getQuantita())
        );
    }

}