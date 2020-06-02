package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.models.request.WebSocketHandshakeRequest;
import com.sparkit.staf.application.models.response.WebSocketHandshakeResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class LogController {
    @MessageMapping("/hello")
    @SendTo("/staf/logs")
    public WebSocketHandshakeResponse handshake(WebSocketHandshakeRequest message) throws Exception {
        return new WebSocketHandshakeResponse("hello");
    }
}
