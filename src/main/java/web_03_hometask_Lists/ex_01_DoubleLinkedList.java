package web_03_hometask_Lists;

public class ex_01_DoubleLinkedList {

    private Node head;
    private Node tail;

    private class Node {
        private int value;
        private Node next;
        private Node previous;
    }

    public void reverse() {
        Node i = head;
        while (i != null) {
            Node next = i.next;
            Node previous = i.previous;
            i.next = previous;
            i.previous = next;
            if (previous == null) {
                tail = i;
            }
            if (next == null) {
                head = i;
            }
            i = next;
        }
    }
}
