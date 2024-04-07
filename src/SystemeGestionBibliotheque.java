import java.util.*;
public class SystemeGestionBibliotheque {

    //Méthode pour afficher le menu principal
    public static void afficherMenuPrincipal() {
        System.out.println("--------------------------------------------------------------------------------------\n");
        System.out.println("\t\t\t\tBienvenue dans notre bibliothèque! \n");
        System.out.println("--------------------------------------------------------------------------------------\n");
        System.out.println("\nMenu:");
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Rechercher un livre");
        System.out.println("3. Emprunter un livre");
        System.out.println("4. Retourner un livre");
        System.out.println("0. Quitter");
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choix;

        Bibliotheque bibliotheque = new Bibliotheque();

        do {
            afficherMenuPrincipal();
            System.out.print("Votre choix: ");

            choix = sc.nextInt();
            sc.nextLine(); // Pour consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    bibliotheque.ajouterLivre();
                    break;
                case 2:
                    afficherSousMenuRecherche(sc);
                    break;
                case 3:
                    bibliotheque.emprunterLivre();
                    break;
                case 4:
                    bibliotheque.retournerLivre();
                    break;
                case 0:
                    System.out.println("Merci d'avoir utilisé notre bibliothèque !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 0);

        // Fermeture du scanner
        sc.close();
    }

    //Méthode pour afficher le sous menu des différentes types de recherche
    public static void afficherSousMenuRecherche(Scanner sc) {
        System.out.println("\nSous-menu de recherche :");
        System.out.println("1. Recherche linéaire avec liste chaînée (pour les petites bibliothèques)");
        System.out.println("2. Recherche binaire (pour les bibliothèques triées par titre ou par auteur)");
        System.out.println("3. Recherche dans un arbre binaire (pour les bibliothèques organisées par catégorie ou genre)");
        System.out.println("4. Utilisation d'une table de hachage (pour des recherches rapides basées sur l'ISBN ou d'autres identifiants uniques)");
        System.out.println("5. Retour au menu principal");
        System.out.print("Votre choix : ");

        int choixMethode = sc.nextInt();
        sc.nextLine(); // Pour consommer la nouvelle ligne

        switch (choixMethode) {
            case 1:
                // Appel de la méthode
                break;
            case 2:
                // Appel de la méthode
                break;
            case 3:
                // Appel de la méthode
                break;
            case 4:
                // Appel à une méthode recherche table de hachage
                break;
            case 5:
                //
                break;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");

        }
    }
}
