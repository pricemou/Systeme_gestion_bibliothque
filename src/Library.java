import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;

class Library {
    private List<Book> livres;
    private Hashtable<String, Book> isbnHashtable; 

    public Library() {
        this.livres = new ArrayList<>();
        this.isbnHashtable = new Hashtable<>();
    }

    // Méthode pour ajouter un livre à la bibliothèque
    public void ajouterLivre(int id, String titre, String auteur, String isbn, String categorie) {
        Book livre = new Book(id, titre, auteur, isbn, categorie); // Ajoutez la catégorie lors de la création du livre
        livres.add(livre);
        isbnHashtable.put(isbn, livre);; // Ajouter une entrée dans la table de hachage
        Collections.sort(livres, Comparator.comparing(Book::getTitre));
        System.out.println("Livre ajouté avec succès à la bibliothèque !");
    }

    public List<Book> getListeLivres() {
        return livres;
    }

    // Méthode pour afficher les livres de la bibliothèque
    public void afficherLivres() {
        System.out.println("\nListe des livres dans la bibliothèque :\n");
        System.out.printf("%-5s%-30s%-30s%-15s%-15s%-10s\n", "ID", "Titre", "Auteur", "ISBN", "Catégorie", "Disponible");
        for (Book livre : livres) {
            System.out.printf("%-5d%-30s%-30s%-15s%-15s%-10s\n", livre.id, livre.titre, livre.auteur, livre.ISBN, livre.getCategorie(), (livre.disponible ? "Oui" : "Non"));
        }
    }

    // Méthode pour rechercher un livre par titre dans la bibliothèque
    public Book rechercherParTitre(String titre) {
        for (Book livre : livres) {
            if (livre.titre.equalsIgnoreCase(titre)) {
                return livre;
            }
        }
        return null; // Aucun livre avec le titre spécifié trouvé
    }

    public Book rechercherParTitreBinaire(String titre) {
        // Assurez-vous que la liste de livres est triée par titre avant d'effectuer une recherche binaire
        Collections.sort(livres, Comparator.comparing(Book::getTitre));
    
        int debut = 0;
        int fin = livres.size() - 1;
    
        while (debut <= fin) {
            int milieu = debut + (fin - debut) / 2;
            String titreMilieu = livres.get(milieu).getTitre();
            
            // Vérifier si le titre recherché est au milieu
            if (titreMilieu.equalsIgnoreCase(titre)) {
                return livres.get(milieu);
            }
            // Si le titre recherché est plus petit que le titre au milieu, recherchez dans la partie gauche
            else if (titre.compareToIgnoreCase(titreMilieu) < 0) {
                fin = milieu - 1;
            }
            // Sinon, recherchez dans la partie droite
            else {
                debut = milieu + 1;
            }
        }
    
        // Si le livre n'est pas trouvé, retournez null
        return null;
    }

    public Book rechercherParISBN(String isbn) {
        return isbnHashtable.get(isbn); // Rechercher le livre par son ISBN dans la table de hachage
    }

    public boolean emprunterLivreParNom(String nomLivre, String nomEmprunteur) {
        for (Book livre : livres) {
            if (livre.titre.equalsIgnoreCase(nomLivre) && livre.disponible) {
                livre.disponible = false;
                livre.emprunteur = nomEmprunteur; // Mettre à jour le champ emprunteur
                return true; // Livre emprunté avec succès
            }
        }
        return false; // Livre non trouvé ou non disponible
    }


    public boolean rendreLivre(String titreLivre) {
        for (Book livre : livres) {
            if (livre.titre.equals(titreLivre) && !livre.disponible) {
                livre.disponible = true;
                livre.emprunteur = "";
                return true;
            }
        }
        return false;
    }
    
    
}
