
public class QuickSort 
{
	private int array[];
	
	public QuickSort()
	{
		
	}
	
    public void QuickSort(int[] a) {
        // check for empty or null array
        if (a ==null || a.length==0){
            return;
        }
        
        this.array = a;
        Sort(array, 0, a.length - 1);
    }
    
	public void Sort(int a[], int leftIdx, int rightIdx)
	{
		if(leftIdx >= rightIdx)
			return;
		
		// left to right 
		int l = leftIdx;	// compared left element
		int r = rightIdx;	// compared right element
		int piviotVal = getPiviotIdx(a,l,r);		

		while(l<=r)
		{
			while(a[l] < piviotVal) 
				l++;
			
			while(a[r] > piviotVal) 
				r--;
			
			if(l <= r)
			{
				Swap(a,l,r);
				l++;
				r--;
			}
			
		}
		
		if(leftIdx < r)
			Sort(a,leftIdx,r);
		if(rightIdx > l)
			Sort(a,l,rightIdx);
	}
	
	private int getPiviotIdx(int a[], int l, int r)
	{
		// pick the middle point as piviot for now		
		return a[l + (r-l)/2];
	}
	
	public void Swap(int a[], int i, int j)
	{	
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public void PrintArray(int a[])
	{
		for(int i=0; i<a.length; i++)
			System.out.printf("%d, ",a[i]);
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int array[] = new int[32];
		for(int i=0; i<array.length; i++)
			array[i] = array.length - i;
		
		
		QuickSort qs = new QuickSort();	
		
		qs.PrintArray(array);				
		qs.Sort(array, 0, array.length-1);		
		qs.PrintArray(array);
		
	}

}
