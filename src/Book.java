// Définition de la classe Livre
class Library {
    int id;
    String titre;
    String auteur;
    String ISBN;
    boolean disponible;

    public Library(int id, String titre, String auteur, String ISBN) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.ISBN = ISBN;
        this.disponible = true;
    }
    
}