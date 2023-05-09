import PackageArticoli.Articolo;
import PackageArticoli.Calcolo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcoloTest {


    @Test
    @DisplayName("Test di prova")
    void provaAssertion() {
        List<Articolo> articoli = new ArrayList<>();
        Calcolo calcoloTest = new Calcolo();
        double prezzo = calcoloTest.metodoDiCalcolo("alfa", 2, 3, articoli);
        Assertions.assertEquals(6, prezzo);
    }
}