
// Classe pour représenter un nœud de l'arbre binaire
class TreeNode {
    String category;
    Book book;
    TreeNode left;
    TreeNode right;

    public TreeNode(String category, Book book) {
        this.category = category;
        this.book = book;
        this.left = null;
        this.right = null;
    }
}
