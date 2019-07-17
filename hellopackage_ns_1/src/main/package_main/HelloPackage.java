package src.main.package_main;

import package_one.PrintHello;
import package_two.PrintHelloTwo;

public class HelloPackage{
	public static void main(String args[])
	{
		PrintHello po = new PrintHello();
		PrintHelloTwo pt = new PrintHelloTwo();
		po.printWelcome();
		pt.printWelcome();
	}
}