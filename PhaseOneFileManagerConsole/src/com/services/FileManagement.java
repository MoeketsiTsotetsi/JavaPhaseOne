package com.services;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileManagement {
	File f;
	File dir = new File("C:\\Files");

	String[] arrFileNames;

	public void createDirectory() throws IOException {

		if (!dir.isDirectory()) {
			dir.mkdir();
		}
	}

	public String createFile(String filename) throws IOException {
		f = new File(dir + "\\" + filename);
		String message = "";

		if (f.exists()) {
			message = "Sorry File Already Exist ...";
		} else {
			boolean result = f.createNewFile();

			if (result) {
				message = "File Created Successfully";
			} else {
				message = "File Creation Failed";
			}
		}

		return message;

	}

	public String fileDeletion(String filename) {
		f = new File(dir +"\\"+ filename);

		if (f.exists()) {
			f.delete();

			return "File deleted";
		} else {
			return "File not found";
		}
	}

	public String[] getAllFiles() {
		return arrFileNames = dir.list();
	}

	public void searchFile(String searchedFile) {
		f = new File(dir +"\\"+ searchedFile);
		if (f.exists()) {
			System.out.println("File Found");
		} else {
         System.out.println("File Not Found");
		}
	}

	public void displayAllFiles(String[] arr) throws IOException {
		
		if(arr.length > 0) {
			Arrays.sort(arr);
			System.out.println("************ Files in The Directory*****************");
			for (int i = 0; i < arr.length; i++) {
				System.out.println((i + 1) + ". " + arr[i]);
			}
		}else {
			System.out.println("No Files In The Directory At The Moment");
		}
		
	}
}
