import java.util.Scanner;

public class GetInputFromUser{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		String data = in.nextLine();
		
		System.out.println("user given input is ::" + data );
	}
}