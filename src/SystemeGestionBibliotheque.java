import java.util.*;

public class SystemeGestionBibliotheque {

public static void main(String[]args){
   Scanner sc = new Scanner(System.in);
   int choix;
   do{
      System.out.println("\nMenu:");
      System.out.println("1. Ajouter un livre");
      System.out.println("2. Rechercher un livre");
      System.out.println("3. Emprunter un livre");
      System.out.println("4. Retourner un livre");
      //System.out.println("5. Voir la disponibilité d'un livre");
      System.out.println("0. Quitter");
      System.out.println("Votre choix:");
      choix = sc.nextInt();
      sc.nextLine();  // Consommer la nouvelle ligne

       if (choix == 1) {
           System.out.println("Saisir le titre du livre");
           String titre = sc.nextLine();
           System.out.println("Saisir le nom de l'auteur");
           String auteur = sc.nextLine();
           System.out.println("Saisir l'ISBN du livre");
           String ISBN = sc.nextLine();
       }
   }while (choix !=0);
   sc.close(); // Fermeture de la classe scanner
}

}
