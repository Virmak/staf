package com.sparkit.staf.application.models.response;

import lombok.Data;

@Data
public class CreateProjectResponse {
    private String result;
    public CreateProjectResponse(String result) {
        this.result = result;
    }
}