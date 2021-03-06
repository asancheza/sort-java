/*
 * Stack class
 * 
 * @author Alejandro Sanchez Acosta
 */

import java.util.Random;

public class Sorts {
  /* 
   * Selection Sort
   */
  public static <T extends Comparable<T>> int numberOfComparisonInSelectionSort(T[] arr) {
  	int compares = 0;

    /* 
     * Compares next into the current index to find the minimal and swap
     */
    for (int i = 0; i < arr.length - 1; i++) {
      int minIndex = i;

      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j].compareTo(arr[minIndex]) < 0) {
          minIndex = j;
          compares++;
        }
      }

      T temp = arr[i];
      arr[i] = arr[minIndex];
      arr[minIndex] = temp;
    }

    return compares;
  }

  /* 
   * Shell sort
   */
  public static <T extends Comparable<? super T>> int numberOfComparisonInShellSort(T[] a) {
    int compares = 0;
    int j;

    /* 
     * Compare intervals (middle and later one less and select minimal)
     */
    for (int gap = a.length / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < a.length; i++) {
         T tmp = a[i];
         for (j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap) { 
           a[j] = a[j - gap];
           compares++;
         }
         a[j] = tmp; 
      }
    }

    return compares;
  }

  /* 
   * Generate random numbers
   */
  public static Integer[] generateRandomArrayWithLength(int length) {
    Random randomGenerator = new Random();
    Integer[] arr = new Integer[length];

    for (int i=0; i<arr.length; i++) {
      arr[i] = randomGenerator.nextInt(1000);
    }

    return arr;
  }

  /* 
   * Try both implementations with different arrays sizes
   */
  public static void main(String[] args) {
    Integer[] data = new Integer[5];
    data[0] = 5;
    data[1] = 12;
    data[2] = 3;
    data[3] = 2;
    data[4] = 1;
    System.out.println("Selection Sort - Number of comparisons with simple array(5): " + numberOfComparisonInSelectionSort(data));

    Integer[] data2 = new Integer[5];
    data2[0] = 20;
    data2[1] = 12;
    data2[2] = 3;
    data2[3] = 2;
    data2[4] = 1;
    System.out.println("Shell Sort - Number of comparisons with simple array(5): " + numberOfComparisonInShellSort(data2));

    Integer[] ar1 = generateRandomArrayWithLength(100000);
    System.out.println("Selection Sort - Number of comparisons with array 100000: " + numberOfComparisonInSelectionSort(ar1));

    Integer[] ar2 = generateRandomArrayWithLength(100000);
    System.out.println("Shell Sort - Number of comparisons with array 100000: " + numberOfComparisonInShellSort(ar2));

    Integer[] ar3 = generateRandomArrayWithLength(1000000);
    System.out.println("Selection Sort - Number of comparisons with array 10000000: " + numberOfComparisonInSelectionSort(ar3));

    Integer[] ar4 = generateRandomArrayWithLength(1000000);
    System.out.println("Shell Sort - Number of comparisons with array 10000000: " + numberOfComparisonInShellSort(ar4));
  }
}
