package com.houseone.playerinfo.model;

import lombok.Data;

@Data
public class Biometrics {

    // height in inches
    private int height;

    // weight in lbs
    private int weight;

    private ShootingHand shootingHand;

    enum ShootingHand {
        RIGHT,
        LEFT;
    }
}
