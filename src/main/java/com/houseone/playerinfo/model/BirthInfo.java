package com.houseone.playerinfo.model;

import lombok.Data;

import java.util.Date;

@Data
public class BirthInfo {

    private Date birthday;
    private Location location;
}
