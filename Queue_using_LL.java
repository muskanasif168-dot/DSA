import java.util.Scanner;

public class Queue_using_LL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node front = null;
    static Node rear = null;

    static int size = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println("       QUEUE USING LL");
            System.out.println("==============================");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. Is Empty");
            System.out.println("6. Is Full");
            System.out.println("0. Exit");
            System.out.println("==============================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    enqueue();
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    size();
                    break;

                case 5:
                    isEmpty();
                    break;

                case 6:
                    isFull();
                    break;

                case 0:
                    System.out.println("Program exited.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    static void enqueue() {

        System.out.print("Enter value: ");
        int value = sc.nextInt();

        Node newNode = new Node(value);

        if (rear == null) {

            front = newNode;
            rear = newNode;

        } else {

            rear.next = newNode;
            rear = newNode;
        }

        size++;

        System.out.println(value + " added to queue.");
    }

    static void dequeue() {

        if (front == null) {

            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        int value = front.data;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;

        System.out.println(value + " removed from queue.");
    }

    static void display() {

        if (front == null) {

            System.out.println("Queue is empty.");
            return;
        }

        Node temp = front;

        System.out.println("Queue elements:");

        while (temp != null) {

            System.out.println(temp.data);

            temp = temp.next;
        }
    }

    static void size() {

        System.out.println("Size of queue = " + size);
    }

    static void isEmpty() {

        if (front == null) {
            System.out.println("Queue is Empty.");
        } else {
            System.out.println("Queue is Not Empty.");
        }
    }

    static void isFull() {

        System.out.println(
            "Queue is never Full until memory is available."
        );
    }
}