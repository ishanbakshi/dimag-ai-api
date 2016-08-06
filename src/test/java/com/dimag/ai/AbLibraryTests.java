package com.dimag.ai;

import static org.junit.Assert.*;

import org.alicebot.ab.*;
import org.junit.Test;

public class AbLibraryTests {

	@Test
	public void test() {
		String botname="test";
		//local pather, change on server
		String path = "**/bots/program-ab-0.0.4.3";
		Bot bot = new Bot(botname, path);
		Chat chatSession = new Chat(bot);
		
		String request = "Hi, who are you?";
		String response = chatSession.multisentenceRespond(request); 
		System.out.println(response);

		//fail("Not yet implemented");
	}

}
