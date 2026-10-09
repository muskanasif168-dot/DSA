import java.util.Scanner;

public class StackDemo {
    private static final int MAX_CAPACITY = 10;
    private static int[] stack = new int[MAX_CAPACITY];
    private static int top = -1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- STACK MENU ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = getValidInt();
            switch (choice) {
                case 1:
                    if (top == MAX_CAPACITY - 1) {
                        System.out.println("Error: Stack Overflow! Cannot add plate.");
                    } else {
                        System.out.print("Enter plate value to Push: ");
                        int val = getValidInt();
                        stack[++top] = val;
                        System.out.println("Pushed " + val + " onto top of stack.");
                    }
                    break;
                case 2:
                    if (top == -1) {
                        System.out.println("Error: Stack Underflow! No plates to remove.");
                    } else {
                        int popped = stack[top--];
                        System.out.println("Popped " + popped + " from top of stack.");
                    }
                    break;
                case 3:
                    if (top == -1) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack Contents (Top to Bottom):");
                        for (int i = top; i >= 0; i--) {
                            System.out.println("| " + stack[i] + " |" + (i == top ? " <-- TOP" : ""));
                        }
                        System.out.println("------");
                    }
                    break;
                case 4:
                    System.out.println("Current Stack Size: " + (top + 1));
                    break;
                case 5:
                    System.out.println("isEmpty: " + (top == -1));
                    break;
                case 6:
                    System.out.println("isFull: " + (top == MAX_CAPACITY - 1));
                    break;
                case 7:
                    System.out.println("Exiting Stack Program.");
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
