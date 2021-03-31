import java.util.ArrayList;
import java.util.List;

public class ArrayTest {

	public static long timeLow;
	public static long timeHigh;

	public static boolean fullDebug = false;
	
	
	public static void main(String... c) {
		// System.out.println("We doin arrays now");

		int[] small = {2,3};
		int[] small2 = {1};
		
		int[] ordArr = { 1, 2, 3, 4, 5, 7, 8, 9 };

		int[] arr = { 5, 6,1,2, 3, 4,  8, 7 ,10};

		int[] dupArr = { 5, 1, 2, 3, 4, 9, 8, 5, 7 };

		String[] words = { "funny", "funk", "furry", "chunk", "bruk", "truck", "muck", "dandeelion", "team", "commit" };

		Character[] ordChars = { 'a', 'b', 'c', 'd', 'e', 'f' };

		Character[] chars = { 'h', 's', 'b', 'd', 'q', 'a' };

		List<Integer> iList = new ArrayList<Integer>();

		fullDebug=true;
		start();

		for (int i = 0; i < arr.length; i++) {
			iList.add(arr[i]);
		}
		iList.sort(null);
		findMissingNumber(iList);
		stop();
		for (Integer x : iList)
			System.out.println(x);

	}

	public static void findMissingNumber(List<Integer> li) 
	{
		int size = li.size();
		/*
		if(size == 2)
			if(li.get(0) == 1) {
				System.out.println("Missing number = 2");
				return;
			}
			else 
			{
				System.out.println("Missing number = 1");
				return;
			}*/
		
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
