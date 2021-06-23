package com.strop;

import java.util.Scanner;

class TestOne{
	int test = 7;
	void show() {
		System.out.println("Instance variable "+test);
	}
}

public class InsertDebugger {

	public static void main(String[] args) throws Exception {
		System.out.println("StringOperation File INIT");
		
		Scanner sc = new Scanner(System.in);
		TestOne obj = new TestOne();
		int i =  20;
		
		int input = sc.nextInt();
		
		System.out.println(input + i);
		obj.show();
		input = sc.nextInt();
		obj = new TestOne();
		obj.show();
		//DirectoryProcessor.processDirectory();
	}
}
