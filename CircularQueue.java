import java.util.Scanner;

public class CircularQueue {

    static int MAX_SIZE = 5;
    static int[] queue = new int[MAX_SIZE];

    static int front = -1;
    static int rear = -1;
    static int size = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== CIRCULAR QUEUE =====");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. Is Empty");
            System.out.println("6. Is Full");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    enqueue(value);
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    System.out.println("Queue Size = " + size);
                    break;

                case 5:
                    if (isEmpty()) {
                        System.out.println("Queue is Empty.");
                    } else {
                        System.out.println("Queue is Not Empty.");
                    }
                    break;

                case 6:
                    if (isFull()) {
                        System.out.println("Queue is Full.");
                    } else {
                        System.out.println("Queue is Not Full.");
                    }
                    break;

                case 0:
                    System.out.println("Program Exited.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);

        sc.close();
    }

    static void enqueue(int value) {

        if (isFull()) {
            System.out.println("Queue Overflow! Queue is Full.");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % MAX_SIZE;
        }

        queue[rear] = value;
        size++;

        System.out.println(value + " inserted into queue.");
    }

    static void dequeue() {

        if (isEmpty()) {
            System.out.println("Queue Underflow! Queue is Empty.");
            return;
        }

        int value = queue[front];

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % MAX_SIZE;
        }

        size--;

        System.out.println(value + " removed from queue.");
    }

    static void display() {

        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return;
        }

        System.out.println("Queue Elements:");

        int i = front;

        for (int count = 0; count < size; count++) {

            System.out.print(queue[i] + " ");

            i = (i + 1) % MAX_SIZE;
        }

        System.out.println();
    }

    static int getSize() {
        return size;
    }

    static boolean isEmpty() {
        return size == 0;
    }
    static boolean isFull() {
        return size == MAX_SIZE;
    }
}