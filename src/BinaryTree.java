import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private Node root;

    // Constructeur
    public BinaryTree() {
        this.root = null;
    }

    // Classe interne représentant un noeud dans l'arbre binaire
    private static class Node {
        private Book data;
        private Node left;
        private Node right;

        // Constructeur
        public Node(Book data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Méthode pour insérer un livre dans l'arbre
    public void insert(Book book) {
        root = insertRecursive(root, book);
    }

    // Méthode récursive pour insérer un livre
    private Node insertRecursive(Node root, Book book) {
        // Si l'arbre est vide, créez un nouveau noeud avec le livre donné
        if (root == null) {
            root = new Node(book);
            return root;
        }

        // Sinon, insérez le livre dans le sous-arbre gauche ou droit récursivement
        if (book.getCategorie().compareTo(root.data.getCategorie()) < 0) {
            root.left = insertRecursive(root.left, book);
        } else if (book.getCategorie().compareTo(root.data.getCategorie()) > 0) {
            root.right = insertRecursive(root.right, book);
        }

        return root;
    }
    

    public List<Book> searchByCategory(String category) {
        List<Book> livresTrouves = new ArrayList<>();
        searchByCategoryRecursive(root, category, livresTrouves);
        return livresTrouves;
    }

    private void searchByCategoryRecursive(Node root, String category, List<Book> livresTrouves) {
        if (root == null) {
            return;
        }

        // Parcours récursif de l'arbre
        searchByCategoryRecursive(root.left, category, livresTrouves);
        
        // Si la catégorie correspond, ajoutez le livre à la liste
        if (root.data.getCategorie().equalsIgnoreCase(category)) {
            livresTrouves.add(root.data);
        }

        searchByCategoryRecursive(root.right, category, livresTrouves);
    }

}
