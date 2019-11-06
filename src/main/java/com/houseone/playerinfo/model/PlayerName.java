package com.houseone.playerinfo.model;

import lombok.Data;

import java.util.Set;

@Data
public class PlayerName {

    private String firstName;
    private String lastName;
    private String fullName;
    private Set<String> nicknames;
}
