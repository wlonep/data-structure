/*Task 1-2*/
import java.util.ArrayList;

public class MyTree {
    private MyNode root;

    // implement constructors
    MyTree() {
        root = null;
    }

    MyTree(Object e) {
        root = new MyNode(e);
        root.setChildren(new ArrayList<>());
    }

    public int size() {
        return size(root);
    }

    private int size(MyNode v) {
        if (v == null) return 0;
        int count = 1;
        for (MyNode child : children(v)) {
            count += size(child);
        }
        return count;
    }

    public MyNode root() {
        return root;
    }

    public ArrayList<MyNode> children(MyNode v) {
        return v.children();
    }

    public boolean isExternal(MyNode v) {
        return v.children().isEmpty();
    }

    public MyNode addRoot(Object e) {
        if (root != null) return null;
        root = new MyNode(e);
        root.setChildren(new ArrayList<>());
        return root;
    }

    public MyNode addNode(Object e) {
        MyNode temp = new MyNode(e);
        temp.setChildren(new ArrayList<>());
        return temp;
    }

    public MyNode addChild(MyNode v, Object e) {
        MyNode child = (MyNode) e;
        child.setParent(v);
        v.children().add(child);
        return child;
    }

    public MyNode addChild(MyNode v, int i, Object e) {
        MyNode child = (MyNode) e;
        child.setParent(v);
        v.children().add(i, child);
        return child;
    }

    public MyNode setChild(MyNode v, int i, Object e) {
        MyNode child = v.children().get(i);
        child.setElement(e);
        return child;
    }

    public MyNode removeChild(MyNode v, int i) {
        return v.children().remove(i);
    }
}