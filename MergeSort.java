import java.util.Random;

public class MergeSort{

    public static void mergeSort(int[] AB, int N) {
        if (N <= 1) {
            return;
        }

        int Mid = (N + 1) / 2;

        int R = Mid;
        int S = N - Mid;

        int[] A = new int[R + 1];
        int[] B = new int[S + 1];

        for (int I = 1; I <= Mid; I++) {
            A[I] = AB[I];
        }

        for (int I = Mid + 1; I <= N; I++) {
            B[I - Mid] = AB[I];
        }

        mergeSort(A, R);
        mergeSort(B, S);

        int L1 = 1;
        int L2 = 1;
        int L = 1;

        while (L1 <= R && L2 <= S) {
            if (A[L1] < B[L2]) {
                AB[L] = A[L1];
                L = L + 1;
                L1 = L1 + 1;
            } else {
                AB[L] = B[L2];
                L = L + 1;
                L2 = L2 + 1;
            }
        }

        if (L1 > R) {
            for (int I = 0; I <= S - L2; I++) {
                AB[L + I] = B[L2 + I];
            }
        } else {
            for (int I = 0; I <= R - L1; I++) {
                AB[L + I] = A[L1 + I];
            }
        }
    }

    public static void main(String[] args) {
        int N = 1000;
        int[] AB = new int[N + 1];

        Random random = new Random();
        for (int i = 1; i <= N; i++) {
            AB[i] = random.nextInt(10000);
        }

        System.out.println("All unsorted elements (from index 1 to 1000):");
        for (int i = 1; i <= N; i++) {
            System.out.print(AB[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n-------------------------------------------");

        long startTime = System.nanoTime();
        mergeSort(AB, N);
        long endTime = System.nanoTime();

        long durationInNanoseconds = endTime - startTime;
        double durationInMilliseconds = durationInNanoseconds / 1_000_000.0;

        System.out.println("All sorted elements (from index 1 to 1000):");
        for (int i = 1; i <= N; i++) {
            System.out.print(AB[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }

        System.out.println("\n-------------------------------------------");
        System.out.println("Time Complexity: O(n log n)");
        System.out.println("Execution Time (Nanoseconds): " + durationInNanoseconds + " ns");
        System.out.println("Execution Time (Milliseconds): " + durationInMilliseconds + " ms");
        System.out.println("-------------------------------------------");
    }
}