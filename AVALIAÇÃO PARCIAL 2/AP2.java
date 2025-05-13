public class AP2 {

    // 1) RecursiveFactorial
    public static int recursiveFactorial(int n) {
        if (n <= 1) return 1;
        return n * recursiveFactorial(n - 1);
    }

    // 2) Regua
    public static void drawRuler(int inches, int majorLength) {
        drawLine(majorLength, "0");
        for (int i = 1; i <= inches; i++) {
            drawInterval(majorLength - 1);
            drawLine(majorLength, String.valueOf(i));
        }
    }

    private static void drawInterval(int centralLength) {
        if (centralLength >= 1) {
            drawInterval(centralLength - 1);
            drawLine(centralLength);
            drawInterval(centralLength - 1);
        }
    }

    private static void drawLine(int length) {
        drawLine(length, "");
    }

    private static void drawLine(int length, String label) {
        for (int i = 0; i < length; i++) System.out.print("-");
        if (!label.isEmpty()) System.out.print(" " + label);
        System.out.println();
    }

    // 3) LinearSum
    public static int linearSum(int[] A, int n) {
        if (n == 0) return 0;
        return linearSum(A, n - 1) + A[n - 1];
    }

    // 4) ReverseArray (recursivo)
    public static void reverseArray(int[] A, int i, int j) {
        if (i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            reverseArray(A, i + 1, j - 1);
        }
    }

    // 5) IterativeReverseArray
    public static void iterativeReverseArray(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }

    // 6) BinarySum
    public static int binarySum(int[] A, int low, int high) {
        if (low > high) return 0;
        if (low == high) return A[low];
        int mid = (low + high) / 2;
        return binarySum(A, low, mid) + binarySum(A, mid + 1, high);
    }

    // 7) BinaryFib
    public static int binaryFib(int k) {
        if (k <= 1) return k;
        return binaryFib(k - 1) + binaryFib(k - 2);
    }

    // 8) LinearFibonacci
    public static int linearFibonacci(int k) {
        if (k <= 1) return k;
        int a = 0, b = 1;
        for (int i = 2; i <= k; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    // Método main para testar as funções
    public static void main(String[] args) {
        System.out.println("1) Fatorial de 5: " + recursiveFactorial(5));

        System.out.println("\n2) Régua de 2 polegadas com marca principal de 4:");
        drawRuler(2, 4);

        int[] array = {1, 2, 3, 4, 5};
        System.out.println("\n3) Soma linear do array: " + linearSum(array, array.length));

        int[] reverseTest = {1, 2, 3, 4, 5};
        reverseArray(reverseTest, 0, reverseTest.length - 1);
        System.out.print("4) Array reverso (recursivo): ");
        for (int val : reverseTest) System.out.print(val + " ");
        System.out.println();

        int[] iterativeTest = {6, 7, 8, 9};
        iterativeReverseArray(iterativeTest);
        System.out.print("5) Array reverso (iterativo): ");
        for (int val : iterativeTest) System.out.print(val + " ");
        System.out.println();

        int[] binaryArray = {1, 2, 3, 4, 5};
        System.out.println("6) Soma binária do array: " + binarySum(binaryArray, 0, binaryArray.length - 1));

        System.out.println("7) Fibonacci (recursivo) de 6: " + binaryFib(6));
        System.out.println("8) Fibonacci (linear) de 6: " + linearFibonacci(6));
    }
}