package Algorithm;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void pushRight(int newData) {
        if (size == 0) {
            pushLeft(newData);
        } else {
            Node newNode = new Node(newData);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public void pushLeft(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    public void pushByIdx(int idx, int newData) {
        if (idx == 0) {
            pushLeft(newData);
        } else {
            int i = 0;
            Node findNode = head;
            Node before = null;
            while (i < idx) {
                before = findNode;
                findNode = findNode.next;
                i++;
            }

            Node newNode = new Node(newData);
            before.next = newNode;
            newNode.next = findNode;
            size++;

            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    public void printLinkedList() {
        Node curNode = head;

        while (curNode != null) {
            System.out.print(curNode.data + " ");
            curNode = curNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.pushByIdx(0, 1);
        linkedList.pushByIdx(0, 2);
        linkedList.pushByIdx(1, 6);
        linkedList.pushByIdx(3, 9);
        linkedList.printLinkedList();
    }
}
