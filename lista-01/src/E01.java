import java.util.Scanner;

public class E01 {
    // O(m.n)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        sc.close();

        for(int i=0; i<m; i++) {
            if(i%2 == 0) {
                for(int j=0; j<=n; j++) System.out.print(j);
            } else {
                for(int j=n; j>=0; j--) System.out.print(j);
            }
            System.out.println();
        }
    }
}
