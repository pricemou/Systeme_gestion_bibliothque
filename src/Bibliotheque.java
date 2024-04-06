import java.util.LinkedList;
import java.util.Scanner;

public class Bibliotheque {
    private LinkedList<Livre> livres = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    // Méthode pour ajouter un livre
    public Livre ajouterLivre() {
        System.out.println("\tEntrer le titre du livre :");
        String titre = scanner.nextLine();
        System.out.println("\tEntrer le nom de l'auteur :");
        String auteur = scanner.nextLine();
        System.out.println("\tEntrer l'ISBN :");
        String ISBN = scanner.nextLine();

        Livre nouveauLivre = new Livre(titre, auteur, ISBN);
        livres.add(nouveauLivre);
        System.out.println("\tLivre ajouté avec succès !");
        return nouveauLivre;
    }

    // Méthode pour emprunter un livre
    public void emprunterLivre() {
        System.out.println("\tEntrez le titre ou l'auteur du livre que vous souhaitez emprunter :");
        String recherche = scanner.nextLine();

        boolean livreTrouve = false;
        LinkedList<Livre> livresTrouves = new LinkedList<>(); // Liste pour stocker les livres correspondants trouvés

        // Implémentation d'une recherche séquentielle pour parcourir chaque élément de la liste
        for (Livre livre : livres) {
            if (livre.getTitre().equalsIgnoreCase(recherche) || livre.getAuteur().equalsIgnoreCase(recherche)) {
                livresTrouves.add(livre); // Ajoutez le livre trouvé à la liste
                livreTrouve = true;
            }
        }

        if (livreTrouve) {
            // Si un ou plusieurs livres correspondants ont été trouvés
            if (livresTrouves.size() > 1) {
                // Si plusieurs livres ont le même auteur, demandez à l'utilisateur de choisir
                System.out.println("\tPlusieurs livres correspondent à votre recherche. Choisissez lequel :");
                int i = 1;
                for (Livre livre : livresTrouves) {
                    System.out.println(i + ". " + livre.getTitre());
                    i++;
                }
                System.out.println("Votre choix :");
                int choix = scanner.nextInt();
                scanner.nextLine(); // Pour consommer la nouvelle ligne après la saisie d'un nombre
                Livre livreChoisi = livresTrouves.get(choix - 1);
                emprunterLivre(livreChoisi); // Empruntez le livre choisi
            } else {
                // Sinon, empruntez le seul livre trouvé
                emprunterLivre(livresTrouves.getFirst());
            }
        } else {
            System.out.println("Aucun livre correspondant trouvé.");
        }
    }

    // Méthode surchargée pour emprunter un livre spécifique
    public void emprunterLivre(Livre livre) {
        if (livre.estDisponible()) {
            livre.setDisponible(false);
            System.out.println("Vous avez emprunté le livre : " + livre.getTitre());
        } else {
            System.out.println("Désolé, le livre " + livre.getTitre() + " est déjà emprunté.");
        }
    }
    // Méthode pour retourner un livre en utilisant le nom de l'auteur
    public void retournerLivre() {
        System.out.println("\tEntrez le titre ou l'auteur du livre que vous souhaitez retourner :");
        String recherche = scanner.nextLine();
        boolean livreTrouve = false;
        // Parcours de la liste des livres
        for (Livre livre : livres) {
            if (livre.getAuteur().equalsIgnoreCase(livre.getAuteur()) && !livre.estDisponible()) {
                livre.setDisponible(true); // Marquer le livre comme disponible
                System.out.println(livre.getTitre()+ " retourné avec succès");
                livreTrouve = true;
                break; // Sortie de la boucle dès que le livre est trouvé et retourné
            }
        }
    }

    // Méthode pour fermer le scanner
    public void fermerScanner() {
        scanner.close();
    }
}
