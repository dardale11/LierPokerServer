package com.imagine.LiersPoker.controller;

import com.imagine.LiersPoker.models.Lobby;
import com.imagine.LiersPoker.models.LoginParameters;
import com.imagine.LiersPoker.models.PlayRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    Lobby lobby;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody LoginParameters loginParameters) {
        System.out.println("nitz: "+loginParameters.toString());
        PlayRoom playRoom= lobby.AddPlayerToRoom(loginParameters.getUserName(),loginParameters.getRoomNumber());
        return new ResponseEntity(playRoom, HttpStatus.OK);
    }
}
