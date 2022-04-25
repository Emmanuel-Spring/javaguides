package com.talentyco.shopping;

import com.talentyco.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SpringEshoppingAppStartupRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        userService.createUser("admin", "admin", "admin@admin.cl", Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
    }
}
