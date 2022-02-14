package com.redhat.example.rhssodemo;

import javax.annotation.security.RolesAllowed;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RhssoController {

     @RequestMapping(value = "/anonymous", method = RequestMethod.GET)
    public ResponseEntity<String> getAnonymous() {
        return ResponseEntity.ok("Hello Anonymous");
    }

    @RolesAllowed("app-user")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("Hello User");
    }

    @RolesAllowed("app-admin")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ResponseEntity<String> getAdmin() {
        return ResponseEntity.ok("Hello Admin");
    }

    @RolesAllowed({"app-admin", "app-user"})
    @RequestMapping(value = "/all-user", method = RequestMethod.GET)
    public ResponseEntity<String> getAllUser() {
        return ResponseEntity.ok("Hello All User");
    }

    @GetMapping("/hello")
    public String getHelloWorld() {
        return "Hello world";
    }
}
