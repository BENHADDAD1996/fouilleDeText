/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fouilledetext;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseOfTweets {
	
//	public final static String ch = "C:/Users/Shuriken/Desktop/Julien Velcin Java/java Projet/Foot.txt";		

	
	public void afficher(List<TweetClass> e) {
		for (TweetClass i : e) {
			System.out.println(i.toString());
		}
	}
	
	public static List<TweetClass> trier_par_annee(List<TweetClass> e) {
		Collections.sort(e);
		return e;
	}
	
	public static List<TweetClass> trier_par_nom(List<TweetClass> e) {
		Collections.sort(e, new Comparator<TweetClass>() {
			public int compare(TweetClass o1, TweetClass o2) {
				return o1.getUsername().compareTo(o2.getUsername());
			}
		});
		return e;
	}
	

	public static List<TweetClass> trier_nbr_retweet(List<TweetClass> e) {
		Map<String, Integer> tab_rt = new HashMap();
		List<TweetClass> liste = new ArrayList<TweetClass>();
		String x;
		for(TweetClass i : e) {
			x = i.getRTU();
			if (tab_rt.containsKey(x)) {
				tab_rt.put(x, tab_rt.get(x)+1);
			} else {
				tab_rt.put(x, 1);
			}
		}
		
		Collections.sort(e,  new Comparator<TweetClass>() {

			@Override
			public int compare(TweetClass arg0, TweetClass arg1) {
				String rtu_0 = arg0.getRTU();
				String rtu_1 = arg1.getRTU();
				
				arg0.setP(tab_rt.get(rtu_0));
				arg1.setP(tab_rt.get(rtu_1));
				
				return arg0.getP().compareTo(arg1.getP());
			}
			
		});
			return e;
		}
	
	public static String trouver_mot(List<TweetClass> a, String mot) {
		List<TweetClass> tweets = new ArrayList<TweetClass>();
			for(TweetClass e : a) {
				if (e.getContent().contains(mot)) {
					tweets.add(e);
				}
			}
		return tweets.toString();
	}
}

