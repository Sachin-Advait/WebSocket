package com.sachin.SocketServer.config;

import com.sachin.SocketServer.controller.WebSocketController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
  private final WebSocketController webSocketController;

  public WebSocketConfig(WebSocketController webSocketController) {
    this.webSocketController = webSocketController;
  }

  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry.addHandler(this.webSocketController, "/websocket").setAllowedOrigins("*");
  }

  @Bean
  public WebSocketHandler videoCallHandler() {
    return new WebSocketController();
  }
}
