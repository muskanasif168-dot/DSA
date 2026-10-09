import java.util.Scanner;

public class QueueDemo {
    private static final int MAX_CAPACITY = 10;
    private static int[] queue = new int[MAX_CAPACITY];
    private static int front = 0;
    private static int rear = -1;
    private static int size = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- QUEUE MENU ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = getValidInt();
            switch (choice) {
                case 1:
                    if (size == MAX_CAPACITY) {
                        System.out.println("Error: Queue Overflow! Counter queue is full.");
                    } else {
                        System.out.print("Enter customer token number: ");
                        int token = getValidInt();
                        rear = (rear + 1) % MAX_CAPACITY;
                        queue[rear] = token;
                        size++;
                        System.out.println("Token " + token + " enqueued at back of line.");
                    }
                    break;
                case 2:
                    if (size == 0) {
                        System.out.println("Error: Queue Underflow! No customers in queue.");
                    } else {
                        int token = queue[front];
                        front = (front + 1) % MAX_CAPACITY;
                        size--;
                        System.out.println("Served customer with Token " + token + " (Dequeued).");
                    }
                    break;
                case 3:
                    if (size == 0) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.print("Queue (Front to Rear): [ ");
                        for (int i = 0; i < size; i++) {
                            int idx = (front + i) % MAX_CAPACITY;
                            System.out.print(queue[idx] + (i < size - 1 ? " <- " : " "));
                        }
                        System.out.println("]");
                    }
                    break;
                case 4:
                    System.out.println("Current Queue Size: " + size);
                    break;
                case 5:
                    System.out.println("isEmpty: " + (size == 0));
                    break;
                case 6:
                    System.out.println("isFull: " + (size == MAX_CAPACITY));
                    break;
                case 7:
                    System.out.println("Exiting Queue Program.");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static int getValidInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Enter an integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
