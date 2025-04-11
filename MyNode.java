/*Task 1-1*/
import java.util.ArrayList;

public class MyNode {
    private Object element;
    private MyNode parent;
    private ArrayList<MyNode> children;

    MyNode() {
        element = null;
        parent = null;
        children = new ArrayList<>();
    }
    MyNode(Object e) {
        element = e;
        parent = null;
        children = new ArrayList<>();
    }
    public Object element() {
        return element;
    }
    public MyNode parent() {
        return parent;
    }
    public ArrayList<MyNode> children() {
        return children;
    }
    public int degree() {
        int max = children.size();
        for (MyNode child : children) {
            max = Math.max(max, child.degree());
        }
        return max;
    }
    public void setParent(MyNode p) {
        parent = p;
    }

    public void setElement(Object e) {
        element = e;
    }
    public void setChildren(ArrayList<MyNode> c) {
        children = c;
    }
}
