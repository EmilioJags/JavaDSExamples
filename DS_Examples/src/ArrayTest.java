import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

public class ArrayTest {

	public static long timeLow;
	public static long timeHigh;

	public static boolean fullDebug = false;
	
	
	public static void main(String... c) {
		// System.out.println("We doin arrays now");

		int[] small = {2,3};
		int[] small2 = {1};
		
		int[] ordArr = { 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13};
	
		// missing values 6, 9, 10, 13, 16
		int[] arr = { 1,2, 3, 4,5,7,8,11,12,14,15,17};

		int[] dupArr = {15,77, 5, 1,5, 2, 3, 4, 9, 8, 7, 10, 11, 12, 13,14,15,77 };

		String[] words = { "funny", "funk", "furry", "chunk", "bruk", "truck", "muck", "dandeelion", "team", "commit" };

		Character[] ordChars = { 'a', 'b', 'c', 'd', 'e', 'f' };

		Character[] chars = { 'h', 's', 'b', 'd', 'q', 'a' };

		int howMany = 200;
		int[] bigSmall = new int[howMany];
		
 
		
		start();
		findMinMax(bigSmall);
		stop();
		
		Map<String, String> map = new HashMap<>();
		 
		List<Integer> iList = new ArrayList<Integer>();

		fullDebug=false;
		
		
		Stack<Integer> st = new Stack<>();
		
		int[] revArr = new int[ordArr.length];
		int j = 0;
		for(int i = ordArr.length - 1; i >= 0; i--)
		{
			revArr[j] = ordArr[i];
			j++;
		}
		
		for(Integer x : revArr)
			System.out.println("--" + x);
		
		
		
		for(int i = ordArr.length - 1; i >= 0; i--)	
		{
			st.add(ordArr[i]);
		}
		System.out.println("The stack = " + st);
		System.out.println("Stack peek top of pile: " + st.peek()); 
		
		/*
		start();

		for (int i = 0; i < arr.length; i++) {
			iList.add(arr[i]);
		}
		iList.sort(null);
		findMissingNumber(iList);
		stop();
		for (Integer x : iList)
			System.out.println(x);
		
		start();
		findMissingNumber(arr);
		stop();
		
		start();
		findDuplicateNumber(dupArr);
		stop();
		
		start();
		findMissingNumbers(arr, 17);
		stop();
		*/
	}
	
	public static void findMinMax(int[] arr)
	{
		int howMany = arr.length;
		Random randy = new Random();
		for(int i = 0; i < howMany; i++)
		{
			arr[i] = randy.nextInt(howMany+1);
		}

		Arrays.sort(arr);
		for(int i = 0; i < howMany; i++)
			System.out.println(arr[i]);
		
		int min, max;
		
		if(arr[0] < arr[1])
		{
			min = arr[0];
			max = arr[1];	
		}
		else
		{
			min = arr[1];
			max = arr[0];	
		}
		 
		
		for(int i = 2; i < howMany; i++)
		{			
			if(arr[i] < min)
			{	
				min = arr[i];
				continue;
			}
			if(arr[i] > max) {
				max = arr[i];
				continue;
			}			
		}

		System.out.println("Min: " + min);
		System.out.println("Max: " + max);
	}
	
	public static void findMissingNumbers(int[] arr, int size)
	{
		int[] newArr = new int[size-arr.length];
		boolean found = false;
		int pos = 0;
		for(int i = 1; i <= size; i++)
		{
			found = false;
			for(int j = 0; j < arr.length; j++)
			{
				if(i == arr[j])
				{
					//System.out.println("Value " + i + " is in array");
					found = true;
					break;
				}
			}
			if(found)
				continue;
			else
			{
				newArr[pos] = i; 
				pos++;
				System.out.println("One missing value is " + i);
			}
		}
	}
	
	
	public static void findDuplicateNumber(int[] arr)
	{
		boolean foundDups = false;
		for(int i = 0; i < arr.length; i++)
			for(int j = i + 1; j < arr.length; j++)
			{ 
				if(arr[i] == arr[j])
				{
					System.out.println("Duplicate is " + arr[i]);
					if(!foundDups)
						foundDups = !foundDups;
				}
			}
		if(foundDups)
			return;
		System.out.println("no duplicate");
	}
	
	
	
	public static void findMissingNumber(int[] arr)
	{
		int n = arr.length+1;
		int sum = n * (n+1) / 2;
		int toRest = 0;
		
		for(int i = 0; i < arr.length; i++)
		{
			toRest += arr[i];
		}
		sum = sum - toRest;
		System.out.println("Value missing is: " + sum);
	}
	

	public static void findMissingNumber(List<Integer> li) 
	{
		int size = li.size();
		 
		
		if(li.get(0) != 1) {
			System.out.println("Missing number = 1");
			return;
		}
		
		for(int i = 1; i < li.size(); i ++)
		{
			if(li.get(i) - 1 != li.get(i - 1))
			{
				System.out.printf("\nMissing value is %d \n", (li.get(i) - 1) );
				return;
			}
		}
		
	}

	public static void howLong() {
		System.out.printf("Time to solve: %d milliseconds \n", timeHigh - timeLow);
	}

	public static void start() {
		timeLow = System.currentTimeMillis();
		if(fullDebug)
			System.out.println(timeLow);
	}

	public static void stop() {
		timeHigh = System.currentTimeMillis();
		if(fullDebug)
			System.out.println(timeHigh);
		howLong();
	}

}
