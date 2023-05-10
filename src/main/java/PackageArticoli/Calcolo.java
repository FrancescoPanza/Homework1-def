package PackageArticoli;

import java.util.List;
import java.util.Optional;


public class Calcolo {

    public double metodoDiCalcolo(String nomeArticolo, double prezzoArticolo, int quantitaArticolo, List<Articolo> articoli) {


        {


                if(nomeArticolo.isEmpty()){
                    throw new RuntimeException("Nome dell'articolo non inserito");
                }
                if(prezzoArticolo <= 0){
                    throw new RuntimeException("Prezzo articolo non valido");
                }
                if(quantitaArticolo <= 0){
                    throw new RuntimeException("Quantità articolo non valido");
                }
                if(articoli == null){
                    throw new RuntimeException("Nessuna lista passata");
                }

                // Cerca se l'articolo è già stato inserito in precedenza
                Optional<Articolo> articoloEsistente = articoli.stream()
                        .filter(a -> a.getNome().equals(nomeArticolo))
                        .findFirst();

                Articolo articolo;
                if (articoloEsistente.isPresent()) {
                    // Se l'articolo esiste già, utilizza il suo prezzo
                    articolo = articoloEsistente.get();
                    System.out.println("Articolo già esistente, prezzo non modificabile");

                } else {
                    articolo = new Articolo(nomeArticolo, prezzoArticolo);
                    articoli.add(articolo);
                }


                articolo.aggiungiQuantita(quantitaArticolo);
                double costoArticolo = articolo.getPrezzo() * quantitaArticolo;
                if (costoArticolo >= 100) {
                    System.out.println("Complimenti hai ricevuto uno sconto del 20%\n" +
                            "Costo iniziale: " + costoArticolo);
                    costoArticolo = costoArticolo/100 * 80;
                    System.out.println("Costo finale: " + costoArticolo);

                }

                return costoArticolo;

        }

    }
}
