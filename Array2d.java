import java.util.Scanner;

public class Array2d{

    static Scanner sc = new Scanner(System.in);

    static int rows = 5;
    static int cols = 5;

    static int[][] arr = new int[rows][cols];

    static int size = 0;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== 2D ARRAY MENU =====");
            System.out.println("1. Add Value");
            System.out.println("2. Insert at Position");
            System.out.println("3. Fill Array");
            System.out.println("4. Delete Last Element");
            System.out.println("5. Delete by Position");
            System.out.println("6. Display Array");
            System.out.println("7. Search Value");
            System.out.println("8. Get Value by Position");
            System.out.println("9. Update Value");
            System.out.println("10. Size");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addValue();
                    break;

                case 2:
                    insertAtPosition();
                    break;

                case 3:
                    fillArray();
                    break;

                case 4:
                    deleteLast();
                    break;

                case 5:
                    deleteByPosition();
                    break;

                case 6:
                    display();
                    break;

                case 7:
                    search();
                    break;

                case 8:
                    getValue();
                    break;

                case 9:
                    updateValue();
                    break;

                case 10:
                    System.out.println("Size = " + size);
                    break;

                case 0:
                    System.out.println("Program exited.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }

    static void addValue() {

        if (size == rows * cols) {
            System.out.println("Array is full!");
            return;
        }

        System.out.print("Enter value: ");
        int value = sc.nextInt();

        int row = size / cols;
        int col = size % cols;

        arr[row][col] = value;
        size++;

        System.out.println("Value added successfully.");
    }

    static void insertAtPosition() {

        if (size == rows * cols) {
            System.out.println("Array is full!");
            return;
        }

        System.out.print("Enter position (0 to " + size + "): ");
        int position = sc.nextInt();

        if (position < 0 || position > size) {
            System.out.println("Invalid position!");
            return;
        }

        System.out.print("Enter value: ");
        int value = sc.nextInt();

        for (int i = size; i > position; i--) {

            int currentRow = i / cols;
            int currentCol = i % cols;

            int previousRow = (i - 1) / cols;
            int previousCol = (i - 1) % cols;

            arr[currentRow][currentCol] = arr[previousRow][previousCol];
        }

        int row = position / cols;
        int col = position % cols;

        arr[row][col] = value;
        size++;

        System.out.println("Value inserted successfully.");
    }

    static void fillArray() {

        System.out.print("Enter number of elements to fill: ");
        int n = sc.nextInt();

        if (n < 0 || n > rows * cols) {
            System.out.println("Invalid number of elements!");
            return;
        }

        size = 0;

        System.out.println("Enter " + n + " values:");

        for (int i = 0; i < n; i++) {

            int row = i / cols;
            int col = i % cols;

            arr[row][col] = sc.nextInt();

            size++;
        }

        System.out.println("Array filled successfully.");
    }

    static void deleteLast() {

        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }

        int row = (size - 1) / cols;
        int col = (size - 1) % cols;

        arr[row][col] = 0;

        size--;

        System.out.println("Last element deleted.");
    }

    static void deleteByPosition() {

        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }

        System.out.print("Enter position (0 to " + (size - 1) + "): ");
        int position = sc.nextInt();

        if (position < 0 || position >= size) {
            System.out.println("Invalid position!");
            return;
        }

        for (int i = position; i < size - 1; i++) {

            int currentRow = i / cols;
            int currentCol = i % cols;

            int nextRow = (i + 1) / cols;
            int nextCol = (i + 1) % cols;

            arr[currentRow][currentCol] = arr[nextRow][nextCol];
        }

        int lastRow = (size - 1) / cols;
        int lastCol = (size - 1) % cols;

        arr[lastRow][lastCol] = 0;

        size--;

        System.out.println("Element deleted successfully.");
    }

    static void display() {

        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }

        System.out.println("\n2D Array:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                int position = i * cols + j;

                if (position < size) {
                    System.out.print(arr[i][j] + "\t");
                } else {
                    System.out.print("-\t");
                }
            }

            System.out.println();
        }
    }

    static void search() {

        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }

        System.out.print("Enter value to search: ");
        int value = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < size; i++) {

            int row = i / cols;
            int col = i % cols;

            if (arr[row][col] == value) {

                System.out.println(
                        "Value found at position: " + i +
                        " (Row: " + row +
                        ", Column: " + col + ")"
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println("Value not found.");
        }
    }

    static void getValue() {

        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }

        System.out.print("Enter position (0 to " + (size - 1) + "): ");
        int position = sc.nextInt();

        if (position < 0 || position >= size) {
            System.out.println("Invalid position!");
            return;
        }

        int row = position / cols;
        int col = position % cols;

        System.out.println("Value = " + arr[row][col]);
    }

    static void updateValue() {

        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }

        System.out.print("Enter position (0 to " + (size - 1) + "): ");
        int position = sc.nextInt();

        if (position < 0 || position >= size) {
            System.out.println("Invalid position!");
            return;
        }

        System.out.print("Enter new value: ");
        int value = sc.nextInt();

        int row = position / cols;
        int col = position % cols;

        arr[row][col] = value;

        System.out.println("Value updated successfully.");
    }
}