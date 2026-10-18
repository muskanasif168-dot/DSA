import java.util.Random;

public class InsertionSort {

    public static void insertionSort(int[] A, int N) {
        A[0] = Integer.MIN_VALUE;

        for (int K = 2; K <= N; K++) {
            int TEMP = A[K];
            int PTR = K - 1;

            while (TEMP < A[PTR]) {
                A[PTR + 1] = A[PTR];
                PTR = PTR - 1;
            }

            A[PTR + 1] = TEMP;
        }
    }

    public static void main(String[] args) {
        int N = 1000;
        int[] A = new int[N + 1];

        Random random = new Random();
        for (int i = 1; i <= N; i++) {
            A[i] = random.nextInt(10000);
        }

        System.out.println("All unsorted elements (from index 1 to 1000):");
        for (int i = 1; i <= N; i++) {
            System.out.print(A[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n-------------------------------------------");

        long startTime = System.nanoTime();
        insertionSort(A, N);
        long endTime = System.nanoTime();

        long durationInNanoseconds = endTime - startTime;
        double durationInMilliseconds = durationInNanoseconds / 1_000_000.0;

        System.out.println("All sorted elements (from index 1 to 1000):");
        for (int i = 1; i <= N; i++) {
            System.out.print(A[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }

        System.out.println("\n-------------------------------------------");
        System.out.println("Execution Time (Nanoseconds): " + durationInNanoseconds + " ns");
        System.out.println("Execution Time (Milliseconds): " + durationInMilliseconds + " ms");
        System.out.println("-------------------------------------------");
    }
}