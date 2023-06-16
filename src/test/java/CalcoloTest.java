import PackageArticoli.Articolo;
import PackageArticoli.Calcolo;
import net.jqwik.api.Property;
import org.junit.jupiter.api.*;

import java.beans.BeanProperty;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CalcoloTest {
    private Calcolo calcoloTest;
    private List<Articolo> articoli;
    @BeforeEach
    void set(){
        calcoloTest = new Calcolo();
        articoli = new ArrayList<>();
    }

    @Test
    @DisplayName("Test con input validi") //white
    void ValoriValidi() {
        Assertions.assertEquals(6, calcoloTest.metodoDiCalcolo("alfa", "2", "3", articoli));
    }


    @Test   //white
    @DisplayName("prova del cambio prezzo")
    void ProvaCambioPrezzo() {
        calcoloTest.metodoDiCalcolo("alfa", "4", "1", articoli);
        Assertions.assertEquals(12, calcoloTest.metodoDiCalcolo("alfa", "6", "3", articoli));
    }

    @Test   //white
    @DisplayName("Sconto oltre i 100 spesi")
    void PercentualeDiScontoSuSpesaMaggioreOUgualeA100() {
        assertAll(   ()-> assertEquals(99, calcoloTest.metodoDiCalcolo("alfa", "49.5", "2", articoli)),
                ()-> assertEquals(80, calcoloTest.metodoDiCalcolo("bravo", "50", "2", articoli)),
                ()-> assertEquals(80.8, calcoloTest.metodoDiCalcolo("charlie", "50.5","2", articoli))
        );
    }

    @Test   //black
    @DisplayName("Prezzo dell'articolo inserito non valido")
    void PrezzoArticoloMinoreOUgualeAZero() {
        assertThrows(RuntimeException.class,
                () -> calcoloTest.metodoDiCalcolo("Articolo di prova", "-7","4", articoli));
    }

    @Test //black
    @DisplayName("Quantità inserita non valida")
    void QuantitaMinoreOUgualeAZero() {
        assertThrows(RuntimeException.class,
                () -> calcoloTest.metodoDiCalcolo("Articolo di prova", "4","-5", articoli));
    }
    @Test
    @DisplayName("Test con input validi, prezzo con decimali") //white
    void ValoriValidi2() {

        Assertions.assertEquals(4.50, calcoloTest.metodoDiCalcolo("alfa", "2.25", "2", articoli));
    }
    @Test
    @DisplayName("input non validi")
    void TestDelleEccezioni(){
        assertAll(
                () -> assertThrows(RuntimeException.class, () -> {
                    calcoloTest.metodoDiCalcolo("aaa", "/","4", articoli);
                }),
                () -> assertThrows(RuntimeException.class, () -> {
                    calcoloTest.metodoDiCalcolo("aaa", "2","/", articoli);
                }),
                () -> assertThrows(RuntimeException.class, () -> {
                    calcoloTest.metodoDiCalcolo(" ", "6","4", articoli);
                }),
                () -> assertThrows(RuntimeException.class, () -> {
                    calcoloTest.metodoDiCalcolo("", "6","4", articoli);
                }),
                () -> assertThrows(RuntimeException.class, () -> {
                    calcoloTest.metodoDiCalcolo(null, "7","4", articoli);
                }),
                () -> assertThrows(RuntimeException.class, () -> {
                    calcoloTest.metodoDiCalcolo("articolo di prova", " ","4", articoli);
                }),
                () -> assertThrows(RuntimeException.class, () -> {
                    calcoloTest.metodoDiCalcolo("articolo di prova", null,"4", articoli);
                }),
                () -> assertThrows(RuntimeException.class, () -> {
                    calcoloTest.metodoDiCalcolo("articolo di prova", "5"," ", articoli);
                }),
                () -> assertThrows(RuntimeException.class, () -> {
                    calcoloTest.metodoDiCalcolo("articolo di prova", "5",null, articoli);
                }),
                () -> assertThrows(RuntimeException.class, () -> {
                    calcoloTest.metodoDiCalcolo("articolo di prova", "5","8", null);
                }),
                () -> assertThrows(RuntimeException.class, () -> {
                    calcoloTest.metodoDiCalcolo("articolo di prova", "2.325","8", articoli);
                })

        );
    }




    @Test
    public void VerificaDati() {
        Calcolo calcolo = new Calcolo();
        double costoArticolo = calcolo.metodoDiCalcolo("Sedia", "20", "2", articoli);

        assertAll(   ()-> assertEquals(1, articoli.size()),
                ()-> assertEquals("Sedia", articoli.get(0).getNome()),
                ()-> assertEquals(20, articoli.get(0).getPrezzo()),
                ()-> assertEquals(2, articoli.get(0).getQuantita())
        );
    }




}