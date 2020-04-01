package com.sparkit.staf.api.models.response;

import lombok.Data;

@Data
public class CreateProjectResponse {
    private String result;
    public CreateProjectResponse(String result) {
        this.result = result;
    }
}
