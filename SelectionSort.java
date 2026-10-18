import java.util.Random;

public class SelectionSort {

    public static void selectionSort(int[] A, int N) {
        int U = 1;
        while (U < N) {
            int Temp = A[U];
            int LOC = U;
            int I = U + 1;

            while (I <= N) {
                if (Temp > A[I]) {
                    Temp = A[I];
                    LOC = I;
                }
                I = I + 1;
            }

            int T = A[LOC];
            A[LOC] = A[U];
            A[U] = T;

            U = U + 1;
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
        selectionSort(A, N);
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