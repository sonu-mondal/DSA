package Opentext_Interview;

public class first {
	private static int method() {
		System.out.println("a");
		return 1;
	}
	private static String method() {
		System.out.println(1);
		return "a";
	}

	public static void main(String[] args) {
	int a=method();
	String ans=method();

	}

}


//  o/p :
//compilation problem: 
//	Type mismatch: cannot convert from int to String