public class Main {
    public static void Main(String[] args) {
        MyTree tree = new MyTree();
        MyNode root = tree.addRoot("Computers'R Us");
        MyNode sales = tree.addChild(root, "Sales");
        MyNode manufacturing = tree.addChild(root, "manufacturing");
        tree.addChild(root, "R&D");
        tree.addChild(sales, "US");
        MyNode international = tree.addChild(sales, "International");
        tree.addChild(international, "Europe");
        tree.addChild(international, "Asia");
        tree.addChild(international, "Canada");
        tree.addChild(manufacturing, "Laptops");
        tree.addChild(manufacturing, "Desktops");
    }
}
