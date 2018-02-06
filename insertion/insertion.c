#include <stdio.h>

void Swap(int* a, int* b)
{
	*a = *a ^ *b;
	*b = *a ^ *b;
	*a = *a ^ *b;
}

int main(int argc, char* argv[])
{
	int i=0;
	int j=0;
	int array[] = {5,3,1,4,2};
	int len = 5;
	
	for (i=0; i<len; i++)
		printf("original array: %d\n", array[i]);

	i=1;
	while(i < len)
	{
		j=i;
		while(j>0 && array[j-1] > array[j])
		{
			Swap(&array[j], &array[j-1]);
			j--;
		}
		i++;
	}

	for (i=0; i<len; i++)
		printf("sorted array: %d\n", array[i]);
}


