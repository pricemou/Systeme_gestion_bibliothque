

// Définition de la classe Livre
class Livre {
    String titre;
    String auteur;
    String ISBN;
    boolean disponible;

    public Livre(String titre, String auteur, String ISBN) {
        this.titre = titre;
        this.auteur = auteur;
        this.ISBN = ISBN;
        this.disponible = true;
    }
}