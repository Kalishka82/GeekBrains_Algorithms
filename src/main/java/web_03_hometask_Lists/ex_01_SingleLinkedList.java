package web_03_hometask_Lists;

public class ex_01_SingleLinkedList {

    private Node head;

    private class Node {
        private int value;
        private Node next;
    }

    public void reverce() {
        if (head != null && head.next != null) {
            reverse(head.next, head);
        }
    }

    private void reverse(Node i, Node prev_i) {
        if (i.next == null) {
            head = i;
        } else {
            reverse(i.next, i);
        }
        i.next = prev_i;
        prev_i.next = null;
    }
}
