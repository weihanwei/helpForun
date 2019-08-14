package com.example.demo;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Java8Tester {

	class Car {
		void twoWheel() {
			System.out.println("This is two");
		}
		
		void fourWheel() {
			System.out.println("This is four");
		}
		
		
	}
	
	public static void main(String[] args) {
		JFrame  jf = new JFrame("My Jframe");
		JButton  jb = new JButton("My JButton");
		jb.addActionListener(event ->System.out.println("click JBotton"));
		jf.add(jb);
		jf.pack();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
