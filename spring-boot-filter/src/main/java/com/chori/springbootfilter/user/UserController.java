package com.chori.springbootfilter.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user")
    public User currentUser() {
        User user = new User();
        user.setAge(20);
        user.setName("chori");
        user.setHeight(176);

        return user;
    }
}
