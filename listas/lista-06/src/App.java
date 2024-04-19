import java.util.Random;

public class App {
  public static void main(String[] args) throws Exception {
    Test.run();
  }
}

class Sort {
  public static void bubbleSort(double[] arr) {
    boolean isSwapped;

    do {
      isSwapped = false;
      for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] < arr[i + 1]) {
          swap(arr, i, i + 1);
          isSwapped = true;
        }
      }
    } while (isSwapped);

    if (!isSorted(arr)) throw new RuntimeException("arr not sorted");
  }

  public static void selectionSort(double[] arr) {
    int min;

    for (int i = 0; i < arr.length-1; i++) {
      min = i;
      
      for (int j = i+1; j < arr.length; j++) {
        if (arr[j] < arr[min]) {
          min = j;
        }
      }

      if (min != i) swap(arr, min, i);
    }

    for (double d : arr) {
      System.out.println(d);
    }

    if (!isSorted(arr)) throw new RuntimeException("arr not sorted");
  }

  public static void insertionSort(double[] arr) {
    int j;
    double key;

    for (int i = 1; i < arr.length; i++) {
      key = arr[i];
      j = i - 1;
      
      while (j >= 0 && arr[j] > key) {
        arr[j+1] = arr[j];
        j--;
      }

      arr[j+1] = key;
    }

    if (!isSorted(arr)) throw new RuntimeException("arr not sorted");
  }

  public static void mergeSort() {

  }

  public static void swap(double[] arr, int a, int b) {
    double tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }

  public static boolean isSorted(double[] arr) {
    for (int i = 0; i < arr.length-1; i++) {
      if (arr[i] < arr[i+1]) return false;
    }

    return true;
  }
}

class Test {
  enum TestAlgo {
    BUBBLE_SORT,
    SELECTION_SORT,
    INSERTION_SORT
  }

  enum TestType {
    ASCENDING,
    RANDOM,
    DESCENDING
  }

  enum TestSize {
    N10_000,
    N15_000,
    N30_000
  }

  public static void run() {
    for (TestType testType : TestType.values()) {
      System.out.printf("\n\t\t\tTabela %s\n\n", testType.toString());

      for (TestSize testSize : TestSize.values()) {
        int n;

        switch (testSize) {
          case N10_000 -> n = 10_000;
          case N15_000 -> n = 15_000;
          case N30_000 -> n = 30_000;
          default -> n = 10_000;
        }

        System.out.printf("\nTamanho do Vetor: %d\n\n", n);

        for (TestAlgo testAlgo : TestAlgo.values()) {
          long result = test(n, testAlgo, testType);

          System.out.printf("%s:\t\t%d\n", testAlgo.toString(), result);
        }
      }
    }
  }

  public static long test(int n, TestAlgo algo, TestType testType) {
    double[] arr = null;

    switch (testType) {
      case ASCENDING -> arr = ascArray(n);
      case DESCENDING -> arr = desArray(n);
      case RANDOM -> arr = randArray(n, 1, 50_000);
    }

    long startTime = System.nanoTime();

    switch (algo) {
      case BUBBLE_SORT -> Sort.bubbleSort(arr);
      case INSERTION_SORT -> Sort.insertionSort(arr);
      case SELECTION_SORT -> Sort.selectionSort(arr);
    }

    long endTime = System.nanoTime();

    return endTime - startTime;
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
}

class TestEntry {
  private Test.TestType testType;
  private Test.TestAlgo testAlgo;
  private int n;

  public TestEntry(Test.TestType testType, Test.TestAlgo testAlgo, int n) {
    this.testType = testType;
    this.testAlgo = testAlgo;
    this.n = n;
  }

  public Test.TestType getTestType() {
    return testType;
  }

  public void setTestType(Test.TestType testType) {
    this.testType = testType;
  }

  public Test.TestAlgo getTestAlgo() {
    return testAlgo;
  }

  public void setTestAlgo(Test.TestAlgo testAlgo) {
    this.testAlgo = testAlgo;
  }

  public int getN() {
    return n;
  }

  public void setN(int n) {
    this.n = n;
  }
}