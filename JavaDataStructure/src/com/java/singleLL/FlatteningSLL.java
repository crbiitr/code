package com.java.singleLL;

public class FlatteningSLL {

    /* Let us create the following linked list
            5 -> 10 -> 19 -> 28 -> null
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
     */


    public static void main(String[] args) {
        Node<Integer> head = new Node<>(5, new Node<>(10), new Node<>(7));
        head.getDown().setDown(new Node<>(8));
        head.getDown().getDown().setDown(new Node<>(30));

        head.getNext().setDown(new Node<>(20));

        head.getNext().setNext(new Node<>(19));
        head.getNext().getNext().setDown(new Node<>(22));
        head.getNext().getNext().getDown().setDown(new Node<>(50));

        head.getNext().getNext().setNext(new Node<>(28));
        head.getNext().getNext().getNext().setDown(new Node<>(35));
        head.getNext().getNext().getNext().getDown().setDown(new Node<>(40));
        head.getNext().getNext().getNext().getDown().getDown().setDown(new Node<>(45));

        printList(head);

        flattenTheLL(head);
        printList(head);

    }

    private static void printList(Node head) {
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            System.out.print(temp.getData() + " -> ");
            Node down = temp.getDown();
            while (down != null) {
                System.out.print(down.getData() + " -> ");
                down = down.getDown();
            }
            System.out.println("null\n| ");

            temp = temp.getNext();
        }
        System.out.println();
    }

    public static Node<Integer> flattenTheLL(Node curr) {
        if (curr == null || curr.getNext() == null) return curr;

        curr.setNext(flattenTheLL(curr.getNext()));
        curr = (merge(curr, curr.getNext()));

        return curr;
    }

    private static Node<Integer> merge(Node<Integer> a, Node<Integer> b) {
        if (a == null) return b;
        if (b == null) return a;

        Node<Integer> result = null;
        if (a.getData() < b.getData()) {
            result = a;
            result.setDown(merge(a.getDown(), b));
        } else {
            result = b;
            result.setDown(merge(a, b.getDown()));
        }

        result.setNext(null);
        return result;
    }

}


