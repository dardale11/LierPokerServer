package com.imagine.LiersPoker.services;

import com.imagine.LiersPoker.models.Hand;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class PlayerServiceImpl implements PlayerService{
    @Autowired
    GameService gameService;

    @Override
    public void raiseHand(Hand hand) {
        gameService.getNewHand(hand);
    }

    @Override
    public boolean validateHand(Hand hand) {
        return false;
    }
}
