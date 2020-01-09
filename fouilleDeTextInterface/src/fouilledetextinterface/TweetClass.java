/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fouilledetextinterface;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TweetClass implements Comparable {

	public static final DateTimeFormatter time_pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");	
	private Long tweet_id;
	private String tweet_username;
	private LocalDateTime tweet_time;
	private String tweet_content;
	private String tweet_rt;
	private String rt_user;
	private Integer priorite = 0;
	
	public TweetClass(Long tweet_id, String tweet_username, LocalDateTime tweet_time, String tweet_content, String tweet_rt,
			String rt_user) {
		this.tweet_id = tweet_id;
		this.tweet_username = tweet_username;
		this.tweet_time = tweet_time;
		this.tweet_content = tweet_content;
		this.tweet_rt = tweet_rt;
		this.rt_user = rt_user;
	}
	
	public void setP(int priorite) {
		this.priorite = priorite;
	}
	
	public Integer getP() {
		return this.priorite;
	}
	
	public String getRTU() {
		return this.rt_user;
	}
	
	public void setRTU(String rt_user) {
		this.rt_user = rt_user;
	}
	
	public Long getID() {
		return this.tweet_id;
	}
	
	public String getUsername() {
		return this.tweet_username;
	}
	
	public LocalDateTime getTime() {
		return this.tweet_time;
	}
	
	public String getContent() {
		return this.tweet_content;
	}
	
	public String getRT() {
		return this.tweet_rt;
	}
	
	public void setID(Long tweet_id) {
		this.tweet_id = tweet_id;
	}
	
	public void setUsername(String tweet_username) {
		this.tweet_username = tweet_username;
	}
	
	public void setTime(LocalDateTime tweet_time) {
		this.tweet_time = tweet_time;
	}
	
	public void setContent(String tweet_content) {
		this.tweet_content = tweet_content;
	}
	
	public void setRT(String tweet_rt) {
		this.tweet_rt = tweet_rt;
	}
	
	
	public String toString() {
		return "\n[Tweet]\nID : "+this.tweet_id+"\nUtilisateur : "+this.tweet_username+"\nDate : "+this.tweet_time+
				"\nContenu : "+this.tweet_content+"\nRetweet : "+this.tweet_rt+"\nUtilisateur retweeté : "+this.rt_user+"\n";
	}

	
	public static TweetClass creationTweet(String[] attributs) throws ParseException {
		Long tweet_id =  Long.parseLong(attributs[0]);
		String tweet_username = String.valueOf(attributs[1]);
		LocalDateTime tweet_time = LocalDateTime.parse(attributs[2], time_pattern);
		
		String contenu = attributs[3];
		String[] retweet_link = attributs[3].split("\\s+");
		
		String tweet_content = String.valueOf(contenu);
		String tweet_rt = retweet_link[retweet_link.length-1];
		String rt_user;
		
		try {
			if(!attributs[4].toString().isEmpty()) {
				rt_user = attributs[4].toString();
			} else {
				rt_user = null;
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			rt_user = null;
		}
		return new TweetClass(tweet_id, tweet_username, tweet_time, tweet_content, tweet_rt, rt_user);
	}

	@Override
	public int compareTo(Object arg0) {
		
		TweetClass o = (TweetClass) arg0;
		return this.getUsername().compareTo(o.getUsername());
	} 

}
