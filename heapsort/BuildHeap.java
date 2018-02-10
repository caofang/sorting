import java.util.ArrayList;

public class BuildHeap
{
	public void Heapify(ArrayList<Integer> list, int size, int index)
	{
		int largest = index;
		int lChild = 2 * index + 1;
		int rChild = 2 * index + 2;
 
        // If left child is larger than root
        if (lChild < size && list.get(lChild) > list.get(largest))
            largest = lChild;
 
        // If right child is larger than largest so far
        if (rChild < size && list.get(rChild) > list.get(largest))
            largest = rChild;
 
        // If largest is not root
        if (largest != index)
        {
            Swap(list, index, largest);
 
            // Recursively heapify the affected sub-tree
            Heapify(list, size, largest);
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
		// int array[] = {13,12,11,10,9,8,7,6,5,4,3,2,1};
		int array[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};

		ArrayList<Integer> myData = new ArrayList<Integer>();
		for (int i: array)
			myData.add(i);
		
		System.out.println(myData);

		BuildHeap bh = new BuildHeap();

		int n = myData.size();
		for (int i = n / 2 - 1; i >= 0; i--)
            // heapify(arr, n, i);
			bh.Heapify(myData, n, i);

		System.out.println(myData);
		
	}
}