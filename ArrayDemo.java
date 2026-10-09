import java.util.Scanner;

public class ArrayDemo {
    private static final int MAX_CAPACITY = 10;
    private static int[] shelf = new int[MAX_CAPACITY];
    private static int count = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- ARRAY MENU ---");
            System.out.println("1. Add value");
            System.out.println("2. Insert at index");
            System.out.println("3. Fill array");
            System.out.println("4. Delete last element");
            System.out.println("5. Delete by index");
            System.out.println("6. Display");
            System.out.println("7. Search value");
            System.out.println("8. Get value at index");
            System.out.println("9. Replace/Update value at index");
            System.out.println("10. Size");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            int choice = getValidInt();
            switch (choice) {
                case 1:
                    if (count >= MAX_CAPACITY) {
                        System.out.println("Error: Array Overflow! Shelf is full.");
                    } else {
                        System.out.print("Enter Book ID to add: ");
                        shelf[count++] = getValidInt();
                        System.out.println("Book ID added successfully.");
                    }
                    break;
                case 2:
                    if (count >= MAX_CAPACITY) {
                        System.out.println("Error: Array Overflow! Shelf is full.");
                        break;
                    }
                    System.out.print("Enter index (0 to " + count + "): ");
                    int idx = getValidInt();
                    if (idx < 0 || idx > count) {
                        System.out.println("Error: Invalid Index!");
                        break;
                    }
                    System.out.print("Enter Book ID to insert: ");
                    int val = getValidInt();
                    for (int i = count; i > idx; i--) {
                        shelf[i] = shelf[i - 1];
                    }
                    shelf[idx] = val;
                    count++;
                    System.out.println("Book ID inserted successfully at index " + idx + ".");
                    break;
                case 3:
                    if (count >= MAX_CAPACITY) {
                        System.out.println("Shelf is already full!");
                        break;
                    }
                    System.out.println("Entering fill mode. Enter -1 to stop early.");
                    while (count < MAX_CAPACITY) {
                        System.out.print("Enter Book ID for slot " + count + " (-1 to stop): ");
                        int input = getValidInt();
                        if (input == -1) break;
                        shelf[count++] = input;
                    }
                    System.out.println("Fill operation completed. Current elements: " + count);
                    break;
                case 4:
                    if (count == 0) {
                        System.out.println("Error: Array Underflow! Shelf is empty.");
                    } else {
                        int removed = shelf[--count];
                        System.out.println("Deleted last element (Book ID: " + removed + ").");
                    }
                    break;
                case 5:
                    if (count == 0) {
                        System.out.println("Error: Array Underflow! Shelf is empty.");
                        break;
                    }
                    System.out.print("Enter index to delete (0 to " + (count - 1) + "): ");
                    int delIdx = getValidInt();
                    if (delIdx < 0 || delIdx >= count) {
                        System.out.println("Error: Invalid Index!");
                        break;
                    }
                    int removedVal = shelf[delIdx];
                    for (int i = delIdx; i < count - 1; i++) {
                        shelf[i] = shelf[i + 1];
                    }
                    count--;
                    System.out.println("Deleted element " + removedVal + " from index " + delIdx + ".");
                    break;
                case 6:
                    if (count == 0) {
                        System.out.println("Shelf is empty.");
                    } else {
                        System.out.print("Shelf Books: [ ");
                        for (int i = 0; i < count; i++) {
                            System.out.print(shelf[i] + (i < count - 1 ? ", " : " "));
                        }
                        System.out.println("]");
                    }
                    break;
                case 7:
                    System.out.print("Enter Book ID to search: ");
                    int target = getValidInt();
                    int foundIdx = -1;
                    for (int i = 0; i < count; i++) {
                        if (shelf[i] == target) {
                            foundIdx = i;
                            break;
                        }
                    }
                    if (foundIdx != -1) {
                        System.out.println("Book ID " + target + " found at index " + foundIdx + ".");
                    } else {
                        System.out.println("Book ID " + target + " does not exist in the shelf.");
                    }
                    break;
                case 8:
                    System.out.print("Enter index (0 to " + (count - 1) + "): ");
                    int getIdx = getValidInt();
                    if (getIdx < 0 || getIdx >= count) {
                        System.out.println("Error: Invalid Index!");
                    } else {
                        System.out.println("Value at index " + getIdx + " is: " + shelf[getIdx]);
                    }
                    break;
                case 9:
                    System.out.print("Enter index to update (0 to " + (count - 1) + "): ");
                    int upIdx = getValidInt();
                    if (upIdx < 0 || upIdx >= count) {
                        System.out.println("Error: Invalid Index!");
                    } else {
                        System.out.print("Enter new Book ID: ");
                        shelf[upIdx] = getValidInt();
                        System.out.println("Value updated successfully at index " + upIdx + ".");
                    }
                    break;
                case 10:
                    System.out.println("Current size (number of books): " + count + " / " + MAX_CAPACITY);
                    break;
                case 11:
                    System.out.println("Exiting Array Program.");
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