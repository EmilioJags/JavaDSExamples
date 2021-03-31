
public class bucky {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] words = { "funny", "funk", "furry","chunk", "bruk", "truck","muck","dandeelion", "team","commit"};
		
		for(String str : words)
		{
			if(str.startsWith("fu"))
				System.out.println(str + " - starts with 'fu'");
		}
	}
}
