/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fouilledetext;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class MyTweets{

static BaseOfTweets x = new BaseOfTweets();
private static List<TweetClass> liste;	
private static BaseOfTweets base;
	

	public static List<TweetClass> initialiser() {
		base = new BaseOfTweets();
		return liste = new ArrayList<TweetClass>();
	}
	
	public static List<TweetClass> lectureCSV(String path) throws ParseException {
		
		try {
			BufferedReader lire = new BufferedReader(new FileReader(path));
			
			String lecture = lire.readLine();
			//System.out.println("Dans try de lecture CSV");
			while(lecture != null) {
				//System.out.println("hi");
				String[] attributs  = lecture.split("\t");
				TweetClass tweet = TweetClass.creationTweet(attributs);	
				liste.add(tweet); //Rajouter les tweets à notre liste d'objet TweetClass
				lecture = lire.readLine();
				}
			}
			
			 catch(IOException e) {
			e.printStackTrace();
		}
		
	return liste;
	}
	
	
	
	public static void main(String[] args) throws ParseException {
            
		System.out.println("Que Souhaitez-vous faire?\n1- Afficher les tweets\n2- Afficher les tweets (en étant trier par années)"
				+ "\n3- Afficher les tweets (en étant trier par noms d'utilisateurs)"
				+ "\n4- Afficher les tweets (en étant trier par nombre de retweets)"+
				"\n5- Recherche de mot"
				+ "\n6- Quitter");
		Scanner sc = new Scanner(System.in);
	
		int choix = sc.nextInt();
		
		Scanner y = new Scanner(System.in);
		String ch_;
		
			switch(choix) {
			case 1: /* Afficher les Tweets */
				System.out.println("Insérez le chemin qui mène au fichier.");
				ch_ = y.nextLine();
				
				initialiser();
				base.afficher(lectureCSV(ch_));
				break;
			case 2:
				System.out.println("Insérez le chemin qui mène au fichier.");
				ch_ = y.nextLine();
				
				System.out.println("\n*** Affichage de la base de données triées selon les dates ***\n");
				initialiser();
				System.out.println(base.trier_par_annee(lectureCSV(ch_)));
				break;
			case 3:
				System.out.println("Insérez le chemin qui mène au fichier.");
				ch_ = y.nextLine();
				
				System.out.println("\n*** Affichage de la base de données triées selon les noms ***\n");
				initialiser();
				System.out.println(base.trier_par_nom(lectureCSV(ch_)));
				break;
			case 4:
				System.out.println("Insérez le chemin qui mène au fichier.");
				ch_ = y.nextLine();
				
				System.out.println("\n*** Affichage de la base de données triées selon les retweets ***\n");
				initialiser();
				System.out.println(base.trier_nbr_retweet(lectureCSV(ch_)));
				break;
			case 5:
				System.out.println("Insérez le chemin qui mène au fichier.");
				ch_ = y.nextLine();
				System.out.println("xx");
				System.out.println("Insérez le mot que vous recherchez");
				String mot = y.nextLine();
				initialiser();
				System.out.println(base.trouver_mot(lectureCSV(ch_), mot));
				break;
			case 6: break;
			
			default : break;
			}
		
	}
	
}