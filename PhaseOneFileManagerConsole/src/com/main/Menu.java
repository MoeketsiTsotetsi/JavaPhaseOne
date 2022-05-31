package com.main;

import java.io.IOException;
import java.util.Scanner;

import com.services.FileManagement;

public class Menu {

	public static void main(String[] args) {
		FileManagement objFileManagement = new FileManagement();

		Scanner sc = new Scanner(System.in);
		String filename;
		String result = "";
		String[] arrFilenames;
		int mainMenuOption = 0;
		int innerMenuOption = 0;

		System.out.println("---------- Application Name : Console File Management --------");
		System.out.println("This application was made by Moeketsi Tsotetsi !");
		System.out.println("*************************************************");
		System.out.println("");

		try {
			objFileManagement.createDirectory();
		} catch (IOException e1) {
			System.err.println(e1.toString());

		}

		do {
			System.out.println("Press 1 To View All Files In The Directory");
			System.out.println("Press 2 To View More Options");
			System.out.println("Press 3 To Quit The Application");
			System.out.println("");

			try {

				System.out.println("Enter Your Option Here");
				mainMenuOption = Integer.parseInt(sc.next());

				if (mainMenuOption == 1) {
					arrFilenames = objFileManagement.getAllFiles();
					objFileManagement.displayAllFiles(arrFilenames);
					System.out.println("");
					System.out.println("Enter 1 To Return To Main Menu , 7 To Exit The Application");
					innerMenuOption = Integer.parseInt(sc.next());

					if (innerMenuOption == 1) {
						continue;
					} else {
						System.out.println("Application Closed");
						System.exit(0);
					}

				} else if (mainMenuOption == 2) {
					System.out.println("");
					System.out.println("Press 1 To Add A File In The Directory");
					System.out.println("Press 2 To Delete A Specific File");
					System.out.println("Press 3 To Search For A Specific File");
					System.out.println("Press 4 To Return To Main Menu");
					System.out.println("");
					System.out.println("Enter your option(1-4)");
					innerMenuOption = Integer.parseInt(sc.next());

					if (innerMenuOption == 1) {
						System.out.println("");
						System.out.println("Enter File Name");
						filename = sc.next();
						result =objFileManagement.createFile(filename);
						System.out.println(result);

						System.out.println("");
						System.out.println("Enter 1 To Return To Main Menu , 7 To Exit The Application");
						innerMenuOption = Integer.parseInt(sc.next());

						if (innerMenuOption == 1) {
							continue;
						} else {
							System.out.println("Application Closed");
							System.exit(0);
						}
					} else if (innerMenuOption == 2) {
						System.out.println("");
						System.out.println("Enter The File You Want To Delete");
						filename = sc.next();
						result = objFileManagement.fileDeletion(filename);
						System.out.println(result);

						System.out.println("");
						System.out.println("Enter 1 To Return To Main Menu , 7 To Exit The Application");
						innerMenuOption = Integer.parseInt(sc.next());

						if (innerMenuOption == 1) {
							continue;
						} else {
							System.out.println("Application Closed");
							System.exit(0);
						}
					} else if (innerMenuOption == 3) {
						System.out.println("");
						System.out.println("Enter The File You Want To Search");
						filename = sc.next();
						objFileManagement.searchFile(filename);
						System.out.println("");
						System.out.println("Enter 1 To Return To Main Menu , 7 To Exit The Application");
						innerMenuOption = Integer.parseInt(sc.next());

						if (innerMenuOption == 1) {
							continue;
						} else {
							System.out.println("Application Closed");
							System.exit(0);
						}
					} else {
						continue;
					}
				} else {
					System.out.println("Application closing");
					System.exit(0);
				}
			} catch (NumberFormatException e) {
				System.err.println("Please Enter Numeric Characters Only");
			} catch (IOException e) {
				System.err.println(e.toString());
			}

		} while (mainMenuOption != 3);

	}

}
