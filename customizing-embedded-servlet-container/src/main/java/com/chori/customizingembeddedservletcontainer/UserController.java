package com.chori.customizingembeddedservletcontainer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public String user() {
        return "chori";
    }
}
