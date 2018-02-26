package mergesort;

public class MergeSort {

	private int[] myArray;
    private int[] helper;

    public MergeSort(int[] a) {
    	
        this.myArray = a;      
        this.helper = new int[a.length];
    }

    private void Sort(int leftIdx, int rightIdx) 
    {
        // check if leftIdx is smaller than rightIdx, if not then the array is sorted
        if (leftIdx < rightIdx) 
        {
        	System.out.printf("leftIdx %d, rightIdx %d\n", leftIdx, rightIdx);
        	PrintArray(myArray,leftIdx, rightIdx);
        	
            // Get the index of the element which is in the middle
            int middle = leftIdx + (rightIdx - leftIdx) / 2;
            System.out.printf("middle %d\n\n", middle);
            // Sort the left side of the array
            Sort(leftIdx, middle);
            // Sort the right side of the array
            Sort(middle + 1, rightIdx);
            // Combine them both
            Merge(leftIdx, middle, rightIdx);
        }
    }

    private void Merge(int leftIdx, int middle, int rightIdx) {

        // Copy both parts into the helper array
        for (int i = leftIdx; i <= rightIdx; i++) {
            helper[i] = myArray[i];
        }

        int l1 = leftIdx;	// array index
        int m = middle + 1;
        int l2 = leftIdx;	// helper array index
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (l1 <= middle && m <= rightIdx) {
            if (helper[l1] <= helper[m]) {
                myArray[l2] = helper[l1];
                l1++;
            } else {
                myArray[l2] = helper[m];
                m++;
            }
            l2++;
        }
        // Copy the rest of the left side of the array into the target array
        while (l1 <= middle) {
            myArray[l2] = helper[l1];
            l2++;
            l1++;
        }
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.

    }
    
	public void PrintArray(int a[])
	{
		for(int i=0; i<a.length; i++)
			System.out.printf("%d, ",a[i]);
		System.out.println();
	}
	
	public void PrintArray(int a[], int leftIdx, int rightIdx)
	{
		for(int i=leftIdx; i<=rightIdx; i++)
			System.out.printf("%d, ",a[i]);
		System.out.println();
	}
	
	public static void main(String[] args)
	{				
		int array[] = {7,6,5,4,3,2,1,0};
		MergeSort ms = new MergeSort(array);
		
		ms.PrintArray(array);
		ms.Sort(0, array.length - 1);
		ms.PrintArray(array);
	}
}
