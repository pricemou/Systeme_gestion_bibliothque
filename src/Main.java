import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Interface utilisateur
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\nBienvenue dans la bibliothèque !");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Rechercher un livre");
            System.out.println("3. Emprunter un livre");
            System.out.println("4. Rendre un livre");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne

            switch (choix) {
                case 2:
                    afficherMenuRecherche(scanner);
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
    }

    public static void afficherMenuRecherche(Scanner scanner) {
        System.out.println("\nMéthodes de recherche :");
        System.out.println("1. Recherche linéaire avec liste chaînée (pour les petites bibliothèques)");
        System.out.println("2. Recherche binaire (pour les bibliothèques triées par titre ou par auteur)");
        System.out.println("3. Recherche dans un arbre binaire (pour les bibliothèques organisées par catégorie ou genre)");
        System.out.println("4. Utilisation d'une table de hachage (pour des recherches rapides basées sur l'ISBN ou d'autres identifiants uniques)");
        System.out.print("Votre choix : ");
        int choixMethode = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne
        switch (choixMethode) {
            case 1:
                a 
                // Implémenter la recherche linéaire avec une liste chaînée
                // Appel à une méthode dédiée
                break;
            case 2:
                // Implémenter la recherche binaire
                // Appel à une méthode dédiée
                break;
            case 3:
                // Implémenter la recherche dans un arbre binaire
                // Appel à une méthode dédiée
                break;
            case 4:
                // Implémenter l'utilisation d'une table de hachage
                // Appel à une méthode dédiée
                break;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }
    }


}
