import java.util.Random;

public class App {
  static boolean isDebugging = true;
  public static void main(String[] args) throws Exception {
    int n = 100_000;

    double[] randArray = randArray(100_000, -1_000_000, +1_000_000);
    double[] desArray = desArray(100_000);
    double[] ascArray = ascArray(100_000);

    long startTime = System.nanoTime();

    bubbleSort(randArray);
    
    long endTime = System.nanoTime();

    System.out.println(endTime - startTime);
  }

  public static long testBubbleSort(int n) {
    double[] randArray = randArray(n, -1_000_000, +1_000_000);
    double[] desArray = desArray(n);
    double[] ascArray = ascArray(n);

    long startTime = System.nanoTime();

    bubbleSort(randArray);
    
    long endTime = System.nanoTime();

    System.out.println(endTime - startTime);
  }

  public static void bubbleSort(double[] arr) {
    boolean isSwapped;

    do {
      isSwapped = false;
      for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] < arr[i + 1]) {
          //log(String.format("arr[%d] = %.4f > arr[%d] = %.4f", i, arr[i], i+1, arr[i+1]));
          swap(arr, i, i + 1);
          isSwapped = true;
        }
      }
    } while (isSwapped);
  }

  public static void swap(double[] arr, int a, int b) {
    //log(String.format("[SWAP]: (arr[ %d ] = %.4f ) <-> (arr[ %d ] = %.4f )", a, arr[a], b, arr[b]));
    double tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }

  public static void log(String msg) {
    if (isDebugging) System.out.println(msg);
  }

  public static double[] randArray(int n, double min, double max) {
    double[] arr = new double[n];
    Random random = new Random();

    for (int i = 0; i < n; i++) {
      arr[i] = min + (max - min) * random.nextDouble();
    }

    return arr;
  }

  public static double[] desArray(int n) {
    double[] arr = new double[n];
    Random random = new Random();

    for (int i = 0; i < n; i++) {
      double e = n - i;
      double randInc = random.nextDouble();
      e += randInc;
      arr[i] = e;
    }

    return arr;
  }

  public static double[] ascArray(int n) {
    double[] arr = new double[n];
    Random random = new Random();

    for (int i = 0; i < n; i++) {
      double e = n - i;
      double randDec = random.nextDouble();
      e -= randDec;

      arr[i] = e;
    }

    return arr;
  }

  public static void printArray(double[] arr) {
    for (double d : arr) {
      System.out.println(d);
    }
  }
}

enum Sort {
  BUBBLE_SORT
}