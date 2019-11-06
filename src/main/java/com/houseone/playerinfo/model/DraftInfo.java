package com.houseone.playerinfo.model;

import lombok.Data;

import java.util.Date;

@Data
public class DraftInfo {

    private Date date;
    private int round;
    private int position;
    private int overallPosition;
    private String team;
}
