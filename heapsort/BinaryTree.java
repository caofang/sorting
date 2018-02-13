import java.util.ArrayList;

public class BinaryTree
{
	ArrayList<Integer> list;
	int size;
	int level;

	BinaryTree(ArrayList<Integer> l)
	{
		list = l;
		size = getSize();
		level = getLevel(size);
	}

	void PrintTree()
	{
		printRows();
	}

	void printRows()
	{		
		for (int r=0; r<level+1; r++)
		{
			// calculate initial spaces
			int iSpace = 2*(int)Math.pow(2,level-r)+1;

			printSpaces(iSpace);
			printColumns(r);
			// System.out.println();
			printLines((int)Math.pow(2,level-r));			
		}		
	}

	void printColumns(int r)
	{
		// element per row
		int n = (int)Math.pow(2,r);	//2^r;
		// get starting index
		int index = (int)Math.pow(2,r)-1; 
		// calculate space between row elements 
		int rSpace = 4*(int)Math.pow(2,level-r)-1;

		// print initial space
		printSpaces(0);
		for(int i=index; i<(index+n); i++)
		{
			if(i>=size)
				break;
			System.out.print(list.get(i));
			if(list.get(i)>9)
				printSpaces(rSpace-1);
			else
				printSpaces(rSpace);
		}
			
	}

	void printSpaces(int n)
	{
		for (int i = 0; i<n; i++)			
			System.out.print(" ");
	}

	void printLines(int n)
	{
		for (int i = 0; i<n; i++)			
			System.out.println("");
	}

	int getSize()
	{
		size = list.size();
		return size; 
	}

	int getLevel(int size)
	{
		level = log(size, 2);
		return level;
	}

	int log(int x, int base)
	{
	    return (int) (Math.log(x) / Math.log(base));
	}

	public static void main(String[] args)
	{
		int array[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		int size;

		ArrayList<Integer> myData = new ArrayList<Integer>();
		for (int i: array)
			myData.add(i);

		size = myData.size();
		System.out.println("Original Data");
		System.out.println(myData);
		System.out.println("==========");

		BinaryTree bt = new BinaryTree(myData);
		bt.printRows();

		System.out.println(myData);
		

	}
}