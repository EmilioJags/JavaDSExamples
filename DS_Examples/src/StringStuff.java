import java.util.ArrayList;

public class StringStuff {

	public static long timeLow, timeHigh;
	public static boolean fullDebug = false;

	public static void main(String[] args) {

		String word = "Linked List is Fun to reverse";

		String[] words = { "funny", "funk", "furry", "chunk", "bruk", "truck", "muck", "dandeelion", "team", "commit" };

		String[] anagram1 = { "Angel", "Dormitory", "Silent", "School master", "mario", "karo" };
		String[] anagram2 = { "Angle", "Dirty room", "Listen", "The classroom", "maria", "kar" };

		String[][] anagramTestArray = { anagram1, anagram2 };

		
		start();
		findAnagram(anagram1, anagram2);
		stop();

		start();
		reverseWord(word);
		stop();

	}

	public static void findAnagram(String[] arr1, String[] arr2) {

		ArrayList<Character> st = null;
		ArrayList<Character> st2 = null;
		boolean notA = true;
		for (int i = 0; i < arr1.length; i++) {

			if(arr1[i].length() != arr2[i].length())
			{

				System.out.println(arr1[i] + " is not anagram of " + arr2[i] + " [size]"); 
				continue;
			}
			
			st = new ArrayList<>();
			for (Character c : arr1[i].replaceAll(" ", "").toLowerCase().toCharArray())
				st.add(c);

			st.sort(null);

			st2 = new ArrayList<>();
			for (Character c : arr2[i].replaceAll(" ", "").toLowerCase().toCharArray())
				st2.add(c);

			st2.sort(null);

			for (int j = 0; j < st.size(); j++) {
				if (st.get(j) == st2.get(j))
					continue;
				else {
					System.out.println(arr1[i] + " is not anagram of " + arr2[i]);
					notA = false;
					break;
				}
			}
			if (notA) {
				System.out.println(arr1[i] + " is anagram of " + arr2[i]);
				System.out.println(st);
				System.out.println(st2);
			}
			st = null;
			st2 = null;
		}
	}

	public static void reverseWord(String str) {

		String reverse = "";
		for (Character c : str.toCharArray()) {
			reverse = c + reverse;
		}
		System.out.println("Let's reverse: " + str);
		System.out.println("Reverse word = " + reverse);
	}

	public static void howLong() {
		System.out.printf("Time to solve: %d milliseconds \n", timeHigh - timeLow);
	}

	public static void start() {
		timeLow = System.currentTimeMillis();
		if (fullDebug)
			System.out.println(timeLow);
	}

	public static void stop() {
		timeHigh = System.currentTimeMillis();
		if (fullDebug)
			System.out.println(timeHigh);
		howLong();
	}

}
