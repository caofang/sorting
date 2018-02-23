
public class QuickSort {
	
	public QuickSort()
	{
		
	}
	public void Sort(int a[], int leftIdx, int rightIdx)
	{
		if(leftIdx >= rightIdx)
			return;
				
		int piviotIdx = getPiviot(a, leftIdx, rightIdx);
		Swap(a, a[leftIdx], a[piviotIdx]);
		
		int piviotVal = a[piviotIdx];
		
		
	}
	
	private int getPiviot(int a[], int lBound, int rBound)
	{
		// pick the middle point as piviot for now
		int piviot;
		piviot = a[(lBound+rBound)/2];
		
		return piviot;
	}
	
	public void Swap(int array[], int a, int b)
	{
		
	}
	
	public static void main(String[] args) {
		int array[] = new int[32];
		int size  = 32; 
		
		// fill the 32 elements array in desending order
		for(int i=0; i<size; i++)		
			array[i] =  size - 1 - i;
			
		for(int i=0; i<size; i++)
			System.out.printf("array[%d] = %d\n", i,array[i]);
		
		QuickSort qs = new QuickSort();
		qs.Sort();
		
		
	}

}
