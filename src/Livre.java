

// Définition de la classe Livre et ses attributs
class Livre {
  // private  int id; -- Je pense qu'on peut utiliser l'ISBN pour identifier de façon unique chaque livre pas besoin d'un identifiant
    private String titre;
   private  String auteur;
    private String ISBN;
   private  boolean disponible;

   // Constructeur
    public Livre(int id, String titre, String auteur, String ISBN) {
       // this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.ISBN = ISBN;
        this.disponible = true;
    }
// Les accesseurs et mutateurs

  /*  public int getId() {
        return id;
    }
    */

    public String getTitre(){
        return titre;
    }
    public String getAuteur(){
        return auteur;
    }
    public String getISBN(){
        return ISBN;
    }


/*    public void setId(int id) {
        this.id = id;
    }
*/
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }


    // Méthode toString
    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}