package com.aurionpro.model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserilazied {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Account account = new Account(1,"Tanish",20000);
		
		try {
			FileInputStream file = new FileInputStream("C:\\\\Serialzed\\\\test1.txt");
			ObjectInputStream in= new ObjectInputStream(file);
			Account account = (Account)in.readObject();
			in.close();
			file.close();
			System.out.println("ok");
			System.out.println(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
