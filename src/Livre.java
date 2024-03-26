

// Définition de la classe Livre
class Livre {
    int id;
    String titre;
    String auteur;
    String ISBN;
    boolean disponible; vvg

    public Livre(int id, String titre, String auteur, String ISBN) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.ISBN = ISBN;
        this.disponible = true;
    }
}