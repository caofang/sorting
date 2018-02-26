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
        if (leftIdx < rightIdx) 
        {
        	System.out.printf("leftIdx %d, rightIdx %d\n", leftIdx, rightIdx);
        	PrintArray(myArray,leftIdx, rightIdx);
        	
            // split the array from the middle
            int middle = leftIdx + (rightIdx - leftIdx) / 2;
            System.out.printf("middle %d\n\n", middle);
            
            Sort(leftIdx, middle);
            Sort(middle + 1, rightIdx);

            Merge(leftIdx, middle, rightIdx);
        }
    }

    private void Merge(int leftIdx, int middle, int rightIdx) 
    {
    	System.out.printf("leftIdx %d, middle %d, rightIdx %d\n",leftIdx, middle, rightIdx);
        for (int i = leftIdx; i <= rightIdx; i++) {
            helper[i] = myArray[i];
        }

        int l1 = leftIdx;	// helper array index
        int m = middle + 1;	// beginning of right array
        int l2 = leftIdx;	// myArray index
       
        // helper[] = { a,b,c ... | x,y,z ... }
        
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
        // copy the rest
        while (l1 <= middle) {
            myArray[l2] = helper[l1];
            l2++;
            l1++;
        }
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
		int array[] = {3,2,1,0};
		MergeSort ms = new MergeSort(array);
		
		ms.PrintArray(array);
		ms.Sort(0, array.length - 1);
		ms.PrintArray(array);
	}
}
