import java.util.HashMap;
import java.util.Random;

public class App {
  public static void main(String[] args) throws Exception {
    
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
  }

  public static void swap(double[] arr, int a, int b) {
    double tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }
}

class Test {
  static HashMap<TestEntry, Long> results = new HashMap<>();

  enum TestAlgo {
    BUBBLE_SORT,

  }

  enum TestType {
    ASCENDING,
    RANDOM,
    DESCENDING
  }

  enum TestSize {
    T1,
    T2,
    T3
  }

  public static void ascTest() {
    for (TestType testType : TestType.values()) {
      for (TestAlgo testAlgo : TestAlgo.values()) {
        for (TestSize testSize : TestSize.values()) {
          TestEntry testEntry = null;

          switch (testSize) {
            case T1 -> testEntry = new TestEntry(testType, testAlgo, 10_000);
            case T2 -> testEntry = new TestEntry(testType, testAlgo, 15_000);
            case T3 -> testEntry = new TestEntry(testType, testAlgo, 30_000);
          }

          results.put(testEntry, test(testEntry.getN(), testAlgo, testType));
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