package com.shiva.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class PrincipalRestController {

    @PostMapping("/user")
    Principal principal(Principal principal) {
        return principal;
    }
}