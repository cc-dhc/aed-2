public class Exercicios {
    public static void main(String[] args) throws Exception {
        //int[] arr = {1, 2, 3, 4, 0, -50};

        //ex01( arr, 4);

        // System.out.println(divide(10, 2));
        // System.out.println(divide(11, 2));
        // System.out.println(divide(50, 2));

        // System.out.println(ex03(55555));

        // System.out.println(ex04(55555));

        // System.out.println(ex05(10, 3));

        // System.out.println(ex06(2, 2, 7));

        // System.out.println(ex07(arr, 1, arr.length));

        // System.out.println(ex08(2, 8));

        // System.out.println(ex09(arr, arr.length));
    }

    public static void ex01(int[] arr, int n) {
        if (n == 0) return; 
        System.out.println(arr[n-1]); 
        ex01(arr, n - 1);
    }

    public static int divide(int a, int b) {
        if (b > a) return 0;
        return 1 + divide(a - b, b);
    }

    public static int ex03(int n) {
        if (n == 0) return 0;
        return 1 + ex03(n / 10);
    }

    public static int ex04(int n) {
        if (n == 0) return 0;
        return n % 10 + ex04(n / 10);
    }

    public static int ex05(int a, int b) {
        if (b == 0) return 0;
        return a + ex05(a, b - 1);
    }

    public static int ex06(int p, int r, int n) {
        if (n == 0) return p;
        return r * ex06(p, r, n - 1);
    }

    public static int ex07(int[] arr, int k, int n) {
        if (arr[n - 1] == k) return n - 1;
        if (n - 1 == 0) return -1;
        return ex07(arr, k, n - 1);
    }

    public static int ex08(int n, int e) {
        if (e == 1) return n;
        return n * ex08(n, e - 1);
    }

    public static int ex09(int[] arr, int n) {
        int m;

        if (n - 1 == 0) return arr[0];
        m = ex09(arr, n - 1);
        if (arr[n - 1] < m) m = arr[n - 1];
        return m;
    }

    public static int ex10(int n) {
        if (n == 0) return 1;
        if (n == 1) return 2;
        return ex10(n - 1) * ex10(n - 2) - ex10(n - 1); 
    }
}
