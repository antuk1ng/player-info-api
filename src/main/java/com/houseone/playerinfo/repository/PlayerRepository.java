package com.houseone.playerinfo.repository;

import com.houseone.playerinfo.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PlayerRepository extends MongoRepository<Player, String> {

    @Query("{$and: [{'name.firstName': {$regex: '?0'}}, {'name.lastName': {$regex: '?1'}}]}")
    List<Player> findPlayerByName(String firstName, String lastName);
}
