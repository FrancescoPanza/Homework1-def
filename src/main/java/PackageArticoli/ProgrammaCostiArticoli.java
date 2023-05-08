package PackageArticoli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgrammaCostiArticoli {
    public static void main(String[] args) {

        Calcolo nuovoCalcolo = new Calcolo();
        Scanner scanner = new Scanner(System.in);
        List<Articolo> articoli = new ArrayList<>();




        while (true) {
            System.out.print("Nome articolo (o 'fine' per terminare): ");
            String nomeArticolo = scanner.nextLine();
            if (nomeArticolo.equals("fine")) {
                break;
            }

            System.out.print("Prezzo articolo: ");
            double prezzoArticolo = scanner.nextDouble();


            System.out.print("Quantità articolo: ");
            int quantitaArticolo = scanner.nextInt();
            scanner.nextLine(); // Consuma il carattere di fine linea dopo la lettura dell'intero

            double costoArticolo = nuovoCalcolo.metodoDiCalcolo(nomeArticolo, prezzoArticolo, quantitaArticolo, articoli);
            System.out.printf("Il costo totale di %d %s è %.2f\n", quantitaArticolo, nomeArticolo, costoArticolo);


        }
    }
}
