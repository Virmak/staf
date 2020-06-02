package com.sparkit.staf.application.models.response;

import lombok.Data;

@Data
public class WebSocketHandshakeResponse {
    private String message;

    public WebSocketHandshakeResponse(String message) {
        this.message = message;
    }
}
