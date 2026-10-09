import java.util.Scanner;

public class Stack_using_LL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node top = null;

    static int size = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println("       STACK USING LL");
            System.out.println("==============================");
            System.out.println("1. Push");
            System.out.println("2. Pop");
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
                    push();
                    break;

                case 2:
                    pop();
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

    static void push() {

        System.out.print("Enter value: ");
        int value = sc.nextInt();

        Node newNode = new Node(value);

        newNode.next = top;
        top = newNode;

        size++;

        System.out.println(value + " pushed into stack.");
    }

    static void pop() {

        if (top == null) {
            System.out.println("Stack is empty. Cannot pop.");
            return;
        }

        int value = top.data;

        top = top.next;

        size--;

        System.out.println(value + " popped from stack.");
    }

    static void display() {

        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }

        Node temp = top;

        System.out.println("Stack elements:");

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    static void size() {

        System.out.println("Size of stack = " + size);
    }

    static void isEmpty() {

        if (top == null) {
            System.out.println("Stack is Empty.");
        } else {
            System.out.println("Stack is Not Empty.");
        }
    }

    static void isFull() {
        System.out.println("Stack is never Full (until memory is available).");
    }
}