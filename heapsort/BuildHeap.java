import java.util.ArrayList;

public class BuildHeap
{
	public void BuildHeapRecursive(ArrayList<Integer> list, int size, int index)
	{

		int lChild = index * 2 + 1;
		int rChild = index * 2 + 2;

		if (lChild >= size)	// no child
			return;
		if (index < 0)
			return;

		PushDownRecursive (list,size,index); //Now pushdown the root.

		index--;
		BuildHeapRecursive(list, size, index);

	}

	public void BuildHeapIterative(ArrayList<Integer> list, int size, int index)
	{
		while (index >=0)
		{
			int lChild = index * 2 + 1;
			int rChild = index * 2 + 2;

			if (lChild >= size)	// no child
				return;
			if (index < 0)
				return;

			PushDownRecursive (list,size,index); //Now pushdown the root.

			index--;
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

	public void Swap(ArrayList<Integer> list,int idx1, int idx2)
	{
		// Swap;
		int a = list.get(idx1);
		int b = list.get(idx2);

		list.set(idx2, a);
		list.set(idx1, b);
	}

	public static void main(String args[])
	{
		int array[] = {13,12,11,10,9,8,7,6,5,4,3,2,1};
		// int array[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13, 14, 15};
		// int array[] = {7,6,5,4,3,2,1,0};
		int size;

		ArrayList<Integer> myData = new ArrayList<Integer>();
		for (int i: array)
			myData.add(i);

		size = myData.size();
		System.out.println("Original Data");
		System.out.println(myData);
		System.out.println("==========");

		BuildHeap bh = new BuildHeap();

		
		
		// index is the last subtree index = size/2-1
		// bh.BuildHeapRecursive(myData, size, size/2-1);
		System.out.println("\nBuildHeapIterative");
		bh.BuildHeapIterative(myData, size, size/2-1);

		System.out.println(myData);
	}
}