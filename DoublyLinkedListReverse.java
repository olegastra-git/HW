public class DoublyLinkedListReverse {
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) {
            data = d;
            prev = null;
            next = null;
        }
    }

    static class DoublyLinkedList {
        Node head;

        void reverse() {
            Node temp = null;
            Node current = head;
            while (current != null) {
                temp = current.prev;
                current.prev = current.next;
                current.next = temp;
                current = current.prev;
            }
            if (temp != null) {
                head = temp.prev;
            }
        }

        void push(int new_data) {
            Node new_node = new Node(new_data);
            new_node.next = head;
            new_node.prev = null;
            if (head != null) {
                head.prev = new_node;
            }
            head = new_node;
        }

        void printList() {
            Node node = head;
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.push(1);
        dll.push(2);
        dll.push(3);
        dll.push(4);
        dll.push(5);
        System.out.println("Исходный список:");
        dll.printList();
        dll.reverse();
        System.out.println("\nПосле разворота:");
        dll.printList();
    }
}