package com.aurionpro.model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class fileHandling {
	public static void main(String[] args) {

		String filePath = "D:\\filehandling\\text1.txt";
		BufferedReader br = null;
		int lineCount = 0;
		int wordCount = 0;
		int characterCount = 0;

		try {
			br = new BufferedReader(new FileReader(filePath));
			String line = br.readLine();
			while (line != null) {
				lineCount++;
				String[] words = line.split(" ");
				wordCount = wordCount + words.length;
				for (String word : words) {
					characterCount = characterCount + word.length();
				}

				line = br.readLine();
			}
			System.out.println("Number Of Chars In A File : " + characterCount);
			System.out.println("Number Of Words In A File : " + wordCount);
			System.out.println("Number Of Lines In A File : " + lineCount);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
