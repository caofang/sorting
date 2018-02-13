import java.util.ArrayList;
public class PushDown
{

	public void PushDownRecursive(int a[], int size, int index)
	{
		if (2*(index+1) > size)	// already bottom level
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

	public void PushDownRecursive(ArrayList<Integer> list, int size, int index)
	{
		// pick a smaller chile
		int lChild = index * 2 + 1;
		int rChild = index * 2 + 2;
		int sChild;	// smaller child

		if (lChild >= size)	// no child
			return;
		
		// has two children
		if (rChild < size && list.get(rChild) <= list.get(lChild)) 
			sChild = rChild;
		else 
			sChild = lChild;

		if (list.get(index) <= list.get(sChild))
			return;
		else
		{
			// Swap;
			int a = list.get(index);
			int b = list.get(sChild);

			a = a ^ b;
			b = a ^ b;
			a = a ^ b;

			list.set(index, a);
			list.set(sChild,b);

			// System.out.println(list);	
			PushDownRecursive(list, size, sChild);
		}
	}

	public void PushDownIterative(ArrayList<Integer> list, int size, int index)
	{
		while(true)
		{
			// pick a smaller chile
			int lChild = index * 2 + 1;
			int rChild = index * 2 + 2;
			int sChild;	// smaller child

			if (lChild >= size)	// no child
				return;
			
			// has two children
			if (rChild < size && list.get(rChild) <= list.get(lChild)) 
				sChild = rChild;
			else 
				sChild = lChild;

			if (list.get(index) <= list.get(sChild))
				return;
			else
			{
				// Swap;
				int a = list.get(index);
				int b = list.get(sChild);

				a = a ^ b;
				b = a ^ b;
				a = a ^ b;

				list.set(index, a);
				list.set(sChild,b);

				index = sChild;
			}
		}
	}

	public void DeleteMin(ArrayList<Integer> list)
	{
		// copy the last one the fromt
		list.set(0, list.get(list.size()-1));
		// delete the last one
		list.remove(list.size()-1);	
	}

	public void PrintArray(int a[])
	{
		for (int i=0; i<a.length; i++)
			System.out.printf("%d, ",a[i]);

		System.out.print("\b\n");
	}	

	public static void main(String args[])
	{
		int array[] = {10,15,12,16,18,24,23,18,16,20,19,16,20};
		
		ArrayList<Integer> myData = new ArrayList<Integer>();
		for (int i: array)
			myData.add(i);

		System.out.println("original data");		
		System.out.println(myData);
		System.out.println(myData.size());

		PushDown pushDown = new PushDown();

		// array[0] = array[array.length-1];
		// pushDown.PushDownRecursive(array, array.length - 1, 0);
		// pushDown.PrintArray(array);

		pushDown.DeleteMin(myData);
		System.out.println("\nDelete Min");
		System.out.println(myData);	

		pushDown.PushDownRecursive(myData, myData.size(), 0);
		System.out.println("Pushed Down");
		System.out.println(myData);	

		pushDown.DeleteMin(myData);
		System.out.println("\nDelete Min");
		System.out.println(myData);	

		pushDown.PushDownIterative(myData, myData.size(), 0);
		System.out.println("Pushed Down");
		System.out.println(myData);	


	}
}









