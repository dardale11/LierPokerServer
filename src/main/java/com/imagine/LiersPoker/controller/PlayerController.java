package com.imagine.LiersPoker.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imagine.LiersPoker.models.Card;
import com.imagine.LiersPoker.models.Hand;
import com.imagine.LiersPoker.models.Tryout;
import com.imagine.LiersPoker.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/player")
public class    PlayerController {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    PlayerService playerService;

    /*
    raiseHand
    + updates games state after a player raises
    @params
        -id: player's id
        -hand: player's new hand
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/raise", method = RequestMethod.POST)
    public ResponseEntity<String> raiseHand(@RequestBody String handAsString) throws JsonProcessingException {
        Hand hand = objectMapper.readValue(handAsString, Hand.class);
        playerService.raiseHand(hand);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<String> test() {
        System.out.println("innnnn");
        return new ResponseEntity<>("dari", HttpStatus.OK);
    }
//
//    /*
//  callBluff
//  + updates games state after a player calls bluff
//  @params
//      -id: player's id
//   */
//    @RequestMapping(value = "/bluff/{_id:[\\d]+}", method = RequestMethod.POST)
//    public ResponseEntity<String> callBluff(@PathVariable("_id") Long id) {
//        return new ResponseEntity<>("dari", HttpStatus.OK);
//    }
//
//
//    /*
//  getGameState
//  + returns games state (client polling)
//   */
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public ResponseEntity<String> getGameState() {
//        return new ResponseEntity<>("dari", HttpStatus.OK);
//    }
//

}
