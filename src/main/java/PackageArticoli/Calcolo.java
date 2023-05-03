package PackageArticoli;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Calcolo {

    public void metodoDiCalcolo() {
        Scanner scanner = new Scanner(System.in);

        List<Articolo> articoli = new ArrayList<>();

        {

            while (true) {
                System.out.print("Nome articolo (o 'fine' per terminare): ");
                String nomeArticolo = scanner.nextLine();
                if (nomeArticolo.equals("fine")) {
                    break;
                }

                // Cerca se l'articolo è già stato inserito in precedenza
                Optional<Articolo> articoloEsistente = articoli.stream()
                        .filter(a -> a.getNome().equals(nomeArticolo))
                        .findFirst();

                Articolo articolo;
                if (articoloEsistente.isPresent()) {
                    // Se l'articolo esiste già, utilizza il suo prezzo
                    articolo = articoloEsistente.get();
                } else {
                    // Altrimenti, chiedi il prezzo all'utente
                    System.out.print("Prezzo articolo: ");
                    double prezzoArticolo = scanner.nextDouble();
                    articolo = new Articolo(nomeArticolo, prezzoArticolo);
                    articoli.add(articolo);
                }

                System.out.print("Quantità articolo: ");
                int quantitaArticolo = scanner.nextInt();
                scanner.nextLine(); // Consuma il carattere di fine linea dopo la lettura dell'intero

                articolo.aggiungiQuantita(quantitaArticolo);
                double costoArticolo = articolo.getPrezzo() * quantitaArticolo;
                System.out.printf("Il costo totale di %d %s è %.2f\n", quantitaArticolo, articolo.getNome(), costoArticolo);

            }

            System.out.println("Costi totali:");
            for (Articolo articolo : articoli) {
                double costoTotale = articolo.getPrezzo() * articolo.getQuantita();
                System.out.printf("%s: %.2f\n", articolo.getNome(), costoTotale);
            }

        }
        scanner.close();
    }
}
