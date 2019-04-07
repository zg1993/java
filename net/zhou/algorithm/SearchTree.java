import static net.zhou.util.Print.*;
import static net.zhou.util.Range.*;
import static net.zhou.util.RandomArray.*;

public class SearchTree {
    private static class Node {
	int element;
	Node left;
	Node right;
	Node(int X) { left = null; right = null; element = X; }
    }

    //    private Node head = null;
    private Node head; // initialize null
    
    void inOrderTraversal(Node node) {
	if (null == node)
	    return;
	inOrderTraversal(node.left);
	print(node.element);
	inOrderTraversal(node.right);
    }
    
    private Node insert(Node node, int X) {
	if (null == node)
	    return new Node(X);
	if (X < node.element)
	    node.left = insert(node.left, X);
	else
	    node.right = insert(node.right, X);
	return node;
    }
    
    public void add(int X) {
	head = insert(head, X);
    }

    public boolean findElement(int X) {
	return find(head, X);
    }
    
    private boolean find(Node node, int X) {
	if (null == node)
	    return false;
	if (X == node.element)
	    return true;
	else if (X < node.element)
	    return find(node.left, X);
	else
	    return find(node.right, X);
    }
    
    /*    public void add(int X) {
	Node node = head;
	while (node != null) {
	    if (X < node.element)
		node = node.left;
	    else
		node = node.right;
	}
	node = new Node(X);
	
	}*/
    
    /*    public boolean find(int X) {
	Node node = head;
	while (node != null) {
	    if (X == node.element)
		return true;
	    else if (X < node.element)
		node = node.left;
	    else
		node = node.right;
	}
	return false;
	}*/
    /*    public void add(int X) {
	if (head == null) {
	    head = new Node(X);
	}
	if (X < tree.element)
	    tree.left = add(X, tree.left);
	else
	    tree.right = add(X, tree.right);
	return tree;
	}*/

    /*    public boolean find(int X) {
	if (tree == null) {
	    print("not find");
	    return false;
	}
	if (X == tree.element)
	    return true;
	else if (X < tree.element)
	    return find(X, tree.left);
	else
	    return find(X, tree.right);
	    }*/

    

    public static void main(String[] args) {
	//	if (args.length != 1)
	    //	    print("input");
	SearchTree st = new SearchTree();
	int[] array = shuttleArray(10, 100);
	print(array);
	for (int i = 0; i < array.length; i++) {
	    st.add(array[i]);
	}
	print(st.head);
	print(st.findElement(array[4]));
	print(st.findElement(19));
	st.inOrderTraversal(st.head);
	
    }
    
    
}
