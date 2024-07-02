public class Utente {

    private String nome;
    private String cognome;
    private String idOppurePassword;
    private Carrello carrelloUtente;
    private Magazzino magazzino; // Riferimento al magazzino per l'interazione

    // Costruttore
    public Utente(String nome, String cognome, String idOppurePassword, Magazzino magazzino) {
        this.nome = nome;
        this.cognome = cognome;
        this.idOppurePassword = idOppurePassword;
        this.carrelloUtente = new Carrello(); // Inizializzo un carrello vuoto
        this.magazzino = magazzino;
    }

    // Metodi per la gestione del carrello -------------------------------------------------------------
    public void aggiungiProdottoAlCarrello(int idProdotto) {
        Prodotto prodotto = magazzino.getProdottoById(idProdotto);
        if (prodotto != null) {
            carrelloUtente.aggiungiProdotto(prodotto);
            magazzino.rimuoviProdotto(prodotto); // Aggiorna il magazzino
            System.out.println("Prodotto con ID " + idProdotto + "aggiunto al carrello con successo!");
        } else {
            System.out.println("Errore: Prodotto con ID " + idProdotto + " non trovato.");
        }
    }

    public void rimuoviProdottoDalCarrello(int idProdotto) {
        Prodotto prodotto = carrelloUtente.rimuoviProdotto(idProdotto);
        if (prodotto != null) {
            magazzino.aggiungiProdotto(prodotto); // Aggiorna il magazzino
            System.out.println("Prodotto rimosso dal carrello con successo!");
        } else {
            System.out.println("Errore: Prodotto con ID " + idProdotto + " non trovato nel carrello.");
        }
    }

    public void visualizzaCarrello() {
        carrelloUtente.stampaCarrello();
    }

    public double calcolaTotaleCarrello() {
        return carrelloUtente.calcolaTotale();
    }

    public void finalizzaAcquisto() {
        magazzino.rimuoviProdottiDalCarrello(carrelloUtente); // Aggiorna il magazzino
        carrelloUtente.svuotaCarrello(); // Pulisce il carrello
        System.out.println("Acquisto finalizzato con successo! Grazie " + nome + " " + cognome + ".");
    }

// Metodi di ricerca nel magazzino (da implementare in base alle specifiche) -------------------------------------------------------
    public void ricercaPerTipo(String tipo) {
        // ... (da integrare una volta definita la classe prodotto)
    }

    public void ricercaPerProduttore(String produttore) {
        // ... (da integrare una volta definita la classe prodotto)
    }

    public void ricercaPerModello(String modello) {
        // ... (da integrare una volta definita la classe prodotto)
    }

    public void ricercaPerPrezzoVendita(double prezzoMinimo, double prezzoMassimo) {
        // ... (da integrare una volta definita la classe prodotto)
    }

    public void ricercaPerPrezzoAcquisto(double prezzoMinimo, double prezzoMassimo) {
        // ... (da integrare una volta definita la classe prodotto)
    }
}
// Servono Getters e Setters alle altre classi?
