package PackageArticoli;

class Articolo {
    private String nome;
    private double prezzo;
    private int quantita;

    public Articolo(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = 0;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void aggiungiQuantita(int quantitaAggiunta) {
        quantita += quantitaAggiunta;
    }
}