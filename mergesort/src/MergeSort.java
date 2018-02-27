
public class MergeSort {

	private int[] myArray;
    private int[] helper;

    public MergeSort(int[] a) 
    {
        this.myArray = a;              
    }

    private void Sort(int leftIdx, int rightIdx) 
    {       
        if (leftIdx < rightIdx) 
        {        	
            // split the array from the middle
            int middle = leftIdx + (rightIdx - leftIdx) / 2;
            
            Sort(leftIdx, middle);
            Sort(middle + 1, rightIdx);

            Merge(leftIdx, middle, rightIdx);
        }
    }
        
    private void Merge(int leftIdx, int middle, int rightIdx) 
    {
        // myArray[]= { ...   a,b,c ... | ... x,y,z ...}
        // helper[] = 		{ a,b,c ... |     x,y,z ...}
        //					  l			      r        
    	        
        int size1 = rightIdx - leftIdx + 1;
        helper = new int[size1];    	
        for (int i = 0; i < size1; i++)
            helper[i] = myArray[leftIdx + i];
        
        int l1 = 0;	// beginning of left helper array
        int r1 = middle - leftIdx + 1;	// beginning of right helper array
        int l2 = leftIdx;	// myArray index
               
        while (l1 <= middle-leftIdx && r1 <= rightIdx-leftIdx) {
            if (helper[l1] <= helper[r1]) {
                myArray[l2] = helper[l1];
                l1++;
            } else {
                myArray[l2] = helper[r1];
                r1++;
            }
            l2++;
        }
        // copy the rest
        while (l1 <= middle-leftIdx) {
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
		int array[] = {7,6,5,4,3,2,1,0};
		MergeSort ms = new MergeSort(array);
		
		System.out.println("Original array");
		ms.PrintArray(array);
		
		ms.Sort(0, array.length - 1);
		
		System.out.println("Sorted array");
		ms.PrintArray(array);		
	}
}
