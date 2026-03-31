package com.example.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

   @GetMapping("/contact")
    public String getContactInfo(){

        return "Call : =91 92 93 94 95";
    }

    @GetMapping("/msg")
    public String getMsg(){

        return "Good Morning";
    }
}
