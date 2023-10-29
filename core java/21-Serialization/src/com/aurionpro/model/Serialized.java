package com.aurionpro.model;
//import com.auroinpro.model.Account;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Serialized {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create an object to serialize
		Account account = new Account(1,"Tanuja",20000);

		try {
			
			 // Create an output stream to a file
			FileOutputStream file = new FileOutputStream("C:\\Serialzed\\test1.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			 // Write the object to the output stream
			out.writeObject(account);
			
			// Close the streams
			out.close();
			file.close();
			System.out.println("Done");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
