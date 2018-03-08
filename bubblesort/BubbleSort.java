public class BubbleSort
{
	public BubbleSort()
	{

	}

	public void Sort(int a[])
	{
		int len = a.length;
		int l=len - 1;	// number of comp per round, len-1 rounds 
		int i = 0;

		while(l>0)
		{
			i = 0;
			while(i<l)
			{
				if(a[i] > a[i+1])
					Swap(a, i, i+1);

				i++;
			}
			l--;
		}
	}

	private void Swap(int a[], int x, int y)
	{
		int tmp;
		tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}

	public void PrintArray(int a[])
	{
		for(int i=0; i<a.length; i++)
			System.out.printf("%d, ", a[i]);

		System.out.println();
	}


	public static void main(String[] args)
	{
		System.out.println("Bubble Sort");

		int array[] = {5,1,4,2,8};

		BubbleSort bs = new BubbleSort();
		bs.Sort(array);
		bs.PrintArray(array);


	}
}