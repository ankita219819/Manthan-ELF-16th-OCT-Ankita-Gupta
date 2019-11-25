package com.manthan.musicplayer;

import java.util.Scanner;

import com.manthan.musicplayer.databseImpl.OperationCurd;
import com.manthan.musicplayer.databseImpl.Operations;
import com.manthan.musicplayer.databseImpl.SelectSongs;

public class MusicPlayer extends Thread {

	public static void main(String[] args) {

		Operations operations=new Operations();//consist of search operation
		SelectSongs selectSongs=new SelectSongs();//consist of playing all songs in order or playing randomly
		OperationCurd curd=new OperationCurd(); //consist of delete update operations
		int choice;
		String sub_choice;
		String curdCh;
		boolean flag=true;
		String song_name;
		String artist;
		String album;
		String des;
		String location;
		String updCh;

		System.out.println("\t\t\t\t\t~~~~~~~~~~WELCOM TO MY MUSIC PLAYER~~~~~~~~~~~~~");
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("\n\nPLEASE SELECT THE OPTIONS SHOWN BELOW");
			System.out.println("1. Play a Song\n2. Search a Song\n3. Show all Songs\n4. Operate all songs\n5. To exit press 0");	
			choice=sc.nextInt();

			switch (choice) {
			
			case 1:
				System.out.println("\n\nPLEASE SELECT THE OPTIONS SHOWN BELOW");
				System.out.println("A. Play all Song\nB. Play song Randomly\nC. Show selected Songs");
				sub_choice=sc.next();
				switch (sub_choice) {
				
				case "A": selectSongs.allSongs();
				break;
				
				case "B":selectSongs.randomSongs();
				break;
				
				case "C": operations.search();
					try {
						System.out.println("playing...");
						Thread.sleep(20000);
						System.out.println("Done");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				break;

				default: System.out.println("----INVALID CHOICE---");
				break;
				}//end of inner switch case

				break;
			case 2: operations.search();
			break;
			
			case 3: selectSongs.allSongs();
			break;

			case 4:
				System.out.println("Lets update...");
				System.out.println("\tIf want to delete press 'd'...\n\tIf want to insert press 'i'... \n\tIf want to update press 'u'...");
				curdCh=sc.next();
				if(curdCh.compareTo("d")==0) {
					curd.deleteSong();
				}
				if(curdCh.compareTo("i")==0) {
					operations.insertSongs();
				}
				if(curdCh.compareTo("u")==0) {
					
					System.out.println("\tIf want to update artist press 'A'...\n\tIf want to update location press 'L'... \n\tIf want to update description press 'D'...");
					updCh=sc.next();
					if(updCh.compareTo("A")==0) {
						System.out.print("\n\t Enter Song Name: ");
						song_name=sc.next();
						
						System.out.print("\n\t Enter the Artist name: ");
						artist=sc.next();
						curd.updateSong(artist, song_name);
					}
					else if(updCh.compareTo("L")==0) {
						System.out.print("\n\t Enter Song Name: ");
						song_name=sc.next();
						
						System.out.print("\n\t Enter the Location: ");
						location=sc.next();
						curd.updateSongLoc(location, song_name);
					}
					else if(updCh.compareTo("D")==0) {
						System.out.print("\n\t Enter Song Name: ");
						song_name=sc.next();
						
						System.out.print("\n\t Enter the Description: ");
						des=sc.next();
						curd.updateSongDes(des, song_name);
					}
					
					
				}
				break;
			case 0: flag=false;
			break;
			default:
				System.out.println("----INVALID CHOICE---");
				break;
			}//end of switch
		}while(flag);
		System.out.println("*****Thank You for using******");


	}//end of main

}//end of class
