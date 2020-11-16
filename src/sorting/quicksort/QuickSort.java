package sorting.quicksort;

public class QuickSort {
	
	public static int ASCENDING_ORDER = 0;
	public static int DESCENDING_ORDER = 1;

	public static void main(String[] args)
	{
		int marks[] = new int[]{21,1,4,7,3,11,13,322,55,6,-1,3,2,66,90,55,1123,221,6674,-33,23,54,3};
		quickSort(marks, 0, marks.length-1, DESCENDING_ORDER);
		for (int score : marks)
		{
			System.out.println(score);
		}
		
		quickSort(marks, 0, marks.length-1, ASCENDING_ORDER);
		for (int score : marks)
		{
			System.out.println(score);
		}
	}
	
	public static void quickSort(int input[],int startIndex,int endIndex,int order)
	{
		if(order != ASCENDING_ORDER && order != DESCENDING_ORDER)
			throw new IllegalArgumentException();
		if(startIndex < endIndex)
		{
			int partionIndex = partitionArray(input,order,startIndex,endIndex);
			quickSort(input,startIndex,partionIndex-1,order);
			quickSort(input,partionIndex+1,endIndex,order);	
		}
	}
	
	private static int partitionArray(int input[],int order,int startIndex,int endIndex)
	{
		int partionIndex = startIndex;
		int pivot = input[endIndex];
		for (int index = startIndex; index < endIndex; index++)
		{
			if(order == ASCENDING_ORDER && input[index] <= pivot)
			{
				swap(input,index,partionIndex);
				partionIndex++;
				
			}else if(order == DESCENDING_ORDER && input[index] >= pivot)
			{
				swap(input,index,partionIndex);
				partionIndex++;
			}
		}
		swap(input, partionIndex, endIndex);
		return partionIndex;
	}
	
	private static void swap(int input[],int primaryIndex,int secondaryIndex)
	{
		int temp = input[primaryIndex];
		input[primaryIndex] = input[secondaryIndex];
		input[secondaryIndex] = temp;
	}
	
}
