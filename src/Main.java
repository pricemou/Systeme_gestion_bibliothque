// MEMBRES DU GROUPE
// Yann Epiphane Djeredou
// Fromon Claude Pricemou
// Cherlie Rivage



import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Interface utilisateur
            Scanner scanner = new Scanner(System.in);
            Library library = new Library();
            BinaryTree binaryTree = new BinaryTree(); // Création de l'arbre binaire

            // Ajout des livres par défaut
            ajouterLivresParDefaut(library, binaryTree);

            int choix;

            do {
                System.out.println("\nBienvenue dans la bibliothèque !");
                System.out.println("1. Ajouter un livre");
                System.out.println("2. Afficher les livres");
                System.out.println("3. Rechercher un livre");
                System.out.println("4. Emprunter un livre");
                System.out.println("5. Rendre un livre");
                System.out.println("0. Quitter");
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();
                scanner.nextLine(); // Pour consommer la nouvelle ligne

                switch (choix) {
                    case 1:
                        ajouterLivre(library, scanner);
                        break;
                    case 2:
                        library.afficherLivres();
                        break;
                    case 3:
                        afficherMenuRecherche(library, scanner, binaryTree);
                        break;
                    case 4:
                        emprunterLivreParNom(library, scanner);
                        break;
                    case 5:
                        rendreLivre(library, scanner);
                        break;
                    case 0:
                        System.out.println("Merci d'avoir utilisé notre bibliothèque !");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            } while (choix != 0);

            // Fermeture du scanner
            scanner.close();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite : " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Méthode pour ajouter des livres par défaut à la bibliothèque et à l'arbre binaire
    public static void ajouterLivresParDefaut(Library library, BinaryTree binaryTree) {
        library.ajouterLivre(1, "Le seigneur des anneaux", "J.R.R. Tolkien", "9782075061386", "Fantasy");
        library.ajouterLivre(2, "Harry Potter", "J.K. Rowling", "9782070643028", "Fantasy");
        library.ajouterLivre(3, "1984", "George Orwell", "9782070721023", "Science-Fiction");
        library.ajouterLivre(4, "Le Petit Prince", "Antoine de Saint-Exupéry", "9782070612758", "Fiction");
        library.ajouterLivre(5, "L'Alchimiste", "Paulo Coelho", "9782253009119", "Fiction");
        library.ajouterLivre(6, "Les Misérables", "Victor Hugo", "9782266129199", "Classique");
        library.ajouterLivre(7, "Le Hobbit", "J.R.R. Tolkien", "9782070612888", "Fantasy");
        library.ajouterLivre(8, "Don Quichotte", "Miguel de Cervantes", "9782070368172", "Classique");
        library.ajouterLivre(9, "Orgueil et Préjugés", "Jane Austen", "9782070409720", "Romance");
        library.ajouterLivre(10, "Les Aventures de jean", "Arthur Conan Doyle", "9782070368073", "Mystère");

        // Ajout des livres à l'arbre binaire
        for (Book book : library.getListeLivres()) {
            binaryTree.insert(book);
        }
    }

    // Méthode pour afficher le menu de recherche
    public static void afficherMenuRecherche(Library library, Scanner scanner, BinaryTree binaryTree) {
        System.out.println("\nMéthodes de recherche :");
        System.out.println("1. Recherche linéaire avec liste chaînée (pour les petites bibliothèques)");
        System.out.println("2. Recherche binaire (pour les bibliothèques triées par titre ou par auteur)");
        System.out.println(
                "3. Recherche dans un arbre binaire (pour les bibliothèques organisées par catégorie ou genre)");
        System.out.println(
                "4. Utilisation d'une table de hachage (pour des recherches rapides basées sur l'ISBN ou d'autres identifiants uniques)");
        System.out.print("Votre choix : ");
        int choixMethode = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne
        switch (choixMethode) {
            case 1:
                rechercherLivre(library, scanner);
                break;
            case 2:
                rechercherLivreBinaire(library, scanner);
                break;
            case 3:
                rechercherParCategorie(library, scanner, binaryTree);
                break;
            case 4:
                rechercherParISBN(library, scanner);
                break;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }
    }

    // Méthode pour ajouter un livre à la bibliothèque
    public static void ajouterLivre(Library library, Scanner scanner) {
        System.out.println("\nAjouter un livre :");
        // Demander les détails du livre à l'utilisateur
        System.out.print("ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Titre : ");
        String titre = scanner.nextLine();
        System.out.print("Auteur : ");
        String auteur = scanner.nextLine();
        System.out.print("ISBN : ");
        String isbn = scanner.nextLine();
        System.out.print("Catégorie : ");
        String categorie = scanner.nextLine(); // Demander la catégorie

        // Ajouter le livre à la bibliothèque
        library.ajouterLivre(id, titre, auteur, isbn, categorie); // Passer la catégorie en paramètre
    }

    // Méthode pour rechercher un livre par titre
    public static void rechercherLivre(Library library, Scanner scanner) {
        System.out.println("\nRechercher un livre par son titre :");
        System.out.print("Entrez le titre du livre : ");
        String titre = scanner.nextLine();
        Book livre = library.rechercherParTitre(titre);
        if (livre != null) {
            System.out.println("Livre trouvé : " + livre.titre + " par " + livre.auteur);
        } else {
            System.out.println("Aucun livre trouvé avec le titre spécifié.");
        }
    }

    // Méthode pour rechercher un livre par titre avec recherche binaire
    public static void rechercherLivreBinaire(Library library, Scanner scanner) {
        System.out.println("\nRechercher un livre par son titre (recherche binaire) :");
        System.out.print("Entrez le titre du livre : ");
        String titre = scanner.nextLine();
        Book livre = library.rechercherParTitreBinaire(titre);
        if (livre != null) {
            System.out.println("Livre trouvé : " + livre.titre + " par " + livre.auteur);
        } else {
            System.out.println("Aucun livre trouvé avec le titre spécifié.");
        }
    }

    // Méthode pour rechercher un livre par catégorie
    public static void rechercherParCategorie(Library library, Scanner scanner, BinaryTree binaryTree) {
        System.out.println("\nRechercher un livre par catégorie :");
        System.out.print("Entrez la catégorie du livre : ");
        String categorie = scanner.nextLine();

        // Rechercher les livres dans l'arbre binaire
        List<Book> livresTrouves = binaryTree.searchByCategory(categorie);
        if (!livresTrouves.isEmpty()) {
            System.out.println("Livres trouvés dans la catégorie " + categorie + " :");
            for (Book livre : livresTrouves) {
                System.out.println(livre.getTitre() + " par " + livre.getAuteur());
            }
        } else {
            System.out.println("Aucun livre trouvé dans la catégorie spécifiée.");
        }
    }

    // Méthode pour rechercher un livre par ISBN
    public static void rechercherParISBN(Library library, Scanner scanner) {
        System.out.println("\nRechercher un livre par ISBN :");
        System.out.print("Entrez l'ISBN du livre : ");
        String isbn = scanner.nextLine();

        // Rechercher le livre par son ISBN
        Book livreTrouve = library.rechercherParISBN(isbn);
        if (livreTrouve != null) {
            System.out.println("Livre trouvé : " + livreTrouve.titre + " par " + livreTrouve.auteur);
        } else {
            System.out.println("Aucun livre trouvé avec l'ISBN spécifié.");
        }
    }

    // Méthode pour emprunter un livre par son nom
    public static void emprunterLivreParNom(Library library, Scanner scanner) {
        System.out.println("\nEmprunter un livre par son nom :");
        System.out.print("Entrez le nom de l'emprunteur : ");
        String nomEmprunteur = scanner.nextLine();
        System.out.print("Entrez le nom du livre : ");
        String nomLivre = scanner.nextLine();
        if (library.emprunterLivreParNom(nomLivre, nomEmprunteur)) {
            System.out.println("Livre emprunté avec succès par " + nomEmprunteur);
        } else {
            System.out.println("Le livre n'a pas pu être emprunté.");
        }
    }

    // Méthode pour rendre un livre
    public static void rendreLivre(Library library, Scanner scanner) {
        System.out.println("\nRendre un livre :");
        System.out.print("Entrez le titre du livre : ");
        String nomLivre = scanner.nextLine();
        if (library.rendreLivre(nomLivre)) {
            System.out.println("Livre rendu avec succès.");
        } else {
            System.out.println("Livre non trouvé ou déjà disponible.");
        }
    }

}
