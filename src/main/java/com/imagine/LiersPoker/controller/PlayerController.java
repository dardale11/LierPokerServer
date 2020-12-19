package com.imagine.LiersPoker.controller;


import com.imagine.LiersPoker.models.Hand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class    PlayerController {
    /*
    raiseHand
    + updates games state after a player raises
    @params
        -id: player's id
        -hand: player's new hand
     */
    @RequestMapping(value = "/raise/{_id:[\\d]+}", method = RequestMethod.POST)
    public ResponseEntity<String> raiseHand(@PathVariable("_id") Long id, @RequestBody Hand hand) {
        return new ResponseEntity<>("dari", HttpStatus.OK);
    }

    /*
  callBluff
  + updates games state after a player calls bluff
  @params
      -id: player's id
   */
    @RequestMapping(value = "/bluff/{_id:[\\d]+}", method = RequestMethod.POST)
    public ResponseEntity<String> callBluff(@PathVariable("_id") Long id) {
        return new ResponseEntity<>("dari", HttpStatus.OK);
    }


    /*
  getGameState
  + returns games state (client polling)
   */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<String> getGameState() {
        return new ResponseEntity<>("dari", HttpStatus.OK);
    }


}
