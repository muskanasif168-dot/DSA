import java.util.Random;

public class BubbleSort {

    // Image mein diye gaye Bubble Sort algorithm ke mutabiq function
    public static void bubbleSort(int[] DATA, int N) {
        // Step 1: Repeat step 2 and 3 for K = 1 to N - 1
        for (int K = 1; K <= N - 1; K++) {
            
            // Step 2: Set PTR = 1
            int PTR = 1;

            // Step 3: Repeat while PTR <= N - K
            while (PTR <= N - K) {
                
                // If DATA[PTR] > DATA[PTR + 1] then Interchange DATA[PTR] and DATA[PTR + 1]
                if (DATA[PTR] > DATA[PTR + 1]) {
                    int TEMP = DATA[PTR];
                    DATA[PTR] = DATA[PTR + 1];
                    DATA[PTR + 1] = TEMP;
                }

                // Set PTR = PTR + 1
                PTR = PTR + 1;
            }
        }
        // Step 4: Exit
    }

    public static void main(String[] args) {
        int N = 1000; // 1000 elements
        
        // Size (N + 1) rakha hai taake 1-based indexing follow ho sake
        int[] DATA = new int[N + 1];

        // Random values se array fill karna
        Random random = new Random();
        for (int i = 1; i <= N; i++) {
            DATA[i] = random.nextInt(10000);
        }

        // Unsorted elements print karna
        System.out.println("All unsorted elements (from index 1 to 1000):");
        for (int i = 1; i <= N; i++) {
            System.out.print(DATA[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n-------------------------------------------");

        // Execution time start
        long startTime = System.nanoTime();

        // Bubble sort function call
        bubbleSort(DATA, N);

        // Execution time end
        long endTime = System.nanoTime();

        // Execution time calculate karna
        long durationInNanoseconds = endTime - startTime;
        double durationInMilliseconds = durationInNanoseconds / 1_000_000.0;

        // Sorted elements print karna
        System.out.println("All sorted elements (from index 1 to 1000):");
        for (int i = 1; i <= N; i++) {
            System.out.print(DATA[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }

        // Execution time print karna
        System.out.println("\n-------------------------------------------");
        System.out.println("Time Complexity: O(N^2)");
        System.out.println("Execution Time (Nanoseconds): " + durationInNanoseconds + " ns");
        System.out.println("Execution Time (Milliseconds): " + durationInMilliseconds + " ms");
        System.out.println("-------------------------------------------");
    }
}
