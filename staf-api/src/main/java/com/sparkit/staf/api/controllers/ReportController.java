package com.sparkit.staf.api.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {
    @GetMapping("/reports")
    public String report(Model model) {
        return "report";
    }
}
