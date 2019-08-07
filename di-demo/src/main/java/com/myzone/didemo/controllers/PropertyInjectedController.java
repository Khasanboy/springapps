package com.myzone.didemo.controllers;

import com.myzone.didemo.services.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    String sayHello() {
        return greetingService.sayGreeting();
    }
}
