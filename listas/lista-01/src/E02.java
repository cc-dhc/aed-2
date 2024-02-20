import java.util.Scanner;

public class E02 {
    // O(n)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.close();

        // fib(n)
        int a = 1;
        int b = 0;
        int t;

        for(int i=0; i<n; i++) {
            t = b;
            b = a + b;
            a = t;

            System.out.println(b);
        }
    }
}
