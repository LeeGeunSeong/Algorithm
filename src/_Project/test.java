package _Project;
public class test {
   static int number = 8;
   static int[] sorted = new int[8];

   public static void mergeSort(int[] a, int m, int n) {
      if (m < n) {
         int middle = (m + n) / 2;
         mergeSort(a, m, middle);
         mergeSort(a, middle + 1, n);
         merge(a, m, middle, n);
      }
   }

   public static void merge(int[] a, int m, int middle, int n) {
      int i = m, j = middle + 1, k = m;
      while (i <= middle && j <= n) {
         if (a[i] <= a[j]) {
            sorted[k] = a[i];
            i++;
         } else {
            sorted[k] = a[j];
            j++;
         }
         k++;
      }

      if (i > middle) {
         for (int t = j; t <= n; t++) {
            sorted[k] = a[t];
            k++;
         }
      } else {
         for (int t = i; i <= middle; t++) {
            sorted[k] = a[t];
            k++;
         }
      }

      for (int p = m; p <= n; p++) {
         a[p] = sorted[p];
      }

   }

   public static void main(String[] args) {
      int[] a = { 1, 3, 5, 7, 9, 8, 6, 4 };
      mergeSort(a, 0, number - 1);

      for (int i = 0; i < number; i++) {
         System.out.println(a[i]);
      }
   }

}