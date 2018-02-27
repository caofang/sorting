import java.util.*;
 
public class HeapSort {
 
   private static int[] a;
   private static int n;
   private static int left;
   private static int right;
   private static int largest;
 
 
   public static void buildheap(int []a) 
   {
      n = a.length-1;
      for(int i=n/2; i>=0; i--){
         MaxHeap(a,i);
      }
   }
 
   public static void MaxHeap(int[] a, int i) 
   { 
      left = 2*i;
      right = 2*i+1;
 
      if(left <= n && a[left] > a[i])
      {
         largest=left;
      } else {
         largest=i;
      }
 
      if(right <= n && a[right] > a[largest]) 
      {
         largest=right;
      }
      if(largest!=i) {
         Swap(i, largest);
         MaxHeap(a, largest);
      }
   }
 
   public static void Swap(int i, int j) 
   {
        int t = a[i];
        a[i] = a[j];
        a[j] = t; 
   }
 
   public static void Sort(int[] array) 
   {
      a = array;
      buildheap(a);
      for(int i=n; i>0; i--) {
         Swap(0, i);
         n--;
         MaxHeap(a, 0);
      }
   }
   
   public void PrintArray(int a[])
   {
	   for(int i=0; i<a.length; i++)
		   System.out.printf("%d,", a[i]);
	   
	   System.out.println();
   }
 
   public static void main(String[] args) {
      int array[]={7,6,5,4,3,2,1,0};
      HeapSort hs = new HeapSort();
      
      hs.PrintArray(array);
      hs.Sort(array);
      hs.PrintArray(array);
   }
}