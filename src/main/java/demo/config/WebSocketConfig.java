package demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
// This indicates that this configuration class is not only configuring WebSocket, 
// but it’s configuring broker-based STOMP messaging
@EnableWebSocketMessageBroker 
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
	
	// It’s the endpoint that a client would connect to before
	// subscribing to or publishing to a destination path
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/hello").withSockJS();
	}
	
	// WebSocketStompConfig also configures a simple message broker by overriding the
	// configureMessageBroker() method. This method is optional. If you don’t override
	// it, you’ll get a simple in-memory message broker configured to handle messages prefixed
	// with /topic
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		// the broker destinations are prefixed with either /topic or /queue.
		
		//registry.enableSimpleBroker("/queue", "/topic");
		config.enableSimpleBroker("/topic");
		
		// the application destinations are prefixed with /app.
		config.setApplicationDestinationPrefixes("/app");
	}

}


