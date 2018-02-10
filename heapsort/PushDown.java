public class PushDown
{

	public void PushDownRecursive(int a[], int size, int index)
	{
		if (2*index > size)	// already bottom level
			return;

		// pick a smaller chile
		int lChild = index * 2 + 1;
		int rChild = index * 2 + 2;
		int sChild;	// smaller child
		
		if (2*index == size || a[lChild] <= a[rChild]) 
			sChild = lChild;
		else 
			sChild = rChild;
		
		if (a[index] <= a[sChild])
			return;
		else
		{
			// Swap(a[index],a[sChild]);
			a[index] = a[index] ^ a[sChild];
			a[sChild] = a[index] ^ a[sChild];
			a[index] = a[index] ^ a[sChild];

			PrintArray(a);
			PushDownRecursive(a, size, sChild);
		}
	}

	public void PrintArray(int a[])
	{
		for (int i=0; i<a.length; i++)
			System.out.printf("%d,",a[i]);

		System.out.print("\b\n");
	}	

	public void PrintTreeNode(int a[])
	{

	}

	// public  void Swap(int a, int b)
	// {
		
	// }

	public static void main(String args[])
	{

		int array[] = {10,15,12,16,18,14,23,18,16,20,19,16,20};

		PushDown pushDown = new PushDown();
		pushDown.PrintArray(array);

		array[0] = array[array.length-1];
		pushDown.PushDownRecursive(array, array.length - 2, 0);

		pushDown.PrintArray(array);

	}
}