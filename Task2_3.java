public class Task2_3 {
    public static void main(String[] args) throws NotExternalException {
        MyBinTree tree = new MyBinTree();
        MyBinNode root = tree.addRoot("+");

        MyBinNode left = tree.addNode("*");
        MyBinNode right = tree.addNode("*");

        MyBinNode left_left = tree.addNode("2");
        MyBinNode left_right = tree.addNode("-");
        MyBinNode left_right_left = tree.addNode("3");
        MyBinNode left_right_right = tree.addNode("1");

        MyBinNode right_left = tree.addNode("3");
        MyBinNode right_right = tree.addNode("2");

        tree.attach(root, left, right);
        tree.attach(left, left_left, left_right);
        tree.attach(left_right, left_right_left, left_right_right);
        tree.attach(right, right_left, right_right);

        inOrder(root);
        int post = postOrder(root);
        System.out.println("\n= " + post);
    }

    public static void inOrder(MyBinNode node) {
        if (node == null) return;

        if (node.left() != null || node.right() != null)
            System.out.print("(");
        inOrder(node.left());
        System.out.print(node.element());
        inOrder(node.right());
        if (node.left() != null || node.right() != null)
            System.out.print(")");
    }

    public static int postOrder(MyBinNode node) {
        if (node.left() == null && node.right() == null) {
            return Integer.parseInt(node.element().toString());
        }
        int left = postOrder(node.left());
        int right = postOrder(node.right());
        return switch (node.element().toString()) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "/" -> left / right;
            default -> 0;
        };
    }
}
