package com.dimag.ai;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.dimag.ai.jsonObjects.BaseObject;
import com.dimag.ai.jsonObjects.ResponseObject;

/**
 * Created by Ishan Bakshi
 * ishan.bakshi@gmail.com
 * Handles requests for the application home page.
 */
@Controller
@EnableWebMvc
@RequestMapping("")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/chatToBot", method = RequestMethod.GET)
	public @ResponseBody
	ResponseObject chatToBot(@ModelAttribute("humanRequest")  BaseObject humanRequest) throws Exception {
			ResponseObject responseObject = new ResponseObject();
			logger.info("entered chatToBot");
			//authenticate user
			if(humanRequest!=null && humanRequest.getUserKey()!=null 
					&& humanRequest.getUserKey().equals(humanRequest.finalKey)
					&& (humanRequest.getHumanMessage()!=null || !humanRequest.getHumanMessage().isEmpty())){
				String botname="shelly";
				//local pather, change on server
				String path = "/home/ubuntu/bots/program-ab-0.0.4.3";
				//String path ="";
				Bot bot = new Bot(botname, path);
				Chat chatSession = new Chat(bot);
				String request = humanRequest.getHumanMessage();
				String response = chatSession.multisentenceRespond(request); 
				responseObject.setBotReply(response);
				System.out.println(response);
			}else if(humanRequest!=null && humanRequest.getHumanMessage()!=null || !humanRequest.getHumanMessage().isEmpty()){
				responseObject.setBotReply("you just sent a blank message to me ");
			}else{
				responseObject.setBotReply("I am sorry , I don't talk to Strangers. Please authenticate yourself!!!");
			}
			
			logger.info("exiting chatToBot with  respone ="+ responseObject.getBotReply());
		return responseObject;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/link", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	
}
