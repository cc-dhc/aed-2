import java.util.Scanner;

public class E03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.close();

        System.out.println(f(n));
    }

    // O(n)
    static float f(int n) {
        float s = 0;

        for(int i=1; i<=n; i++) {
            s += 1/(float) i;
        }

        return s;
    }
}
