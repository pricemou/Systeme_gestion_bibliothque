// Définition de la classe Livre
public class Book {
    int id;
    String titre;
    String auteur;
    String ISBN;
    String categorie; 
    boolean disponible;
    String emprunteur; // Nouveau champ pour stocker le nom de l'emprunteur


    public Book(int id, String titre, String auteur, String ISBN, String categorie) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.ISBN = ISBN;
        this.categorie = categorie;
        this.disponible = true;
        this.emprunteur = ""; // Initialiser l'emprunteur à une chaîne vide
    }

    // Méthode pour obtenir le titre du livre
    public String getTitre() {
        return titre;
    }

    // Méthode pour obtenir la catégorie du livre
    public String getCategorie() {
        return categorie;
    }

    // Méthode pour obtenir l'auteur du livre
    public String getAuteur() {
        return auteur;
    }

    public String getIsbn() {
        return ISBN;
    }
}