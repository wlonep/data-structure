public class Task1_4 {
    public static void main(String[] args) {
        /*Task 1-4 1)*/
        MyTree tree1 = new MyTree();
        MyNode root = tree1.addRoot("Make Money Fast");

        MyNode motivation = tree1.addNode("\t1. Motivation");
        MyNode methods = tree1.addNode("\t2. Methods");
        MyNode references = tree1.addNode("\tReferences");
        tree1.addChild(root, motivation);
        tree1.addChild(root, methods);
        tree1.addChild(root, references);

        tree1.addChild(motivation, tree1.addNode("\t\t1.1 Greed"));
        tree1.addChild(motivation, tree1.addNode("\t\t1.2 Avidity"));
        tree1.addChild(methods, tree1.addNode("\t\t2.1 Stock Fraud"));
        tree1.addChild(methods, tree1.addNode("\t\t2.2 Ponzi Scheme"));
        tree1.addChild(methods, tree1.addNode("\t\t2.3 Bank Robbery"));

        System.out.println("1) Preorder Traversal");
        preOrder(root);

        /*Task 1-4 2)*/
        MyTree tree2 = new MyTree();
        MyNode cs16 = tree2.addRoot("cs16/");

        MyNode homeworks = tree2.addNode("homeworks/");
        MyNode programs = tree2.addNode("programs/");
        MyNode todo = tree2.addNode("todo.txt (1K)");
        tree2.addChild(cs16, homeworks);
        tree2.addChild(cs16, programs);
        tree2.addChild(cs16, todo);

        tree2.addChild(homeworks, tree2.addNode("h1c.doc (3K)"));
        tree2.addChild(homeworks, tree2.addNode("h1nc.doc (2K)"));
        tree2.addChild(programs, tree2.addNode("DDR.java (10K)"));
        tree2.addChild(programs, tree2.addNode("Stocks.java (25K)"));
        tree2.addChild(programs, tree2.addNode("Robot.java (20K)"));

        System.out.println("\n2) Postorder Traversal");
        postOrder(cs16);

    }

    public static void preOrder(MyNode node) {
        System.out.println(node.element());
        for (MyNode child : node.children()) {
            preOrder(child);
        }
    }

    public static int postOrder(MyNode node) {
        int fileSize = 0;

        if (node.children().isEmpty()) {
            return extractSizeKB(node.element().toString());
        }
        for (MyNode child : node.children()) {
            fileSize += postOrder(child);
        }
        System.out.println(node.element() + " = " + fileSize + "KB");

        return fileSize;
    }

    public static int extractSizeKB(String text) {
        String number = text.split("\\(")[1].replace("K)", "");
        return Integer.parseInt(number);
    }
}
