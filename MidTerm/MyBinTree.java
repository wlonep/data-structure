package MidTerm;

import java.util.ArrayList;

public class MyBinTree extends MyTree {
    MyBinTree() {
        super();
    }
    MyBinTree(Object e) {
        super(e);
    }

    public boolean isEmpty() {
        return root() == null;
    }

    public boolean isRoot(MyNode v) {
        return v == root();
    }

    public boolean isInternal(MyNode v) {
        return !isExternal(v);
    }

    public boolean isExternal(MyNode v) {
        MyBinNode node = (MyBinNode) v;
        return !hasLeft(node) && !hasRight(node);
    }

    public MyBinNode root() {
        return (MyBinNode) super.root();
    }

    public MyBinNode parent(MyBinNode v) {
        return (MyBinNode) v.parent();
    }

    public MyBinNode left(MyBinNode v) {
        return v.left();
    }

    public MyBinNode right(MyBinNode v) {
        return v.right();
    }

    public boolean hasLeft(MyBinNode v) {
        return v.left() != null;
    }

    public boolean hasRight(MyBinNode v) {
        return v.right() != null;
    }

    public MyBinNode addRoot(Object e) {
        if (!isEmpty()) return null;
        MyBinNode root = new MyBinNode(e);
        ArrayList<MyNode> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        root.setChildren(list);
        super.addRoot(root);
        return root;
    }

    public MyBinNode addNode(Object e) {
        MyBinNode node = new MyBinNode(e);
        ArrayList<MyNode> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        node.setChildren(list);
        return node;
    }

    public MyBinNode insertLeft(MyBinNode v, Object e) {
        MyBinNode child = (MyBinNode) e;
        child.setParent(v);
        v.setLeft(child);
        return child;
    }

    public MyBinNode insertRight(MyBinNode v, Object e) {
        MyBinNode child = (MyBinNode) e;
        child.setParent(v);
        v.setRight(child);
        return child;
    }

    public Object replace(MyBinNode v, Object e) {
        Object temp = v.element();
        v.setElement(e);
        return temp;
    }

    public MyBinNode remove(MyBinNode v) throws TwoChildException {
        MyBinNode parent = (MyBinNode) v.parent();
        MyBinNode child = null;

        // 자식 노드가 2개일 때
        if (hasLeft(v) && hasRight(v)) {
            throw new TwoChildException();
        }

        // 자식 노드가 왼쪽인지, 오른쪽인지
        if (hasLeft(v)) {
            child = v.left();
        } else {
            child = v.right();
        }

        // 자식 노드가 1개 있고, 부모 노드가 존재할 때
        if (child != null && parent != null) {
            if (parent.left() == v) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }

        // 자식 노드가 없고, 부모 노드가 존재할 때
        if (child == null && parent != null) {
            if (parent.left() == v) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }

        return v;
    }

    public void attach(MyBinNode v, MyBinNode t1, MyBinNode t2) throws NotExternalException {
        if (hasLeft(v) || hasRight(v)) {
            throw new NotExternalException();
        }
        v.setLeft(t1);
        v.setRight(t2);
        t1.setParent(v);
        t2.setParent(v);
    }
}


