import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;

class Library {
    private List<Book> livres; // Liste des livres dans la bibliothèque
    private Hashtable<String, Book> isbnHashtable; // Table de hachage pour recherches rapides basées sur l'ISBN

    public Library() {
        this.livres = new ArrayList<>(); // Initialisation de la liste des livres
        this.isbnHashtable = new Hashtable<>(); // Initialisation de la table de hachage
    }

    // Méthode pour ajouter un livre à la bibliothèque
    public void ajouterLivre(int id, String titre, String auteur, String isbn, String categorie) {
        Book livre = new Book(id, titre, auteur, isbn, categorie); // Création du livre
        livres.add(livre); // Ajout du livre à la liste
        isbnHashtable.put(isbn, livre); // Ajout d'une entrée dans la table de hachage
        Collections.sort(livres, Comparator.comparing(Book::getTitre)); // Tri des livres par titre
        System.out.println("Livre ajouté avec succès à la bibliothèque !");
    }

    // Méthode pour obtenir la liste des livres
    public List<Book> getListeLivres() {
        return livres;
    }

    // Méthode pour afficher les livres de la bibliothèque

    public void afficherLivres() {
        // Tri des livres par ID
        Collections.sort(livres, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return Integer.compare(book1.getId(), book2.getId());
            }
        });
        
        System.out.println("\nListe des livres dans la bibliothèque :\n");
        System.out.printf("%-5s%-30s%-30s%-15s%-15s%-10s\n", "ID", "Titre", "Auteur", "ISBN", "Catégorie", "Disponible");
        for (Book livre : livres) {
            System.out.printf("%-5d%-30s%-30s%-15s%-15s%-10s\n", livre.getId(), livre.getTitre(), livre.getAuteur(), livre.getIsbn(), livre.getCategorie(), (livre.isDisponible() ? "Oui" : "Non"));
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

    // Méthode pour rechercher un livre par titre (recherche binaire)
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

    // Méthode pour rechercher un livre par ISBN dans la bibliothèque
    public Book rechercherParISBN(String isbn) {
        return isbnHashtable.get(isbn); // Rechercher le livre par son ISBN dans la table de hachage
    }

    // Méthode pour emprunter un livre par son nom
    public boolean emprunterLivreParNom(String nomLivre, String nomEmprunteur) {
        for (Book livre : livres) {
            if (livre.titre.equalsIgnoreCase(nomLivre)) {
                if (livre.disponible) {
                    // Le livre est disponible, donc on peut l'emprunter
                    livre.disponible = false;
                    livre.emprunteur = nomEmprunteur; // Mettre à jour le champ emprunteur
                    return true; // Livre emprunté avec succès
                } else {
                    // Le livre est déjà emprunté
                    System.out.println("Le livre " + livre.titre + " est déjà emprunté par " + livre.emprunteur);
                    return false;
                }
            }
        }
        // Aucun livre trouvé ou aucun livre disponible avec le titre spécifié
        System.out.println("Aucun livre trouvé ou aucun livre disponible avec le titre spécifié.");
        return false;
    }


    // Méthode pour rendre un livre par son titre
    public boolean rendreLivre(String titreLivre) {
        for (Book livre : livres) {
            if (livre.titre.equals(titreLivre) && !livre.disponible) {
                livre.disponible = true;
                livre.emprunteur = "";
                return true; // Livre rendu avec succès
            }
        }
        return false; // Livre non trouvé ou déjà disponible
    }
}
