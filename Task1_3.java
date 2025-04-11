public class Task1_3 {
    public static void main(String[] args) {
        MyTree tree = new MyTree();
        /*Task 1-3*/
        System.out.println("[Level 0]");
        MyNode root = tree.addRoot("Computers'R Us");
        System.out.println(root.element());

        System.out.println("[Level 1]");
        MyNode sales = tree.addNode("Sales");
        MyNode manufacturing = tree.addNode("manufacturing");
        MyNode rnd = tree.addNode("R&D");
        tree.addChild(root, sales);
        tree.addChild(root, manufacturing);
        tree.addChild(root, rnd);
        System.out.println(sales.element() + ", " + manufacturing.element() + ", " + rnd.element());

        System.out.println("[Level 2]");
        MyNode us = tree.addNode("US");
        MyNode international = tree.addNode("International");
        tree.addChild(sales, us);
        tree.addChild(sales, international);
        MyNode laptops = tree.addNode("Laptops");
        MyNode desktops = tree.addNode("Desktops");
        tree.addChild(manufacturing, laptops);
        tree.addChild(manufacturing, desktops);
        System.out.println(us.element() + ", " + international.element() + ", " + laptops.element() + ", " + desktops.element());

        System.out.println("[Level 3]");
        MyNode europe = tree.addNode("Europe");
        MyNode asia = tree.addNode("Asia");
        MyNode canada = tree.addNode("Canada");
        tree.addChild(international, europe);
        tree.addChild(international, asia);
        tree.addChild(international, canada);
        System.out.println(europe.element() + ", " + asia.element() + ", " + canada.element());

        System.out.println("* Tree size = Total " + tree.size() + " nodes");
    }
}
