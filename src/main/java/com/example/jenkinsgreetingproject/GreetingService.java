package com.example.jenkinsgreetingproject;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getGreeting(String name) {
        return "Bonjour, " + name + " ! Bienvenue dans notre service de salutation.";
    }
}