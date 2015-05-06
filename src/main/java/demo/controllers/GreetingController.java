package demo.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import demo.other.Greeting;
import demo.other.HelloMessage;

@Controller
public class GreetingController {
	
	// The @MessageMapping annotation ensures that if a message is sent to destination "/hello", 
	// then the greeting() method is called.
	@MessageMapping("/hello")
	// The return value is broadcast to all subscribers to "/topic/greetings" 
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		// simulated delay
		Thread.sleep(3000); 
	  return new Greeting("Hello, " + message.getName() + "!");
	}

}
