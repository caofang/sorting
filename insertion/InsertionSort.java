public class InsertionSort
{
	public InsertionSort()
	{

	}

	public void Sort(int a[])
	{
		int len = a.length;
		int index=1;
		int i;

		while(index < len)
		{
			i = index;
			while(i>0 && a[i] < a[i-1])
			{
				Swap(a, i, i-1);
				i--;
			}
			index++;
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
		System.out.println("hello world");

		int array[] = {1,2,3,4,4,3,2,1};

		InsertionSort is = new InsertionSort();
		is.Sort(array);
		is.PrintArray(array);


	}
}