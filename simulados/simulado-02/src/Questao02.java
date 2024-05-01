public class Questao02 {
  public static void main(String[] args) {
    double[] arr = {8, 9, 18, 5, 10, 14, 15, 20};

    System.out.println("\t\t[Merge Sort]");
    Sort.printArray(arr);
    Sort.mergeSort(arr.clone());

    System.out.println("\t\t[Insertion Sort]");
    Sort.printArray(arr);
    Sort.insertionSort(arr.clone());

    System.out.println("\t\t[Shell Sort]");
    Sort.printArray(arr);
    Sort.shellSort(arr.clone());

    System.out.println("\t\t[Bubble Sort]");
    Sort.printArray(arr);
    Sort.bubbleSort(arr.clone());
  }
}

class Sort {
  public static void bubbleSort(double[] arr) {
    boolean isSwapped;

    do {
      isSwapped = false;
      for (int i = arr.length - 1; i > 0; i--) {
        if (arr[i] < arr[i - 1]) {
          swap(arr, i, i - 1);
          printArray(arr);
          isSwapped = true;
        }
      }
    } while (isSwapped);

    if (!isSorted(arr))
      throw new RuntimeException("arr not sorted");
  }

  public static void insertionSort(double[] arr) {
    int j;
    double key;

    for (int i = 1; i < arr.length; i++) {
      key = arr[i];
      j = i;

      while (j > 0 && arr[j - 1] > key) {
        arr[j] = arr[j - 1];
        printArray(arr);
        j--;
      }

      arr[j] = key;
      printArray(arr);
    }

    if (!isSorted(arr))
      throw new RuntimeException("arr not sorted");
  }

  // in-place merge sort: https://www.geeksforgeeks.org/in-place-merge-sort/
  public static void mergeSort(double[] arr) {
    mergeSort(arr, 0, arr.length - 1);

    if (!isSorted(arr))
    throw new RuntimeException("arr not sorted");
  }

  private static void mergeSort(double[] arr, int l, int r) {
    if (l < r) {
      // Same as (l + r) / 2, but avoids overflow
      // for large l and r
      int m = l + (r - l) / 2;

      // Sort first and second halves
      mergeSort(arr, l, m);
      mergeSort(arr, m + 1, r);

      merge(arr, l, m, r);
    }
  }

  private static void merge(double[] arr, int start, int mid, int end) {
    int start2 = mid + 1;

    // If the direct merge is already sorted
    if (arr[mid] <= arr[start2]) {
      return;
    }

    // Two pointers to maintain start
    // of both arrays to merge
    while (start <= mid && start2 <= end) {
      // If element 1 is in right place
      if (arr[start] <= arr[start2]) {
        start++;
      } else {
        double value = arr[start2];
        int index = start2;

        // Shift all the elements between element 1
        // element 2, right by 1.
        while (index != start) {
          arr[index] = arr[index - 1];
          printArray(arr);
          index--;
        }
        arr[start] = value;
        printArray(arr);

        // Update all the pointers
        start++;
        mid++;
        start2++;
      }
    }
  }

  public static void shellSort(double[] arr) {
    int i, j, h = 1;
    double value;

    do {
      h = 3 * h + 1;
    } while (h < arr.length);

    do {
      h = h / 3;
      for (i = h; i < arr.length; i++) {
        value = arr[i];
        j = i - h;
        while (j >= 0 && value < arr[j]) {
          arr[j + h] = arr[j];
          printArray(arr);
          j = j - h;
        }
        arr[j + h] = value;
        printArray(arr);
      }
    } while (h > 1);

    if (!isSorted(arr))
      throw new RuntimeException("arr not sorted");
  }

  public static void swap(double[] arr, int a, int b) {
    double tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }

  public static boolean isSorted(double[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1])
        return false;
    }

    return true;
  }

  public static void printArray(double[] arr) {
    System.out.print("[Array]:\t");
    for (double d : arr) {
      System.out.printf("%.0f\t", d);
    }
    System.out.println();
  }
}
