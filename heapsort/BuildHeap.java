import java.util.ArrayList;

public class BuildHeap
{
	PushDown pushDown = new PushDown();

	void BuildHeap()
	{
		// PushDown pushDown = new PushDown();
	}

	public void BuildHeapRecursive(ArrayList<Integer> list, int size, int index)
	{

		int lChild = index * 2 + 1;
		int rChild = index * 2 + 2;

		if (lChild >= size)	// no child
			return;
		if (index < 0)
			return;

		pushDown.PushDownRecursive(list,size,index); //Now pushdown the root.
		
		// System.out.println(list);
		// BinaryTree bt = new BinaryTree(list);
		// bt.PrintTree();

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

			pushDown.PushDownRecursive(list,size,index); //Now pushdown the root.
			// System.out.println(list);
			// BinaryTree bt = new BinaryTree(list);
			// bt.PrintTree();

			index--;
		}
	}

	public static void main(String args[])
	{
		int array[] = {13,12,11,10,9,8,7,6,5,4,3,2,1};
		int size;

		ArrayList<Integer> myData = new ArrayList<Integer>();
		for (int i: array)
			myData.add(i);

		size = myData.size();
		System.out.println("========== Original Data ==========");
		System.out.println(myData);

		BinaryTree bt = new BinaryTree(myData);

		bt.PrintTree();

		BuildHeap bh = new BuildHeap();

		// ========== build with recursive way ==========
		// bh.BuildHeapRecursive(myData, size, size/2-1);
		System.out.println("\n========== Build Heap Recursive ==========");
		bh.BuildHeapRecursive(myData, size, size/2-1);

		System.out.println("\nFinal Result");
		System.out.println(myData);
		bt.setData(myData);
		bt.PrintTree();
		

		// ========== build with interative way ==========
		for (int i=0; i<array.length; i++)
			myData.set(i, array[i]);

		// index is the last subtree index = size/2-1
		// bh.BuildHeapRecursive(myData, size, size/2-1);
		System.out.println("\n========== Build Heap Iterative ==========");
		bh.BuildHeapIterative(myData, size, size/2-1);

		System.out.println("\nFinal Result");
		System.out.println(myData);
		bt.setData(myData);
		bt.PrintTree();
	}
}