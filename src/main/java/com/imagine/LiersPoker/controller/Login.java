package com.imagine.LiersPoker.controller;

import com.imagine.LiersPoker.models.Hand;
import com.imagine.LiersPoker.models.LoginParameters;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class Login {


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody LoginParameters loginParameters) {
        System.out.print("nitz: "+loginParameters);
        return new ResponseEntity<>("Nitzan is the king of login", HttpStatus.OK);
    }
}
