package com.imagine.LiersPoker.services;

import com.imagine.LiersPoker.models.Hand;

public interface PlayerService {

    void raiseHand(Hand hand);

    boolean validateHand(Hand hand);


}
