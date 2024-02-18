public class E04 {
    public static void main(String[] args) {
        float[][] m = {
            {3, 1},
            {1, 5},
            {4, 9},
        };

        float[][] t = transpose(m);

        print(m);
        System.out.println();
        print(t);
    }

    // O(m.n)
    static float[][] transpose(float[][] m) {
        int rows = m.length;
        int cols = m[0].length;

        float output[][] = new float[cols][rows];

        for(int i=0; i<rows; i++) {
            for (int j = 0; j < cols; j++) {
                output[j][i] = m[i][j];
            }
        }

        return output;
    }

    // O(m.n)
    static void print(float[][] m) {
        for (float[] row : m) {
            for (float e : row) {
                System.err.print(e + " ");
            }
            System.out.println();
        }
    }
}
