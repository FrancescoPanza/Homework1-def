import PackageArticoli.Articolo;
import PackageArticoli.Calcolo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalcoloTest {

    @Test
    @DisplayName("TestConValoriValidi")
    void metodoDiCalcolo() {
        List<Articolo> articoli = new ArrayList<>();
        Calcolo calcoloTest = new Calcolo();
        Assertions.assertEquals(6, calcoloTest.metodoDiCalcolo("alfa", 2, 3, articoli));
    }

    @Test
    @DisplayName("TestConNomeArticoloNullo")
    void T2() {
        List<Articolo> articoli = new ArrayList<>();
        Calcolo calcoloTest = new Calcolo();
        assertThrows(RuntimeException.class,
                () -> calcoloTest.metodoDiCalcolo("", 2,4, articoli));
    }


    @Test
    @DisplayName("PrezzoArticoloNonValido")
    void T3() {
        List<Articolo> articoli = new ArrayList<>();
        Calcolo calcoloTest = new Calcolo();
        assertThrows(RuntimeException.class,
                () -> calcoloTest.metodoDiCalcolo("Articolo di prova", -7,4, articoli));
    }

    @Test
    @DisplayName("Quantità non valida")
    void T4() {
        List<Articolo> articoli = new ArrayList<>();
        Calcolo calcoloTest = new Calcolo();
        assertThrows(RuntimeException.class,
                () -> calcoloTest.metodoDiCalcolo("Articolo di prova", 4,-5, articoli));
    }

    @Test
    @DisplayName("Lista nulla")
    void T5() {
        Calcolo calcoloTest = new Calcolo();
        assertThrows(RuntimeException.class,
                () -> calcoloTest.metodoDiCalcolo("Articolo di prova", 4,9, null));
    }

    @Test
    @DisplayName("ProvaCambioPrezzo")
    void T6() {
        List<Articolo> articoli = new ArrayList<>();
        Calcolo calcoloTest = new Calcolo();
        calcoloTest.metodoDiCalcolo("alfa", 4, 1, articoli);
        Assertions.assertEquals(12, calcoloTest.metodoDiCalcolo("alfa", 2, 3, articoli));
    }

    @Test
    @DisplayName("ScontoOltreI100Spesi")
    void T7() {
        List<Articolo> articoli = new ArrayList<>();
        Calcolo calcoloTest = new Calcolo();
        Assertions.assertAll(   ()-> assertEquals(99, calcoloTest.metodoDiCalcolo("alfa", 49.5, 2, articoli)),
                                ()-> assertEquals(80, calcoloTest.metodoDiCalcolo("bravo", 50, 2, articoli)),
                                ()-> assertEquals(80.8, calcoloTest.metodoDiCalcolo("charlie", 50.5,2, articoli))
        );

    }

}