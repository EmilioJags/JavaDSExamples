import java.util.LinkedList;
import java.util.Random;

public class BigCollections {

	public static void main(String...strings)
	{
		LinkedList<String> li = new LinkedList<>();
		
		li.add("A");
		li.add("B");
		li.addLast("F");
		li.addFirst("Firstu");
		
		System.out.println(li);
		
		li.push("push val");
		System.out.println(li);
		
		String removed = li.pop();
		
		System.out.println(li);
		System.out.println(removed);
		
		
		LinkedList<Student> studs = new LinkedList<>();
		
		Student ricardo = new Student();
		System.out.println(ricardo.toString());
		
		for(int i = 0; i < 5; i ++)
			studs.add(new Student("Name for student " + (i+1), (new Random().nextInt(100))));
		
		
		System.out.println(studs);
		
		System.out.println(studs.get(3));
	}
	
}
