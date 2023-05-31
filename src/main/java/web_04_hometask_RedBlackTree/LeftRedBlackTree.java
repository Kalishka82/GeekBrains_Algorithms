package web_04_hometask_RedBlackTree;

public class LeftRedBlackTree {
    private Node root;

    private class Node {
        private int value;
        private Node left;
        private Node right;
        private Color color;
    }

    private enum Color {
        RED, BLACK
    }

    public boolean add(int value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = balance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }

    private Node leftSwap(Node Y) {
        Node X = Y.left;
        Node betweenXY = X.right;
        X.right = Y;
        Y.left = betweenXY;
        X.color = Y.color;
        Y.color = Color.RED;
        return X;
    }

    private Node rightSwap(Node X) {
        Node Y = X.right;
        Node betweenXY = Y.left;
        Y.left = X;
        X.right = betweenXY;
        Y.color = X.color;
        X.color = Color.RED;
        return Y;
    }

    private void colorSwap(Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node balance(Node node) {
        Node result = node;
        boolean neadBalance;
        do {
            neadBalance = false;
            if (result.right != null &&
            result.right.color == Color.RED &&
                    (result.left == null ||
                            result.left.color == Color.BLACK)) {
                neadBalance = true;
                result = rightSwap(result);
            }
            if (result.left != null &&
                    result.left.color == Color.RED &&
                    result.left.left != null &&
                    result.left.right.color == Color.RED) {
                neadBalance = true;
                result = leftSwap(result);
            }
            if (result.left != null &&
                    result.left.color == Color.RED &&
                    result.right != null &&
                    result.right.color == Color.RED) {
                neadBalance = true;
                colorSwap(result);
            }
        }
        while (neadBalance);
        return result;
    }

    private boolean addNode(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.left != null) {
                    boolean result = addNode(node.left, value);
                    node.left = balance(node.left);
                    return result;
                } else {
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                    return true;
                }
            } else {
                if (node.right != null) {
                    boolean result = addNode(node.right, value);
                    node.right = balance(node.right);
                    return result;
                } else {
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                    return true;
                }
            }
        }
    }
}
