package com.dimag.ai.jsonObjects;


/*
 * Created by Ishan Bakshi
 * ishan.bakshi@gmail.com
 */
public class BaseObject {

	public static final String finalKey ="testUser_c16af640-619c-4336-b15a-4f42aab34c45";
	private String userKey; 
	
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	private String humanMessage;
	
	public String getHumanMessage() {
		return humanMessage;
	}
	public void setHumanMessage(String humanMessage) {
		this.humanMessage = humanMessage;
	}
	public String getUserKey() {
		return userKey;
	}
}
